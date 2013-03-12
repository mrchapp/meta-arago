MACHINE_KERNEL_PR_append = "-arago0"

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"

# KVER is used by arago-source-ipk.conf
KVER = "3.3"
PSPREL = "03.22.00.02.sdk"

require copy-defconfig.inc
require setup-defconfig.inc
