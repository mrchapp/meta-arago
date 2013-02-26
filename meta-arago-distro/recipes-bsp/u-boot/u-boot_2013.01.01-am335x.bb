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
UVER = "2013.10"
###################################################

DEFAULT_PREFERENCE = "-1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r0+gitr${SRCPV}"

SRC_URI = "git://gitorious.ti.com/ti-u-boot/ti-u-boot.git;protocol=git;branch=${BRANCH} \
           file://0001-net-spl-add-README-file-and-sample-debrick-scripts.patch \
           file://0002-am335x_evm-Switch-to-ext3-for-MMC-SD.patch \
           file://0003-am335x_evm-fix-mmc-boot-environment-settings.patch \
           file://0004-am335x_evm-Fixup-some-configurations-and-environment.patch \
"

BRANCH = "ti-u-boot-2013.01.01"

SRCREV = "2460db0fc29a75f9d4cb18dbd427dc6719877aff"

S = "${WORKDIR}/git"

UBOOT_SUFFIX = "img"

# Set the name of the SPL that will built so that it is also packaged with u-boot.
SPL_BINARY = "MLO"
