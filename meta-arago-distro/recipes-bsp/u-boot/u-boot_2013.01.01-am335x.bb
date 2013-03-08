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

PR = "r4+gitr${SRCPV}"

SRC_URI = "git://gitorious.ti.com/ti-u-boot/ti-u-boot.git;protocol=git \
           file://0001-net-spl-add-README-file-and-sample-debrick-scripts.patch \
           file://0002-am335x_evm-switch-to-ext3-for-MMC-SD.patch \
           file://0003-am335x_evm-fix-mmc-boot-environment-settings.patch \
           file://0004-am335x_evm-Add-USB-SPL-restore-flash-option.patch \
           file://0005-am335x_evm-Add-restore-flash-target-and-PG1.0-USB-SP.patch \
"

SRCREV = "c44c35e24b1532272118c58c57f658f21b72a4dd"

S = "${WORKDIR}/git"

UBOOT_SUFFIX = "img"

# Compiling is failing when multiple jobs are enabled.
PARALLEL_MAKE = ""

# Set the name of the SPL that will built so that it is also packaged with u-boot.
SPL_BINARY = "MLO"
