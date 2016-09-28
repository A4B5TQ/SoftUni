package recyclingStation.dependencyInjections.injection;

import recyclingStation.dependencyInjections.module.Module;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Injector {
    private Module module;

    public Injector(Module module) {
        this.module = module;
    }

    @SuppressWarnings("unchecked")
    public Object injectConstructor(Class desireClass) throws Exception {
        if (desireClass != null) {

            for (Constructor constructor : desireClass.getConstructors()) {
                if (constructor.isAnnotationPresent(Inject.class)) {

                    Class[] parameterTypes = constructor.getParameterTypes();
                    Object[] objArr = new Object[parameterTypes.length];

                    int i = 0;

                    for (Class currentClass : parameterTypes) {
                        Class dependency = this.module.getMapping(currentClass);
                        this.injectFields(dependency);
                        if (currentClass.isAssignableFrom(dependency)) {
                            Object instance = this.module.getInstance(dependency);
                            if (instance != null){
                                objArr[i++] = instance;
                            } else {
                                instance = dependency.getConstructor().newInstance();
                                objArr[i++] = instance ;
                                this.module.setInstance(currentClass, instance);
                            }
                        }
                    }

                    return desireClass.getConstructor(parameterTypes).newInstance(objArr);
                }
            }
        }
        return desireClass;
    }

    @SuppressWarnings("unchecked")
    public Object injectFields(Class desireClass) throws Exception {
        Object desireClassInstance = this.module.getInstance(desireClass);
        if (desireClassInstance == null) {
            desireClassInstance = desireClass.newInstance();
            this.module.setInstance(desireClass, desireClassInstance);
        }

        Field[] fieldsToSet = desireClass.getDeclaredFields();
        for (Field field : fieldsToSet) {
            if (!field.isAnnotationPresent(Inject.class)) {
                continue;
            }

            field.setAccessible(true);
            Class fieldType = field.getType();
            Class dependency = this.module.getMapping(fieldType);
            Class objectInstance = null;
            if (fieldType.isAssignableFrom(dependency)) {
                objectInstance = this.module.getMapping(fieldType);
            }
            Object dependencyClassInstance = objectInstance.getConstructor().newInstance();

            field.set(desireClassInstance, dependencyClassInstance);
        }
        return desireClassInstance;
    }
}
