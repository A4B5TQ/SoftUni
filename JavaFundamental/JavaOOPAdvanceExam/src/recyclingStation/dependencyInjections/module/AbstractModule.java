package recyclingStation.dependencyInjections.module;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractModule implements Module {
    private Map<Class<?>, Class<?>> classMap = new HashMap<>();
    private Map<Class<?>, Object> instancesMap = new HashMap<>();

    @Override
    public abstract void configure();

    public <T> void createMapping(Class<T> baseClass, Class<? extends T> subClass) {
        this.classMap.put(baseClass, subClass.asSubclass(baseClass));
    }

    @Override
    public <T> Class<? extends T> getMapping(Class<T> type) {
        Class<?> implementation = this.classMap.get(type);

        if (implementation == null) {

            throw new IllegalArgumentException("Couldn't find the mapping for : " + type);
        }

        return implementation.asSubclass(type);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object getInstance(Class<?> classAbtraction) {
       return this.instancesMap.get(classAbtraction);
    }

    @Override
    public void setInstance(Class<?> classAbtraction, Object instance) {
        this.instancesMap.put(classAbtraction,instance);
    }
}
