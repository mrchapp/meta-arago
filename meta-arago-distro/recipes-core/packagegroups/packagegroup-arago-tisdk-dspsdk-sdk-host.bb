DESCRIPTION = "Task to install additional scripts and applications into the SDK"
LICENSE = "MIT"
PR = "r5"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# Choose the kernel and u-boot recipe sources to use

U-BOOT_SRC = "${PREFERRED_PROVIDER_virtual/bootloader}-src"
KERNEL_SRC = "${PREFERRED_PROVIDER_virtual/kernel}-src"

TOOLS = "pinmux-utility"
TOOLS_da830-omapl137-evm = "pinmux-utility-da830 serial-flasher"
TOOLS_am37x-evm_append = " flash-utility"
TOOLS_am3517-evm_append = " flash-utility"

EXAMPLE_APPLICATIONS = "\
    gst-plugin-tipafsink-src \
    pa-image-i12nonip-src \
    pa-utils-src \
    streamapp-src \
"

RDEPENDS_${PN} = "\
    ${TOOLS} \
    ${EXAMPLE_APPLICATIONS} \
    ti-tisdk-setup \
    ti-tisdk-makefile \
    ${U-BOOT_SRC} \
    ${KERNEL_SRC} \
"
