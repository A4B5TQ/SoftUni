package recyclingStation.models.strategies.annotations;

import recyclingStation.wasteDisposal.annotations.Disposable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Disposable
@Retention(RetentionPolicy.RUNTIME)
public @interface Burnable{
}
