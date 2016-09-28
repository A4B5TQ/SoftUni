package systemSplit.softwares;


public class ExpressSoftware extends Software {

    public ExpressSoftware(String name, double price, int capacityConsumption, int memoryConsumption) {
        super(name, price, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void setPrice(double price) {
        super.setPrice(price * INCREASE_VALUE);
    }

    @Override
    protected void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption * INCREASE_VALUE);
    }

    @Override
    public int getMemoryConsumption() {
        return super.getMemoryConsumption();
    }

    @Override
    public int getCapacityConsumption() {
        return super.getCapacityConsumption();
    }
}
