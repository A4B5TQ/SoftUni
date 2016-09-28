package systemSplit.hardwares;

import systemSplit.components.Component;

public abstract class Hardware extends Component {
    private int maximumCapacity;
    private int maximumMemory;
    private int energyCostPerHour;
    private int usedCapacity = 0;
    private int usedMemory = 0;

    protected Hardware(String name,double price, int maximumCapacity, int maximumMemory, int energyCostPerHour){
        super(name,price);
        this.setMaximumCapacity(maximumCapacity);
        this.setMaximumMemory(maximumMemory);
        this.setEnergyCostPerHour(energyCostPerHour);
    }

    public int getMaximumCapacity() {
        return this.maximumCapacity;
    }

    public int getMaximumMemory() {
        return this.maximumMemory;
    }

    public int getUsedCapacity() {
        return this.usedCapacity;
    }

    public int getUsedMemory() {
        return this.usedMemory;
    }

    @Override
    public String toString() {
        StringBuilder hardwareData = new StringBuilder();
        hardwareData.append(String.format("Hardware Component - %s",super.getName())).append(System.lineSeparator());
        hardwareData.append(String.format("Price: %.2f",super.getPrice())).append(System.lineSeparator());
        hardwareData.append(String.format("Memory Usage: %d / %d",this.getUsedMemory(),this.getMaximumMemory())).append(System.lineSeparator());
        hardwareData.append(String.format("Capacity Usage: %d / %d",this.getUsedCapacity(),this.getMaximumCapacity())).append(System.lineSeparator());
        hardwareData.append(String.format("Energy Usage: %d",this.getEnergyCostPerHour())).append(System.lineSeparator());
        return hardwareData.toString();
    }
    public int getEnergyCostPerHour() {
        return energyCostPerHour;
    }

    protected void setEnergyCostPerHour(int energyCostPerHour) {
        this.energyCostPerHour = energyCostPerHour;
    }

    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    void increaseUsedCapacity(int capacity) {
        if (this.getMaximumCapacity() >= (capacity + this.usedCapacity)) {
            this.usedCapacity += capacity;
        }
    }

    void increaseUsedMemory(int memory) {
        if (this.getMaximumMemory() > (memory + this.usedMemory)) {
            this.usedMemory += memory;
        }
    }
}
