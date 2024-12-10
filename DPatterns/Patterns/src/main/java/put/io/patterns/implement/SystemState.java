package put.io.patterns.implement;

public class SystemState {
    private double cpuLoad;
    private double cpuTemp;
    private double availableMemory;
    private int usbDevices;

    public SystemState(double cpuLoad, double cpuTemp, double availableMemory, int usbDevices) {
        this.cpuLoad = cpuLoad;
        this.cpuTemp = cpuTemp;
        this.availableMemory = availableMemory;
        this.usbDevices = usbDevices;
    }

    public double getCpuLoad() {
        return cpuLoad;
    }

    public double getCpuTemp() {
        return cpuTemp;
    }

    public double getAvailableMemory() {
        return availableMemory;
    }

    public int getUsbDevices() {
        return usbDevices;
    }
}

