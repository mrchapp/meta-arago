require arago-qt4.inc

PR := "${PR}.1"

# Limit qt4-embedded-gles to platforms that have SGX support
COMPATIBLE_MACHINE = "ti33x|omap3"
