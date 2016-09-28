package recyclingStation.models.strategies;

import recyclingStation.models.procesingDatas.ProcessingDataImpl;
import recyclingStation.models.strategies.annotations.Storable;
import recyclingStation.wasteDisposal.contracts.GarbageDisposalStrategy;
import recyclingStation.wasteDisposal.contracts.ProcessingData;
import recyclingStation.wasteDisposal.contracts.Waste;

@Storable
public class StorableDisposalStrategy implements GarbageDisposalStrategy {
    private static final double CAPITAL_USED_PERCENT = 0.65D;
    private static final double ENERGY_USED_PERCENT = 0.13D;
    private static final double ENERGY_USED_SIGN = -1;
    private static final double CAPITAL_USED_SIGN = -1;

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        Double totalGarbageVolume = garbage.getWeight() * garbage.getVolumePerKg();
        Double capitalValue = (totalGarbageVolume * CAPITAL_USED_PERCENT) * CAPITAL_USED_SIGN;
        Double energyValue = (totalGarbageVolume * ENERGY_USED_PERCENT) * ENERGY_USED_SIGN;
        ProcessingData data = new ProcessingDataImpl(capitalValue,energyValue);
        return data;
    }
}
