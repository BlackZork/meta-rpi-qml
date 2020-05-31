SUMMARY = "A console development image with some C/C++ dev tools"
HOMEPAGE = "http://www.jumpnowtek.com"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

inherit image

CORE_OS = " \
    openssh openssh-keygen openssh-sftp-server \
    packagegroup-core-boot \
    tzdata \
    polkit \
"

KERNEL_EXTRA = " \
    kernel-modules \
"

# nie używane
DEV_SDK = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    elfutils elfutils-binutils \
    file \
    gcc \
    gcc-symlinks \
    g++ \
    g++-symlinks \
    gdb \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    ltrace \
    make \
    perl-modules \
    pkgconfig \
    python3-modules \
"

DEV_TOOLS = " \
    gdb \
    gdbserver \
"

EXTRA_TOOLS = " \
    bzip2 \
    curl \
    dosfstools \
    e2fsprogs-mke2fs \
    ethtool \
    fbset \
    findutils \
    grep \
    i2c-tools \
    ifupdown \
    iperf3 \
    iproute2 \
    iptables \
    less \
    libmosquitto1 \
    lsof \
    netcat-openbsd \
    nmap \
    ntp ntp-tickadj \
    parted \
    procps \
    strace \
    sysfsutils \
    tcpdump \
    util-linux \
    util-linux-blkid \
    unzip \
    wget \
    zip \
"

IMAGE_INSTALL_append = " \
    ${CORE_OS} \
    ${EXTRA_TOOLS} \
    ${KERNEL_EXTRA} \
    ${DEV_TOOLS} \
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

create_opt_dir() {
    mkdir -p ${IMAGE_ROOTFS}/opt
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    create_opt_dir ; \
"

export IMAGE_BASENAME = "basic-dev-image"
