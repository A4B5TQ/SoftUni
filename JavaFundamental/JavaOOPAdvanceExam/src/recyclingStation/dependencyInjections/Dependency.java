package recyclingStation.dependencyInjections;


import recyclingStation.dependencyInjections.injection.Injector;
import recyclingStation.dependencyInjections.module.Module;

public class Dependency {
    public static Injector getInjector(Module module) {
        module.configure();
        return new Injector(module);
    }
}
