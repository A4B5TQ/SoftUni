package javaOOPBasics.polymorphism.vehicles;

public class Car extends Vehicle {
    private final double FUEL_INCREASE = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
    }

    protected void setFuelConsumption(double fuelConsumption){
        super.setFuelConsumption(fuelConsumption + FUEL_INCREASE);
    }

    @Override
    protected void setFuelQuantity(double fuelQuantity) {
        if (super.getFuelQuantity() < fuelQuantity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(fuelQuantity);
    }
}
