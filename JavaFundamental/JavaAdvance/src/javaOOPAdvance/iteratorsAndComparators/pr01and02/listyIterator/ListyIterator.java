package javaOOPAdvance.iteratorsAndComparators.pr01and02.listyIterator;

public interface ListyIterator extends Iterable<String>{
    boolean move();

    boolean hasNext();

    void print();

    void printAll();
}
