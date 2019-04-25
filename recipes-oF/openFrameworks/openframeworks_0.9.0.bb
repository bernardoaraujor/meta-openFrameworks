SUMMARY = "openFrameworks is an open source toolkit designed for creative coding"
DESCRIPTION = "openFrameworks is written in C++ and built on top of many FLOSS multimedia libraries. It's core is maintained by Zachary Lieberman, Theo Watson and Arturo Castro with contributions by other members of the openFrameworks community. "
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
AUTHOR = "Bernardo A. Rodrigues <bernardoar@protonmail.com>"

SRC_URI = "git://github.com/openframeworks/openFrameworks.git;protocol=https;tag=0.9.0 \
           file://0001-adapt-openFrameworksCompiled-makefiles-to-oe.patch \
           file://0002-modify-config-linux-common-mk-to-compile-examples.patch \
           file://0003-rm-osxVideoRecorderExample.patch \
           "

FILES_${PN} = "/opt/openFrameworks"
S = "${WORKDIR}/git"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad gstreamer1.0-omx gtk+3 freeglut alsa-lib libxmu libxxf86vm mesa libraw1394 libdrm glew openal-soft libsndfile1 freeimage cairo freetype openssl pulseaudio opencv mesa assimp rtaudio boost ffmpeg mpg123 glfw poco tess2 kiss"

inherit pkgconfig

PLATFORM_OS = "Linux"
HOST_OS = "Linux"

EXTRA_OEMAKE = "\
                PLATFORM_ARCH=${TARGET_ARCH} \
                RECIPE_SYSROOT=${RECIPE_SYSROOT} \
                PROJECT_OPTIMIZATION_CFLAGS_RELEASE="" \
"

do_compile(){
    cd ${S}/libs/openFrameworksCompiled/project/
    oe_runmake Release
}

do_compile_examples(){
    cd ${S}/examples
    for category in $(ls -1d *)
    do
        if [ $category != "addons" ] && [ $category != "ios" ] && [ $category != "android" ]; then

                echo "CHANGED TO CATEGORY >"+$category
                cd $category
                for j in $(ls -1d *)
                do
                        echo ">>$j"
                        cd $j
                        cp ../../../scripts/templates/linux/Makefile .
                        oe_runmake Release
                        ret=$?
                        if [ $ret -ne 0 ];
                        then
                                echo "error compiling: " + $j
                        else
                                echo "successfully compiled :" + $j
                        fi
                        cd ../
                done
                cd ../
        fi
    done
}

do_install(){
    install -m 0755 -d ${D}/opt/openFrameworks
    cp -r ${S}/libs/openFrameworksCompiled/lib/linux/obj/Release/libs/openFrameworks/* ${D}/opt/openFrameworks
}

do_clean(){
    rm -rf ${WORKDIR}
}

addtask do_compile_examples before do_install after do_compile
