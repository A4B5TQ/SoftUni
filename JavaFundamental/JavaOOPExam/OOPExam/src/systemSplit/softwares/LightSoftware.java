package systemSplit.softwares;

public class LightSoftware extends Software {
    public LightSoftware(String name, double price, int capacityConsumption, int memoryConsumption) {
        super(name, price, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setCapacityConsumption(int capacityConsumption) {
        int capacity = capacityConsumption + (capacityConsumption / 2);
        super.setCapacityConsumption(capacity);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        int memory = memoryConsumption - (memoryConsumption / 2);
        super.setMemoryConsumption(memory);
    }

    @Override
    public int getMemoryConsumption() {
        return super.getMemoryConsumption();
    }
}
