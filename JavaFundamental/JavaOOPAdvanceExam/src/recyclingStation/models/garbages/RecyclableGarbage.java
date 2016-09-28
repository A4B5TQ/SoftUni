package recyclingStation.models.garbages;

import recyclingStation.models.strategies.annotations.Recyclable;

@Recyclable
public class RecyclableGarbage extends Garbage {
    public RecyclableGarbage(String name, double volumePerKg, double weight) {
        super(name, volumePerKg, weight);
    }
}
