# Use the version of u-boot.inc in oe-core not the meta-ti version
require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

# Reset OEMAKE. Current u-boot.inc sets -02 which breaks this version of u-boot's build.
# This issue was fixed in oe-core master by removing the -02 statement.
EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'

DESCRIPTION = "u-boot bootloader for ARM MPU devices"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

COMPATIBLE_MACHINE = "ti33x|omap3"

###################################################
# When this recipe is moved to meta-ti these changes should go in a bbappend in meta-arago-distro.

# PSPREL and UVER are used by arago-source-ipk.conf
PSPREL = "05.07.00.00"
UVER = "2013.01.01"

DEFAULT_PREFERENCE = "-1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r5+gitr${SRCPV}"

SRC_URI = "git://git.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH} \
"

BRANCH = "ti-u-boot-2013.01.01-amsdk-05.07.00.00"

# Commit corresponds to tag "v2013.01.01_amsdk-05.07.00.00"
SRCREV = "8eb15a787c558fee98b0fa2a66ff0849c732edcc"

S = "${WORKDIR}/git"

UBOOT_SUFFIX = "img"

# Set the name of the SPL that will built so that it is also packaged with u-boot.
SPL_BINARY = "MLO"
