package recyclingStation.models.procesingDatas;

import recyclingStation.wasteDisposal.contracts.ProcessingData;

public class ProcessingDataImpl implements ProcessingData{

    private double energyBalance;
    private double capitalBalance;

    public ProcessingDataImpl(double capital, double energy) {
        this.capitalBalance = capital;
        this.energyBalance = energy;
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }
}
