package javaOOPBasics.polymorphism.vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity,
                      double fuelConsumption,
                      double tankCapacity){
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public Vehicle(double fuelQuantity, double fuelConsumption) {
    }

    protected void setTankCapacity(double fuel){
        this.tankCapacity = fuel;
    }

    protected void setFuelQuantity(double fuelQuantity){
        if (fuelQuantity < 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption){
        this.fuelConsumption = fuelConsumption;
    }

    protected double getFuelQuantity(){
        return this.fuelQuantity;
    }

    private double getTankCapacity(){
        return this.tankCapacity;
    }

    private double getFuelConsumption(){
        return this.fuelConsumption;
    }

    public void drive(double distance){
        double fuelNeeded = distance * getFuelConsumption();
        if (fuelNeeded > getFuelQuantity()){
            throw new IllegalArgumentException(String.format(
                    "%s needs refueling", this.getClass().getSimpleName()
            ));
        }

        this.setFuelQuantity(getFuelQuantity() - fuelNeeded);
    }

    public void refueled(double fuel){
        this.setFuelQuantity(getFuelQuantity() + fuel);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.getFuelQuantity());
    }
}
