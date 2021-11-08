# orangepiwin_yocto

## How to build
`
mkdir mender-orangepi && cd mender-orangepi` \
`repo init -u https://github.com/lmtan91/meta-mender-community -m meta-mender-sunxi/scripts/manifest-sunxi-orangepiwinplus.xml -b dunfell` \
`repo sync` \
`source setup-environment sunxi` \
`MACHINE=orange-pi-win-plus bitbake core-image-base`

## Connect to Wifi by wpa_supplicant
`wpa_passphrase Moc 27052019 | tee /etc/wpa_supplicant.conf` \
`wpa_supplicant -B -c /etc/wpa_supplicant.conf -i wlan0` \
`dhclient wlan0`

## Start sshd in orangepiwin
`systemctl start sshd@.service`

## Mender demo
### Follow this https://docs.mender.io/3.1/server-installation/demo-installation to setup the demo server.

### Correct the DEMO_HOST_IP_ADDRESS to your PC.
`MENDER_DEMO_HOST_IP_ADDRESS = "192.168.12.3"`
