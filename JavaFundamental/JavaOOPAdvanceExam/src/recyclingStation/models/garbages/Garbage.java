package recyclingStation.models.garbages;

import recyclingStation.wasteDisposal.contracts.Waste;

public abstract class Garbage implements Waste{

    private String name;
    private double weight;
    private double volumePerKg;


    public Garbage(String name, double weight, double volumePerKg) {
        this.setName(name);
        this.setVolumePerKg(volumePerKg);
        this.setWeight(weight);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setVolumePerKg(double volumePerKg) {
        this.volumePerKg = volumePerKg;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }
}
