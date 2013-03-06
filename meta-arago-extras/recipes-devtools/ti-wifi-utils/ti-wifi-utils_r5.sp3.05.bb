require ti-wifi-utils.inc

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=4725015cb0be7be389cf06deeae3683d"

inherit update-rc.d
INITSCRIPT_NAME="calibrate.sh"
INITSCRIPT_PARAMS = "start 20 2 3 4 5 ."

PR_append ="a+gitr${SRCPV}"

SRCREV = "ol_R5.SP3.05"
SRC_URI += "file://calibrate.sh"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/calibrate.sh ${D}${sysconfdir}/init.d
}