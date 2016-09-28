package recyclingStation.wasteDisposal;


import recyclingStation.dependencyInjections.injection.Inject;
import recyclingStation.models.strategies.BurnableDisposalStrategy;
import recyclingStation.models.strategies.RecycleDisposalStrategy;
import recyclingStation.models.strategies.StorableDisposalStrategy;
import recyclingStation.models.strategies.annotations.Burnable;
import recyclingStation.models.strategies.annotations.Recyclable;
import recyclingStation.models.strategies.annotations.Storable;
import recyclingStation.wasteDisposal.contracts.*;

import java.lang.annotation.Annotation;

public class DefaultGarbageProcessor implements GarbageProcessor {

    private StrategyHolder strategyHolder;

    @Inject
    public DefaultGarbageProcessor(StrategyHolder strategyHolder) {
        this.setStrategyHolder(strategyHolder);
        this.initializeStrategies();
    }

    @Override
    public StrategyHolder getStrategyHolder() {
        return this.strategyHolder;
    }

    @Override
    public ProcessingData processWaste(Waste garbage) {
        Class disposableAnnotationClass = this.getDisposableAnnotationClass(garbage);

        if (disposableAnnotationClass == null ||
                !this.getStrategyHolder().getDisposalStrategies()
                        .containsKey(disposableAnnotationClass)) {
            throw new IllegalArgumentException(
                    "The passed in garbage does not implement an annotation implementing the Disposable meta-annotation or is not supported by the StrategyHolder.");
        }
        GarbageDisposalStrategy currentStrategy =
                this.getStrategyHolder().getDisposalStrategies()
                        .get(disposableAnnotationClass);
        return currentStrategy.processGarbage(garbage);
    }

    private Class getDisposableAnnotationClass(Waste garbage) {
        Class disposableAnnotation = null;
        Class type = garbage.getClass();
        Annotation[] garbageAnnotations = type.getAnnotations();
        for (Annotation annotation : garbageAnnotations) {
            if (type.isAnnotationPresent(annotation.annotationType())) {
                disposableAnnotation = annotation.annotationType();
                break;
            }
        }
        return disposableAnnotation;
    }

    private void initializeStrategies() {
       this.strategyHolder.addStrategy(Burnable.class, new BurnableDisposalStrategy());
       this.strategyHolder.addStrategy(Recyclable.class, new RecycleDisposalStrategy());
       this.strategyHolder.addStrategy(Storable.class, new StorableDisposalStrategy());
    }

    private void setStrategyHolder(StrategyHolder strategyHolder) {
        this.strategyHolder = strategyHolder;
    }
}
