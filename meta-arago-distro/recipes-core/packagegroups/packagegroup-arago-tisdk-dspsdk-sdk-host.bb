DESCRIPTION = "Task to install additional scripts and applications into the SDK"
LICENSE = "MIT"
PR = "r5"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Choose the kernel and u-boot recipe sources to use

U-BOOT_SRC = "${PREFERRED_PROVIDER_virtual/bootloader}-src"
KERNEL_SRC = "${PREFERRED_PROVIDER_virtual/kernel}-src"

TOOLS = "pinmux-utility"
TOOLS_da830-omapl137-evm = ""
TOOLS_am37x-evm_append = " flash-utility"
TOOLS_am3517-evm_append = " flash-utility"

RDEPENDS_${PN} = "\
    ${TOOLS} \
    ti-tisdk-setup \
    board-port-labs-src \
    ti-tisdk-makefile \
    ${U-BOOT_SRC} \
    ${KERNEL_SRC} \
"