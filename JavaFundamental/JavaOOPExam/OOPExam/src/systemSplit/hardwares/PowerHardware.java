package systemSplit.hardwares;

import systemSplit.components.Component;
import systemSplit.softwares.ExpressSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PowerHardware extends Hardware {
    private List<ExpressSoftware> expressSoftwares;

    public PowerHardware(String name, double price, int maximumCapacity, int maximumMemory, int energyCostPerHour) {
        super(name, price, maximumCapacity, maximumMemory, energyCostPerHour);
        this.expressSoftwares = new ArrayList<>();
    }

    @Override
    public void setMaximumCapacity(int maximumCapacity) {
        int capacity = maximumCapacity - ((maximumCapacity * 3) / 4);
        super.setMaximumCapacity(capacity);
    }

    @Override
    protected void setMaximumMemory(int maximumMemory) {
        int memory = maximumMemory + ((maximumMemory * 3) / 4);
        super.setMaximumMemory(memory);
    }

    @Override
    protected void setEnergyCostPerHour(int energyCostPerHour) {
        super.setEnergyCostPerHour(energyCostPerHour * INCREASE_VALUE);
    }

    public void addSoftware(ExpressSoftware software){
        if ((this.getMaximumCapacity() >= (software.getCapacityConsumption() + super.getUsedCapacity())
                &&
                (this.getMaximumMemory() >= (software.getMemoryConsumption() + super.getUsedMemory())))) {
            this.expressSoftwares.add(software);
            super.increaseUsedMemory(software.getMemoryConsumption());
            super.increaseUsedCapacity(software.getCapacityConsumption());
        }
    }

    public List<ExpressSoftware> getExpressSoftwares() {
        return expressSoftwares;
    }

    public double getTotalSoftwarePrice(){
        return this.expressSoftwares.stream().mapToDouble(Component::getPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder powerHardwareData = new StringBuilder(super.toString());
        powerHardwareData.append("Type: Power").append(System.lineSeparator());
        powerHardwareData.append(String.format("Software Components: %s", this.getExpressSoftwares().size() == 0 ? "None" :
                this.getExpressSoftwares().stream()
                        .map(Component::getName).collect(Collectors.joining(", "))));
        return powerHardwareData.toString();
    }
}
