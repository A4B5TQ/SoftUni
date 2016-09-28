package recyclingStation.models.stations;

import recyclingStation.wasteDisposal.contracts.ProcessingData;

public interface RecycleStation extends ProcessingData{
    void setProcessingData(ProcessingData processingData);
}
