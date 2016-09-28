package recyclingStation.models.garbages;

import recyclingStation.models.strategies.annotations.Burnable;

@Burnable
public class BurnableGarbage extends Garbage {

    public BurnableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
