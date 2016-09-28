package recyclingStation.core.interfaces;

import recyclingStation.wasteDisposal.contracts.GarbageProcessor;

public interface Engine {
    void run();
    void setProcessor(GarbageProcessor processor);
}
