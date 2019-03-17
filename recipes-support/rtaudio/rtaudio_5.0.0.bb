SUMMARY = "RtAudio - a set of C++ classes that provide a common API for realtime audio input/output across Linux"
DESCRIPTION = "RtAudio is a set of C++ classes that provides a common API (Application Programming Interface) for realtime audio input/output.  RtAudio significantly simplifies the process of interacting with computer audio hardware.  RtAudio incorporates the concept of audio streams, which represent audio output (playback) and/or input (recording).  Available audio devices and their capabilities can be enumerated and then specified when opening a stream.  Where applicable, multiple API support can be compiled and a particular API specified when creating an RtAudio instance.  See the \ref apinotes section for information specific to each of the supported audio APIs."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
AUTHOR = "Bernardo A. Rodrigues <bernardoar@protonmail.com>"

SRC_URI = "http://www.music.mcgill.ca/~gary/rtaudio/release/rtaudio-5.0.0.tar.gz"
SRC_URI[md5sum] = "517f7ad45ca5ecf2995ca5e6240b6722"
SRC_URI[sha256sum] = "799deae1192da52cc2c15a078ed3b42449580be7d096fe9bc841c5bba0289c57"

SRC_URI += "file://0001-disable-test-programs-in-configure.ac.patch"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

inherit autotools

S = "${WORKDIR}/rtaudio-5.0.0"

DEPENDS = " alsa-lib"

