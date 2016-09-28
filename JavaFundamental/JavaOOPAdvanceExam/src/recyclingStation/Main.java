package recyclingStation;

import recyclingStation.core.EngineImpl;
import recyclingStation.core.interfaces.Engine;
import recyclingStation.dependencyInjections.Dependency;
import recyclingStation.dependencyInjections.injection.Injector;
import recyclingStation.modules.InjectorModule;
import recyclingStation.wasteDisposal.DefaultGarbageProcessor;

public class Main {
    public static void main(String[] args) throws Exception {
        Injector injector = Dependency.getInjector(new InjectorModule());
        Engine engine = (Engine) injector.injectConstructor(EngineImpl.class);
        DefaultGarbageProcessor processor =
                (DefaultGarbageProcessor) injector.injectConstructor(DefaultGarbageProcessor.class);
        engine.setProcessor(processor);
        engine.run();
    }
}
