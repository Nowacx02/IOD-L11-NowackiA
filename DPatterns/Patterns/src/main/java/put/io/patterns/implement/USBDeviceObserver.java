package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver {
    private int lastUsbDevices = 0;

    @Override
    public void update(SystemState newState) {
        int currentUsbDevices = newState.getUsbDevices();

        if (currentUsbDevices > lastUsbDevices) {
            System.out.println("> USB device connected. Total: " + currentUsbDevices);
        } else if (currentUsbDevices < lastUsbDevices) {
            System.out.println("> USB device disconnected. Total: " + currentUsbDevices);
        }

        lastUsbDevices = currentUsbDevices;
    }
}

