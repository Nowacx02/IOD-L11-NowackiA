package put.io.patterns.implement;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

import java.util.ArrayList;
import java.util.List;

public class SystemMonitor {
    private List<SystemStateObserver> observers = new ArrayList<>();
    private SystemState lastSystemState = null;

    // Metoda do dodawania obserwatorów
    public void addSystemStateObserver(SystemStateObserver observer) {
        observers.add(observer);
    }

    // Metoda do usuwania obserwatorów
    public void removeSystemStateObserver(SystemStateObserver observer) {
        observers.remove(observer);
    }

    // Powiadamianie obserwatorów o zmianie stanu
    private void notifyObservers() {
        for (SystemStateObserver observer : observers) {
            observer.update(lastSystemState);
        }
    }

    // Odczyt stanu systemu
    public void probe() {
        double cpuLoad = Math.random() * 100; // Symulacja odczytu
        double cpuTemp = Math.random() * 100;
        double memory = Math.random() * 16000; // W MB
        int usbDevices = (int) (Math.random() * 10);

        lastSystemState = new SystemState(cpuLoad, cpuTemp, memory, usbDevices);

        notifyObservers();
    }
}

