package put.io.patterns.implement;

public class SystemInfoObserver implements SystemStateObserver {

    @Override
    public void update(SystemState newState) {
        System.out.println("============================================");
        System.out.println("CPU Load: " + newState.getCpuLoad() + "%");
        System.out.println("CPU Temperature: " + newState.getCpuTemp() + "°C");
        System.out.println("Available Memory: " + newState.getAvailableMemory() + " MB");
        System.out.println("USB Devices: " + newState.getUsbDevices());
    }
}

