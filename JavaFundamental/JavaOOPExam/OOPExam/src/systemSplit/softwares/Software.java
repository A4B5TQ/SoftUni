package systemSplit.softwares;

import systemSplit.components.Component;

public abstract class Software extends Component {
    private int capacityConsumption;
    private int memoryConsumption;

    protected Software(String name, double price, int capacityConsumption, int memoryConsumption) {
        super(name, price);
        this.setCapacityConsumption(capacityConsumption);
        this.setMemoryConsumption(memoryConsumption);
    }

    protected void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    protected void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

    protected int getMemoryConsumption(){
        return memoryConsumption;
    }

    public int getCapacityConsumption() {
        return capacityConsumption;
    }
}
