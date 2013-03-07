DESCRIPTION = "Task to install additional packages only used in the Arago SDK"
LICENSE = "MIT"
PR = "r1"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Out of Box Experience (OOBE)
OOBE = ""

EXTRA_APPLICATIONS = "\
    streamapp \
    gst-plugin-tipafsink \
    ti-dsplink-module \
    pa-image-i12nonip \
"

RDEPENDS_${PN} = "\
    mount-sdcard \
    ${OOBE} \
    ${EXTRA_APPLICATIONS} \
"
