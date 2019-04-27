SUMMARY = "Libtess2"
DESCRIPTION = "Game and tools oriented refactored version of GLU tesselator"

LICENSE = "SGI-2"
LIC_FILES_CHKSUM = "file://${S}/LICENSE.txt;md5=0788a91aa827d68f447dc011ed64727e"

SRC_URI = "git://github.com/memononen/libtess2;protocol=git;tag=v${PV}"
SRC_URI[md5sum] = "8321330d5ea78edbd4a9cefbef2545d9"
SRC_URI[sha256sum] = "bc04be4f3441406917123d3418a40fc29965cbb06db94ef53b31f98acebad3f2"

SRC_URI += " file://CMakeLists.txt"

inherit cmake

S = "${WORKDIR}/git"

do_configure_prepend(){
    cp ${WORKDIR}/CMakeLists.txt ${S}
}

do_install(){
    install -m 755 -d ${D}${libdir}
    cp ${WORKDIR}/build/libtess2.a ${D}${libdir}
}
