package recyclingStation.models.strategies;

import recyclingStation.models.procesingDatas.ProcessingDataImpl;
import recyclingStation.models.strategies.annotations.Burnable;
import recyclingStation.wasteDisposal.contracts.GarbageDisposalStrategy;
import recyclingStation.wasteDisposal.contracts.ProcessingData;
import recyclingStation.wasteDisposal.contracts.Waste;

@Burnable
public class BurnableDisposalStrategy implements GarbageDisposalStrategy {
    private static final double ENERGY_USED_PERCENT = 0.8D;
    private static final double DEFAULT_CAPITAL_VALUE = 0D;
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        Double totalGarbageVolume = garbage.getWeight() * garbage.getVolumePerKg();
        Double energy = totalGarbageVolume * ENERGY_USED_PERCENT;
        ProcessingData data = new ProcessingDataImpl(DEFAULT_CAPITAL_VALUE,energy);
        return data;
    }
}
