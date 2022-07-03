DESCRIPTION = "gsthailotools GStreamer plugin \
               compiles the tappas libgsthailotools gstreamer plugin \ 
               and copies it to usr/lib/gstreamer-1.0 (gstreamer's plugins directory) "

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM += "file://../../../LICENSE;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://git@github.com/hailo-ai/tappas.git;protocol=https;branch=master"
SRCREV = "c93db8ebf2963ce820015a88f325373a171bd794"

inherit hailotools-base

do_install_append() {
    rm -f ${D}/${libdir}/gstreamer-1.0/libgsthailotools.so
    find ${D}/${libdir}/gstreamer-1.0/ -name 'libgsthailotools.so.[0-9]' -delete
    mv -f ${D}/${libdir}/gstreamer-1.0/libgsthailotools.so.${PV} ${D}/${libdir}/gstreamer-1.0/libgsthailotools.so
}


DEPENDS += "glib-2.0-native glib-2.0 gstreamer1.0 gstreamer1.0-plugins-base"

# libgsthailotools requires opencv, xtensor, xtl, and libgsthailo to compile and run
TAPPAS_BUILD_TARGET = "plugins"

FILES_${PN} += "/usr/lib/gstreamer-1.0/libgsthailotools.so  /usr/lib/libgsthailometa.so.${PV} /usr/lib/libhailo_tracker.so.${PV}"
FILES_${PN}-lib += "/usr/lib/libgsthailometa.so.${PV} /usr/lib/libhailo_tracker.so.${PV} /usr/lib/gstreamer-1.0/libgsthailotools.so"
RDEPENDS_${PN}-staticdev = ""
RDEPENDS_${PN}-dev = ""
RDEPENDS_${PN}-dbg = ""