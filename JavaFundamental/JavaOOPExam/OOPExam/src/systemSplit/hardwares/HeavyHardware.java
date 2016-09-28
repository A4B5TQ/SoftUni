package systemSplit.hardwares;

import systemSplit.components.Component;
import systemSplit.softwares.LightSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeavyHardware extends Hardware {
    private List<LightSoftware> lightSoftwares;

    public HeavyHardware(String name, double price, int maximumCapacity, int maximumMemory, int energyCostPerHour) {
        super(name, price, maximumCapacity, maximumMemory, energyCostPerHour);
        this.lightSoftwares = new ArrayList<>();
    }

    public void addSoftware(LightSoftware software) {
        if ((this.getMaximumCapacity() >= (software.getCapacityConsumption() + super.getUsedCapacity())
                &&
                (this.getMaximumMemory() >= (software.getMemoryConsumption() + super.getUsedMemory())))) {
            this.lightSoftwares.add(software);
            super.increaseUsedMemory(software.getMemoryConsumption());
            super.increaseUsedCapacity(software.getCapacityConsumption());
        }
    }

    public List<LightSoftware> getLightSoftwares() {
        return this.lightSoftwares;
    }

    public double getTotalSoftwarePrice() {
        return this.getLightSoftwares().stream().mapToDouble(Component::getPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder heavyHardwareData = new StringBuilder(super.toString());
        heavyHardwareData.append("Type: Heavy").append(System.lineSeparator());
        heavyHardwareData.append(String.format("Software Components: %s", this.getLightSoftwares().size() == 0 ? "None" :
                this.getLightSoftwares().stream()
                        .map(Component::getName).collect(Collectors.joining(", "))));
        return heavyHardwareData.toString();
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        int memory = maximumMemory - (maximumMemory / 4);
        super.setMaximumMemory(memory);
    }

    @Override
    protected void setMaximumCapacity(int maximumCapacity) {
        super.setMaximumCapacity(maximumCapacity * INCREASE_VALUE);
    }
}
