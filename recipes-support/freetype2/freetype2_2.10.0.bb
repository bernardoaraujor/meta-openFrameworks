SUMMARY = "FreeType 2"
DESCRIPTION = "The FreeType project is a team of volunteers who develop free, portable and high-quality software solutions for digital typography. They specifically target embedded systems and focus on bringing small, efficient and ubiquitous products. "
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
AUTHOR = "Bernardo A. Rodrigues <bernardoar@protonmail.com>"

SRC_URI = "https://download.savannah.gnu.org/releases/freetype/freetype-2.10.0.tar.bz2"
SRC_URI[md5sum] = "a717e6925b61b9dda946322ecd278a42"
SRC_URI[sha256sum] = "fccc62928c65192fff6c98847233b28eb7ce05f12d2fea3f6cc90e8b4e5fbe06"


S = "${WORKDIR}/git"

