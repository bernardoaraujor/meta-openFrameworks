SUMMARY = "openFrameworks is an open source toolkit designed for creative coding"
DESCRIPTION = "openFrameworks is written in C++ and built on top of OpenGL. It runs on Microsoft Windows, macOS, Linux, iOS, Android and Emscripten. It is maintained by Zachary Lieberman, Theo Watson and Arturo Castro with contributions by other members of the openFrameworks community. "
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
AUTHOR = "Bernardo A. Rodrigues <bernardoar@protonmail.com>"

SRC_URI = "git://github.com/openframeworks/openFrameworks.git;protocol=https;tag=0.9.0"

S = "${WORKDIR}/git"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad gstreamer1.0-omx gtk+3 freeglut alsa-lib libxmu libxxf86vm mesa libraw1394 libdrm glew openal-soft libsndfile1 freeimage cairo freetype openssl pulseaudio opencv mesa assimp rtaudio boost ffmpeg mpg123"

inherit pkgconfig

PLATFORM_OS = "Linux"
HOST_OS = "Linux"

PLATFORM_ARCH = "${TARGET_ARCH}"

do_compile(){
    cd ${S}/libs/openFrameworksCompiled/project/
    PLATFORM_ARCH=${TARGET_ARCH} make
}
