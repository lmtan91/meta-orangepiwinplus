# orangepiwin_yocto

## How to build
`
mkdir mender-orangepi && cd mender-orangepi` \
`repo init -u https://github.com/lmtan91/meta-mender-community -m meta-mender-sunxi/scripts/manifest-sunxi-orangepiwinplus.xml -b dunfell` \
`repo sync` \
`source setup-environment sunxi` \
`MACHINE=orange-pi-win-plus bitbake core-image-base`
