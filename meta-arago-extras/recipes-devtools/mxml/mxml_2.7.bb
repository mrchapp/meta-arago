HOMEPAGE = "http://home.comcast.net/~SCSIguy/SCSI_FAQ/RMiller_Tools/dt.html"
DESCRIPTION = "The Data Test Program (dt) is a generic data test program used to verify proper \
operation of peripherals, file systems, device drivers, or any data stream supported by the \
operating system."

SECTION = "console/tests"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6ba38606d63bb042c5d8cfee182e120"

inherit autotools

SRC_URI = "svn://svn.easysw.com/public/mxml/;module=trunk;protocol=http;rev=446;user=anonymous;pswd=''"

S = "${WORKDIR}/trunk"

PARALLEL_MAKE = ""
