package recyclingStation.core;

import recyclingStation.core.interfaces.Engine;
import recyclingStation.dependencyInjections.injection.Inject;
import recyclingStation.garbageFactory.GarbageFactory;
import recyclingStation.io.interfaces.Reader;
import recyclingStation.io.interfaces.Writer;
import recyclingStation.messages.Messages;
import recyclingStation.models.stations.RecycleStation;
import recyclingStation.wasteDisposal.contracts.GarbageProcessor;
import recyclingStation.wasteDisposal.contracts.ProcessingData;
import recyclingStation.wasteDisposal.contracts.Waste;

public class EngineImpl implements Engine {

    private Reader reader;
    private Writer writer;
    private GarbageProcessor processor;
    private GarbageFactory garbageFactory;
    private RecycleStation station;

    @Inject
    public EngineImpl(Reader reader, Writer writer, GarbageFactory factory, RecycleStation station) {
        this.reader = reader;
        this.writer = writer;
        this.garbageFactory = factory;
        this.station = station;
    }

    public void setProcessor(GarbageProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String input = this.reader.readLine();
                if ("TimeToRecycle".equalsIgnoreCase(input)) {
                    break;
                }

                String[] args = input.split(" ");

                switch (args[0]) {
                    case "ProcessGarbage":
                        String[] garbageArgs = args[1].split("[|]+");
                        Waste waste = this.garbageFactory.createGarbage(garbageArgs);
                        ProcessingData data = this.processor.processWaste(waste);
                        this.station.setProcessingData(data);
                        this.writer.writeLine(
                                String.format(Messages.SUCCESSFUL_PROCESSED,
                                        waste.getWeight(), waste.getName())
                        );
                        break;
                    case "Status":
                        this.writer.writeLine(String.format(Messages.STATUS,
                                this.station.getEnergyBalance(),
                                this.station.getCapitalBalance())
                        );
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
