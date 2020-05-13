SUMMARY = "A console development image customized for the rpi"
HOMEPAGE = "http://www.jumpnowtek.com"

require images/basic-dev-image.bb

DEPENDS += "bcm2835-bootfiles"

WIFI = " \
    crda \
    iw \
    linux-firmware-rpidistro-bcm43430 \
    linux-firmware-rpidistro-bcm43455 \
    wpa-supplicant \
"


RPI_STUFF = " \
    userland \
"

IMAGE_INSTALL += " \
    ${RPI_STUFF} \
    ${WIFI} \
"


export IMAGE_BASENAME = "console-image"
