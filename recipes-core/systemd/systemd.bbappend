FILESEXTRAPATHS_append := "${THISDIR}/files:"
SRC_URI += "file://20-wired.network"

FILES_${PN} += "{sysconfdir}/systemd/network/*"

do_install_append() {
  install -d ${D}${sysconfdir}/systemd/network/
  install -m 0644 ${WORKDIR}/*.network ${D}${sysconfdir}/systemd/network/
}
