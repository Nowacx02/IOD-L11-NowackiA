package put.io.patterns.implement;

public class SystemCoolerObserver implements SystemStateObserver {

    @Override
    public void update(SystemState newState) {
        if (newState.getCpuTemp() > 70) {
            System.out.println("> Increasing cooling of the CPU...");
        }
    }
}

