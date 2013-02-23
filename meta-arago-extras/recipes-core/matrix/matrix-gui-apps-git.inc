LICENSE = "CC-BY-SA"
#By default all Matrix v2 applications use the same license.
LICENSE_CHECKSUM = "LICENSE;md5=6e0ae7214f6c74c149cb25f373057fa9"
LIC_FILES_CHKSUM := "file://../${LICENSE_CHECKSUM}"

SRC_URI = "git://gitorious.org/matrix-gui-v2/matrix-gui-v2-apps.git;protocol=git;branch=${BRANCH}"
SRCREV = "46f39570f1fd378554af325e07b4cc19ae65dcb3"
BRANCH = "master-use-crypto-script"
INC_PR = "r12"

# Pull in the base package for installing matrix applications
require matrix-gui-apps.inc
