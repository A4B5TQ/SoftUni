package recyclingStation.models.garbages;

import recyclingStation.models.strategies.annotations.Storable;

@Storable
public class StorableGarbage extends Garbage {

    public StorableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
