# Copyright (C) 2015-2016 Freescale Semiconductor
# Copyright 2017-2018 NXP

SUMMARY = "Kernel loadable module for Vivante GPU"
DESCRIPTION = "Builds the Vivante GPU kernel driver as a loadable kernel module, \
allowing flexibility to use a newer graphics release with an older kernel."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRCBRANCH = "imx_4.19.35_1.1.0"
LOCALVERSION = "-${SRCBRANCH}"
KERNEL_SRC ?= "git://source.codeaurora.org/external/imx/linux-imx.git;protocol=https"
SRC_URI = " \
    ${KERNEL_SRC};branch=${SRCBRANCH};subpath=drivers/mxc/gpu-viv;destsuffix=git/src \
    file://Add-makefile.patch \
"
SRCREV = "0f9917c56d5995e1dc3bde5658e2d7bc865464de"

S = "${WORKDIR}/git"

inherit module

EXTRA_OEMAKE += "CONFIG_MXC_GPU_VIV=m"

KERNEL_MODULE_AUTOLOAD = "galcore"
COMPATIBLE_MACHINE = "(imx)"
