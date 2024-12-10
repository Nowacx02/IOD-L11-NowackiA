package put.io.patterns.implement;

public class MonitorRunner {
    public static void main(String[] args) {
        // Tworzenie monitora
        SystemMonitor monitor = new SystemMonitor();

        // Rejestracja obserwatorów
        monitor.addSystemStateObserver(new SystemInfoObserver());
        monitor.addSystemStateObserver(new SystemGarbageCollectorObserver());
        monitor.addSystemStateObserver(new SystemCoolerObserver());
        monitor.addSystemStateObserver(new USBDeviceObserver());

        // Pętla monitorująca
        while (true) {
            monitor.probe();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

