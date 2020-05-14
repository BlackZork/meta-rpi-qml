SUMMARY = "Add DHCP configuration for eth0"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "file://20-wired.network"

PR = "r0"

S = "${WORKDIR}"

do_install() {
    install -m 0744 firewall.rules ${D}${sysconfdir}/systemd/network
}

FILES_${PN} = "${sysconfdir}"

RDEPENDS_${PN} = "systemd"
