DESCRIPTION = "hailo pcie driver \
               compiles the kernel driver for pci communication with hailo8 \
               the recipe calls the compilation process with the proper cross-compiler and kernel directory. \
               the output of the compilation (hailo_pci.ko) is copied to the target's rootfs"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=39bba7d2cf0ba1036f2a6e2be52fe3f0"

SRC_URI = "git://git@github.com/hailo-ai/hailort-drivers.git;protocol=https;branch=master"
SRCREV = "37d426f72b798cc99abd68b2f76eb873433ce977"

inherit module

S = "${WORKDIR}/git/linux/pcie"

EXTRA_OEMAKE += "KERNEL_DIR=${STAGING_KERNEL_DIR}"
MAKE_TARGETS = "all"
MODULES_INSTALL_TARGET = "install"