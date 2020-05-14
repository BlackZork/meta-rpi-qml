SUMMARY = "A basic Qt5 qwidgets dev image"

require console-image.bb

QT_DEV_TOOLS = " \
    qtbase-dev \
    qtbase-mkspecs \
    qtbase-plugins \
    qtbase-tools \
    qtserialport-dev \
    qtserialport-mkspecs \
"

QT_TOOLS = " \
    qtbase \
    qt5-env \
    qtserialport \
"

FONTS = " \
    fontconfig \
    fontconfig-utils \
    ttf-bitstream-vera \
"

TSLIB = " \
    tslib \
    tslib-conf \
    tslib-calibrate \
    tslib-tests \
"

TEST_APPS += " \
    tspress-tools \
"

IMAGE_INSTALL_append = " \
    ${FONTS} \
    ${QT_DEV_TOOLS} \
    ${QT_TOOLS} \
    ${TEST_APPS} \
    ${TSLIB} \
"

export IMAGE_BASENAME = "qt5-basic-image"
