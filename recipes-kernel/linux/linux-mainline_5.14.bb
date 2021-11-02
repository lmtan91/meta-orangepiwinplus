SECTION = "kernel"
DESCRIPTION = "Mainline RC Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"


inherit kernel

KBRANCH ?= "master"

DEPENDS += "rsync-native"

RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

KERNEL_IMAGETYPE ?= "Image"

S = "${WORKDIR}/linux-${PV}"

SRC_URI = " \
	https://git.kernel.org/torvalds/t/linux-${PV}.tar.gz \
	file://defconfig \
	"

SRC_URI[sha256sum] = ""

FILES_${KERNEL_PACKAGE_NAME}-base_append = " ${nonarch_base_libdir}/modules/${KERNEL_VERSION}/modules.builtin.modinfo"

CMDLINE_append = "quiet vt.global_cursor_default=0"
