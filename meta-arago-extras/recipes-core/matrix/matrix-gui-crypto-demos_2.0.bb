DESCRIPTION = "Cryptography demo descriptions for Matrix v2"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps"
LICENSE = "CC-BY-SA"

require matrix-gui-apps-git.inc

PR = "${INC_PR}.3"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SUPPORT_OPENSSL_C_DEMOS = "NO"
SUPPORT_OPENSSL_C_DEMOS_ti33x = "YES"


S= "${@base_contains('SUPPORT_OPENSSL_C_DEMOS','YES','${WORKDIR}/git/cryptos_apps_program','${WORKDIR}/git/cryptos_apps_scripts',d)}"


FILES_${PN} += "${MATRIX_BASE_DIR}/*"

# Make sure crypto submenu and app images has been installed. Also make sure openssl is available
RDEPENDS_${PN} += "matrix-gui-apps-images matrix-gui-submenus-cryptos openssl"

RDEPENDS_${PN} += "${@base_contains('SUPPORT_OPENSSL_C_DEMOS','YES','ti-crypto-examples','',d)}"
