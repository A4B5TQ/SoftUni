package javaOOPAdvance.iteratorsAndComparators.pr01and02.factory;

import javaOOPAdvance.iteratorsAndComparators.pr01and02.listyIterator.ListyIteratorImpl;

import java.util.Arrays;

public class ListyIteratorFactoryImpl implements ListyIteratorFactory {
    @Override
    public ListyIteratorImpl create(String[] tokens) {
        return new ListyIteratorImpl(Arrays.stream(tokens).skip(1).toArray(String[]::new));
    }
}
