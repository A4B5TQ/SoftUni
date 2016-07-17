package javaOOPBasics.polymorphism.vehicles;

public class Truck extends Vehicle {
    private final double FUEL_INCREASE = 1.6D;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    protected void setFuelConsumption(double fuelConsumption){
        super.setFuelConsumption(fuelConsumption + FUEL_INCREASE);
    }
    public void refueled(double fuel){
        super.refueled(fuel * 0.95D);
    }
}
