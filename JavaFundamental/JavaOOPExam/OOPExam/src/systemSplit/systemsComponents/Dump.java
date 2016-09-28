package systemSplit.systemsComponents;

import systemSplit.hardwares.HeavyHardware;
import systemSplit.hardwares.PowerHardware;

import java.util.HashMap;

public class Dump {
    private HashMap<String, PowerHardware> powerHardwareMap;
    private HashMap<String, HeavyHardware> heavyHardwareMap;

    public Dump() {
        this.powerHardwareMap = new HashMap<>();
        this.heavyHardwareMap = new HashMap<>();
    }

    void insert(String hardwareComponentName, PowerHardware powerHardware) {
        this.powerHardwareMap.put(hardwareComponentName, powerHardware);
    }

    void insert(String hardwareComponentName, HeavyHardware heavyHardware) {
        this.heavyHardwareMap.put(hardwareComponentName, heavyHardware);
    }

    HeavyHardware restoreHeavyHardware(String hardwareComponentName) {
        if (this.heavyHardwareMap.containsKey(hardwareComponentName)) {
            HeavyHardware heavyHardware = this.heavyHardwareMap.get(hardwareComponentName);
            this.heavyHardwareMap.remove(hardwareComponentName);
            return heavyHardware;
        }
        return null;
    }

    PowerHardware restorePowerHardware(String hardwareComponentName) {
        if (this.powerHardwareMap.containsKey(hardwareComponentName)) {
            PowerHardware powerHardware = this.powerHardwareMap.get(hardwareComponentName);
            this.powerHardwareMap.remove(hardwareComponentName);
            return powerHardware;
        }
        return null;
    }

    void destroy(String type, String hardwareComponentName) {
        switch (type) {
            case "Power":
                if (this.powerHardwareMap.containsKey(hardwareComponentName)) {
                    this.powerHardwareMap.remove(hardwareComponentName);
                }
                break;
            case "Heavy":
                if (this.heavyHardwareMap.containsKey(hardwareComponentName)) {
                    this.heavyHardwareMap.remove(hardwareComponentName);
                }
                break;

        }
    }
}
