package javaOOPAdvance.iteratorsAndComparators.pr01and02.factory;

import javaOOPAdvance.iteratorsAndComparators.pr01and02.listyIterator.ListyIteratorImpl;

public interface ListyIteratorFactory {
    ListyIteratorImpl create(String[] tokens);
}
