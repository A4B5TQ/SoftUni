package recyclingStation.garbageFactory;

import recyclingStation.wasteDisposal.contracts.Waste;

import java.lang.reflect.InvocationTargetException;

public interface GarbageFactory {
    Waste createGarbage(String... args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
