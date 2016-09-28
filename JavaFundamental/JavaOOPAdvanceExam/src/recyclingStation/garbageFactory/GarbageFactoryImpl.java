package recyclingStation.garbageFactory;

import recyclingStation.wasteDisposal.contracts.Waste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GarbageFactoryImpl implements GarbageFactory {
    private static final String GARBAGE_PATH = "recyclingStation.models.garbages.";
    private static final int GARBAGE_DEFAULT_CONSTRUCTOR_INDEX = 0;
    private static final int NAME_INDEX = 0;
    private static final int WEIGHT_INDEX = 1;
    private static final int VOLUME_PER_KG_INDEX = 2;
    private static final int TYPE_INDEX = 3;

    @Override
    public Waste createGarbage(String... args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String name = args[NAME_INDEX];
        Double weight = Double.parseDouble(args[WEIGHT_INDEX]);
        Double volumePerKg = Double.parseDouble(args[VOLUME_PER_KG_INDEX]);
        Class garbageClass = Class.forName(GARBAGE_PATH + args[TYPE_INDEX] + "Garbage");
        Constructor constructor = garbageClass.getConstructors()[GARBAGE_DEFAULT_CONSTRUCTOR_INDEX];
        return (Waste) constructor.newInstance(name,weight,volumePerKg);
    }
}
