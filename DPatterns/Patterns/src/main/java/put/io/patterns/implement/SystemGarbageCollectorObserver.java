package put.io.patterns.implement;

public class SystemGarbageCollectorObserver implements SystemStateObserver {

    @Override
    public void update(SystemState newState) {
        if (newState.getAvailableMemory() < 200) {
            System.out.println("> Running garbage collector...");
        }
    }
}

