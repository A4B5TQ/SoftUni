package recyclingStation.models.stations;

import recyclingStation.wasteDisposal.contracts.ProcessingData;

public class RecycleStationImpl implements RecycleStation {
    private static final double DEFAULT_ENERGY_VALUE = 0D;
    private static final double DEFAULT_CAPITAL_VALUE = 0D;

    private double energy;
    private double capital;

    public RecycleStationImpl() {
        this.energy = DEFAULT_ENERGY_VALUE;
        this.capital = DEFAULT_CAPITAL_VALUE;
    }

    @Override
    public void setProcessingData(ProcessingData processingData) {
        this.setCapital(processingData.getCapitalBalance());
        this.setEnergy(processingData.getEnergyBalance());
    }
    @Override
    public double getEnergyBalance() {
        return this.energy;
    }

    @Override
    public double getCapitalBalance() {
        return this.capital;
    }

    private void setCapital(double capital) {
        this.capital += capital;
    }

    private void setEnergy(double energy) {
        this.energy += energy;
    }
}
