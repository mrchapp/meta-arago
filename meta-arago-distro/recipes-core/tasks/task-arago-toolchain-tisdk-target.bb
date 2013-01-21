DESCRIPTION = "Task to build and install header and libs into the sdk"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r2"

inherit task

RDEPENDS_${PN} = "\
    task-arago-qte-toolchain-target \
    task-arago-tisdk-multimedia-sdk-target \
    task-arago-tisdk-connectivity-sdk-target \
    task-arago-tisdk-crypto-sdk-target \
    ${@base_conditional('SUPPORTS_SGX', 'YES', 'task-arago-tisdk-graphics-sdk-target', '', d)} \
    task-arago-tisdk-addons-sdk-target \
"
