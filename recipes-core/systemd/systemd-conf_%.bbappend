FILESEXTRAPATHS_append := "${THISDIR}/systemd-conf/files:"

SRC_URI += "file://20-wired.network"

FILES_${PN} += "${systemd_unitdir}/network/20-wired.network"

# Needed for setting hostname from DHCP
DEPENDS = "polkit"

do_install_append() {
  install -d ${D}${systemd_unitdir}/network/
  install -m 0644 ${WORKDIR}/20-wired.network ${D}${systemd_unitdir}/network/
	rm -f ${D}${systemd_unitdir}/network/80-wired.network
}
