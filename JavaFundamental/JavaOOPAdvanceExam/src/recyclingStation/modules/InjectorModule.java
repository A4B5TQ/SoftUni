package recyclingStation.modules;

import recyclingStation.dependencyInjections.module.AbstractModule;
import recyclingStation.garbageFactory.GarbageFactory;
import recyclingStation.garbageFactory.GarbageFactoryImpl;
import recyclingStation.io.ConsoleReader;
import recyclingStation.io.ConsoleWriter;
import recyclingStation.io.interfaces.Reader;
import recyclingStation.io.interfaces.Writer;
import recyclingStation.models.stations.RecycleStation;
import recyclingStation.models.stations.RecycleStationImpl;
import recyclingStation.wasteDisposal.DefaultStrategyHolder;
import recyclingStation.wasteDisposal.contracts.StrategyHolder;

public class InjectorModule extends AbstractModule {
    @Override
    public void configure() {
        createMapping(StrategyHolder.class, DefaultStrategyHolder.class);
        createMapping(Writer.class, ConsoleWriter.class);
        createMapping(Reader.class, ConsoleReader.class);
        createMapping(GarbageFactory.class, GarbageFactoryImpl.class);
        createMapping(RecycleStation.class, RecycleStationImpl.class);
    }
}
