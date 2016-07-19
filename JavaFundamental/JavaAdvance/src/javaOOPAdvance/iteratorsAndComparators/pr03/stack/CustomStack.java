package javaOOPAdvance.iteratorsAndComparators.pr03.stack;

import java.util.function.Consumer;

public interface CustomStack extends Iterable<Integer> {
    void push(int element);
    Integer pop();

    @Override
    void forEach(Consumer<? super Integer> action);
}
