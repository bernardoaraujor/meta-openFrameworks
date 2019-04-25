DESCRIPTION = "GLFW is an Open Source, multi-platform library for creating windows with OpenGL contexts and receiving input and events."
AUTHOR = "Camilla Berglund"
HOMEPAGE = "http://www.glfw.org/"
LICENSE = "Zlib | Libpng"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=352912f8ce21ff7d8b592a4edbe48f50"

DEPENDS = "libpng libglu zlib libxi libxcursor libxinerama libxrandr"
REQUIRED_DISTRO_FEATURES = "x11"

inherit pkgconfig cmake distro_features_check

SRC_URI = "https://github.com/glfw/glfw/releases/download/${PV}/${PN}-${PV}.zip"
SRC_URI[md5sum] = "c4f6901c88ad0795f7c5da6b5599202f"
SRC_URI[sha256sum] = "2e661300ea4c06e460065d6e83177ab8e5139116022f40ff7ec2e1dddd4ef60f"

PR = "r0"

S = "${WORKDIR}/${PN}-${PV}"

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON -DLIB_SUFFIX=${@d.getVar('baselib', True).replace('lib', '')}"

FILES_${PN}-dev += "\
	${libdir}/cmake \
"
