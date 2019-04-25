SUMMARY = "KISS FFT"
DESCRIPTION = "a Fast Fourier Transform (FFT) library that tries to Keep it Simple, Stupid"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"
AUTHOR = "Bernardo A. Rodrigues <bernardoar@protonmail.com>"

SRC_URI = "git://github.com/berndporr/kiss-fft.git;tag=1.0.0"

inherit cmake

S = "${WORKDIR}/git"
