DESCRIPTION = "ARM Benchmarks"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_benchmarks/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=7aefb5e1cffc7b6a3ef18b803f957922"
SECTION = "system"

PR = "r4"

BRANCH ?= "master"
SRCREV = "f78411fbd9cb81c36c7067a74fd415ce7ce45dc4"

SRC_URI = "git://gitorious.org/arm_benchmarks/arm_benchmarks.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

PLATFORM_ARCH = "${ARMPKGARCH}"
PLATFORM_ARCH_omapl138 = "armv5te"

do_compile() {
	export CROSS_COMPILE=${TARGET_PREFIX}
	# build the release version
	oe_runmake -C ${PLATFORM_ARCH} release
}

do_install() {
	oe_runmake -C ${PLATFORM_ARCH} DESTDIR=${D} install
}
