DESCRIPTION = "Task to install wlan and bluetooth packages into the target FS"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r0"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"
ALLOW_EMPTY = "1"

# WLAN support packages.
# These are the packages that all platforms use for WLAN support
WLAN_COMMON = "\
    hostap-daemon \
    ti-wifi-utils \
    wireless-tools \
    htop \
    netperf \
    iw \
    crda \
    softap-udhcpd-config \
    oppserver \
    bluez-tools \
    obexd \
    pulseaudio \
    pulseaudio-server \
    pulseaudio-module-loopback \
    pulseaudio-module-bluetooth-discover \
    pulseaudio-module-bluetooth-device \
    eventdump \
    wpa-supplicant \
"

FIRMWARE_AND_DRIVERS = "\
    ti-compat-wireless-wl12xx \
    ti-compat-bluetooth \
    bt-firmware \
    bt-enable \
    wl12xx-firmware \
"

BLUETOOTH_STACK = "\
    bluez4 \
    bluez4-agent \
    libasound-module-bluez \
    bluez-hcidump \
    openobex \
    openobex-apps \
    obexftp \
    ussp-push \
"

# Need to add battleship to the below list once the application has been fixed
DEMO_APPS = "\
    bluetooth-gui \
    wifi-direct-demo \
    wpa-gui-e \
    wl1271-demo \
"

CONNECTIVITY_RDEPENDS = ""

# Need to add ${FIRMWARE_AND_DRIVERS} to the below lists once the recipes have
# been added to meta-ti

CONNECTIVITY_RDEPENDS_am37x-evm = "\
    ${WLAN_COMMON} \
    ${BLUETOOTH_STACK} \
    ${DEMO_APPS} \
"

CONNECTIVITY_RDEPENDS_am180x-evm  = "\
    ${WLAN_COMMON} \
    ${BLUETOOTH_STACK} \
    ${DEMO_APPS} \
"

CONNECTIVITY_RDEPENDS_ti33x = "\
    ${WLAN_COMMON} \
    ${BLUETOOTH_STACK} \
    ${DEMO_APPS} \
"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
