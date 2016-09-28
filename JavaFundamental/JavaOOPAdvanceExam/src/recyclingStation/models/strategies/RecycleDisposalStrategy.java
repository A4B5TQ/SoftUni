package recyclingStation.models.strategies;

import recyclingStation.models.procesingDatas.ProcessingDataImpl;
import recyclingStation.models.strategies.annotations.Recyclable;
import recyclingStation.wasteDisposal.contracts.GarbageDisposalStrategy;
import recyclingStation.wasteDisposal.contracts.ProcessingData;
import recyclingStation.wasteDisposal.contracts.Waste;

@Recyclable
public class RecycleDisposalStrategy implements GarbageDisposalStrategy {
    private static final double CAPITAL_EARNED_COEFFICIENT = 400D;
    private static final double ENERGY_USED_PERCENT = 0.5D;
    private static final double ENERGY_USED_SIGN = -1;

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        Double totalGarbageVolume = garbage.getWeight() * garbage.getVolumePerKg();
        Double capitalValue = garbage.getWeight() * CAPITAL_EARNED_COEFFICIENT;
        Double energyValue = (totalGarbageVolume * ENERGY_USED_PERCENT)* ENERGY_USED_SIGN;
        ProcessingData data = new ProcessingDataImpl(capitalValue,energyValue);
        return data;
    }
}
