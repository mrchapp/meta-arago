require recipes-kernel/linux-libc-headers/linux-libc-headers.inc

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:${COREBASE}/meta/recipes-kernel/linux-libc-headers/${PN}"

PR = "r0"

SRC_URI += " file://connector-msg-size-fix.patch"
SRC_URI[md5sum] = "c3883760b18d50e8d78819c54d579b00"
SRC_URI[sha256sum] = "63e237de3b3c4c46a21833b9ce7e20574548d52dabbd1a8bf376041e4455d5c6"

