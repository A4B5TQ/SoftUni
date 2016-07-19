package javaOOPAdvance.iteratorsAndComparators.pr03.stack;

import javax.naming.OperationNotSupportedException;
import java.util.function.Consumer;

public interface CustomStack extends Iterable<Integer> {
    void push(int element);
    Integer pop() throws OperationNotSupportedException;

    @Override
    void forEach(Consumer<? super Integer> action);
}
