SECTION = "kernel"
DESCRIPTION = "Mainline Longterm Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

inherit kernel

require linux.inc

# Since we're not using git, this doesn't make a difference, but we need to fill
# in something or kernel-yocto.bbclass will fail.
KBRANCH ?= "master"

# Pull in the devicetree files into the rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/linux-${PV}"

SRC_URI[md5sum] = "dfb4db3d95bdcd8114281e32eb0be5cd"
SRC_URI[sha256sum] = "d8c5d7844214510e85ceb9f5236f27f63fc03535a143f3aaa0c1677a8f92e631"

SRC_URI = "https://www.kernel.org/pub/linux/kernel/v4.x/linux-${PV}.tar.xz \
        file://0003-ARM-dts-nanopi-neo-air-Add-WiFi-eMMC.patch \
        file://defconfig \
        "

SRC_URI_append_orange-pi-zero += "\
	file://0001-dts-orange-pi-zero-Add-wifi-support.patch \
	"
