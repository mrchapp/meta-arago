SECTION = "kernel"
DESCRIPTION = "Latest Linux 3.3 stable kernel release"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

KERNEL_IMAGETYPE = "uImage"

inherit kernel

S = "${WORKDIR}/git"

BRANCH = "linux-3.3.y"

SRCREV = "v3.3.7"
PV = "3.3.7"

# Currently only beagleboard is ready to be pulled from the stable kernel
COMPATIBLE_MACHINE = "beagleboard"

EXTRA_OEMAKE = "${PARALLEL_MAKE} "

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=${BRANCH} \
           file://defconfig"

# These are patches that are making their way upstream or are pulled back
# from upstream trees to make the stable kernel work without regressions.
# These patches should clear out when moving to the next stable kernel
# minor version.  i.e. 3.y.
SRC_URI += "file://0001-ARM-OMAP-Cleanup-Beagleboard-DVI-reset-gpio.patch \
            file://0001-ARM-OMAP2-UART-Fix-incorrect-population-of-default-u.patch \
           "

# Create the uImage symlink in /boot since by default beagleboard looks into
# the /boot directory for the uImage file instead of the first partition.
do_install_append() {
    cd ${D}/${KERNEL_IMAGEDEST} && ln -sf uImage-${KERNEL_VERSION} uImage
}
