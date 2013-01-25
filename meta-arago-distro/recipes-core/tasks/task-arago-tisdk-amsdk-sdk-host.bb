DESCRIPTION = "Task to install additional scripts and applications into the SDK"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r2"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Choose the kernel and u-boot recipe sources to use
U-BOOT_SRC := "${PREFERRED_PROVIDER_virtual/bootloader}-src"
KERNEL_SRC := "${PREFERRED_PROVIDER_virtual/kernel}-src"

TOOLS = "pinmux-utility"

TOOLS_am37x-evm += "flash-utility"
TOOLS_am3517-evm += "flash-utility"

RDEPENDS_${PN} = "\
    ${TOOLS} \
    ti-tisdk-setup \
    board-port-labs-src \
    ti-tisdk-makefile \
    ${U-BOOT_SRC} \
    ${KERNEL_SRC} \
"
