package systemSplit.systemsComponents;

import systemSplit.hardwares.Hardware;
import systemSplit.hardwares.HeavyHardware;
import systemSplit.hardwares.PowerHardware;
import systemSplit.softwares.ExpressSoftware;
import systemSplit.softwares.LightSoftware;

import java.util.HashMap;

public class Core {
    private Dump dump;
    private HashMap<String, PowerHardware> powerHardwareMap;
    private HashMap<String, HeavyHardware> heavyHardwareMap;

    public Core(Dump dump){
        this.dump = dump;
        this.powerHardwareMap = new HashMap<>();
        this.heavyHardwareMap = new HashMap<>();
    }

    public void registerPowerHardware(String name, double price,int capacity, int memory,int energyConsumption){
       PowerHardware powerHardware = new PowerHardware(name,price,capacity,memory,energyConsumption);
        this.powerHardwareMap.put(name,powerHardware);
    }
    public void registerHeavyHardware(String name, double price, int capacity, int memory, int energyConsumption){
        HeavyHardware heavyHardware = new HeavyHardware(name,price,capacity,memory,energyConsumption);
        this.heavyHardwareMap.put(name,heavyHardware);
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, double price, int capacity, int memory){
        ExpressSoftware expressSoftware = new ExpressSoftware(name,price,capacity,memory);
        if (this.powerHardwareMap.containsKey(hardwareComponentName)){
            this.powerHardwareMap.get(hardwareComponentName).addSoftware(expressSoftware);
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, double price, int capacity, int memory){
        LightSoftware lightSoftware = new LightSoftware(name,price,capacity,memory);
        if (this.heavyHardwareMap.containsKey(hardwareComponentName)){
            this.heavyHardwareMap.get(hardwareComponentName).addSoftware(lightSoftware);
        }
    }

    public void analyze(){
        int hardwareComponentsCount = getHardwareComponentsCount();

        int softwareComponentsCount = 0;
        if (this.heavyHardwareMap.size() > 0){
            softwareComponentsCount += this.heavyHardwareMap.values()
                    .stream().
                            mapToInt(hardware -> hardware.getLightSoftwares().size()).sum();
        }

        if (this.powerHardwareMap.size() > 0) {
            softwareComponentsCount += this.powerHardwareMap.values()
                    .stream().
                            mapToInt(hardware -> hardware.getExpressSoftwares().size()).sum();
        }

        double totalMoneySpent = this.heavyHardwareMap.values().stream().mapToDouble(h -> h.getTotalSoftwarePrice() + h.getPrice()).sum();
        totalMoneySpent += this.powerHardwareMap.values().stream().mapToDouble(h -> h.getTotalSoftwarePrice() + h.getPrice()).sum();


        int totalMemoryInUse = this.heavyHardwareMap.values().stream().mapToInt(Hardware::getUsedMemory).sum();
        totalMemoryInUse += this.powerHardwareMap.values().stream().mapToInt(Hardware::getUsedMemory).sum();

        int totalMemory = this.heavyHardwareMap.values().stream().mapToInt(Hardware::getMaximumMemory).sum();
        totalMemory += this.powerHardwareMap.values().stream().mapToInt(Hardware::getMaximumMemory).sum();

        int totalCapacityTaken = this.heavyHardwareMap.values().stream().mapToInt(Hardware::getUsedCapacity).sum();
        totalCapacityTaken += this.powerHardwareMap.values().stream().mapToInt(Hardware::getUsedCapacity).sum();

        int totalCapacity = this.heavyHardwareMap.values().stream().mapToInt(Hardware::getMaximumCapacity).sum();
        totalCapacity += this.powerHardwareMap.values().stream().mapToInt(Hardware::getMaximumCapacity).sum();

        int totalEnergyConsumption = this.heavyHardwareMap.values().stream().mapToInt(Hardware::getEnergyCostPerHour).sum();
        totalEnergyConsumption += this.powerHardwareMap.values().stream().mapToInt(Hardware::getEnergyCostPerHour).sum();

        StringBuilder analyzeOutput = new StringBuilder();
        analyzeOutput.append("System Analysis").append(System.lineSeparator());
        analyzeOutput.append(String.format("Hardware Components: %d",hardwareComponentsCount)).append(System.lineSeparator());
        analyzeOutput.append(String.format("Software Components: %d", softwareComponentsCount)).append(System.lineSeparator());
        analyzeOutput.append(String.format("Total Money Spent: %.2f",totalMoneySpent)).append(System.lineSeparator());
        analyzeOutput.append(String.format("Total Operational Memory: %d / %d",totalMemoryInUse,totalMemory)).append(System.lineSeparator());
        analyzeOutput.append(String.format("Total Capacity Taken: %d / %d",totalCapacityTaken,totalCapacity)).append(System.lineSeparator());
        analyzeOutput.append(String.format("Total Energy/Hour Consumption: %d",totalEnergyConsumption));

        System.out.println(analyzeOutput.toString());


    }

    public void dump(String hardwareCompType, String hardwareCompName){
        switch (hardwareCompType){
            case "Power":
                if (this.powerHardwareMap.containsKey(hardwareCompName)){
                    PowerHardware powerHardware = this.powerHardwareMap.get(hardwareCompName);
                    this.dump.insert(hardwareCompName,powerHardware);
                    this.powerHardwareMap.remove(hardwareCompName);
                }
                break;
            case "Heavy":
                if (this.heavyHardwareMap.containsKey(hardwareCompName)){
                    HeavyHardware heavyHardware = this.heavyHardwareMap.get(hardwareCompName);
                    this.dump.insert(hardwareCompName,heavyHardware);
                    this.heavyHardwareMap.remove(hardwareCompName);
                }
                break;
        }
    }

    public void restore(String type,String hardwareComponentName){
       switch (type){
           case "Power":
               PowerHardware powerHardware = this.dump.restorePowerHardware(hardwareComponentName);
               if (powerHardware != null){
                   this.powerHardwareMap.put(hardwareComponentName,powerHardware);
               }
               break;
           case "Heavy":
               HeavyHardware heavyHardware = this.dump.restoreHeavyHardware(hardwareComponentName);
               if (heavyHardware != null){
                   this.heavyHardwareMap.put(hardwareComponentName,heavyHardware);
               }
               break;
       }
    }

    public void destroy(String type,String hardwareComponentName){
        this.dump.destroy(type, hardwareComponentName);
    }

    public void split(){
        if (this.powerHardwareMap.size() > 0){
            this.powerHardwareMap.values().stream().forEach(System.out::println);
        }

        if (this.heavyHardwareMap.size() > 0){
            this.heavyHardwareMap.values().stream().forEach(System.out::println);
        }
    }

    private int getHardwareComponentsCount(){
        return this.heavyHardwareMap.size() + this.powerHardwareMap.size();
    }
}
