package javaOOPAdvance.iteratorsAndComparators.pr03.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackIterator implements Iterable<Integer> {

    private Integer[] stack;
    private int currentSize;

    public StackIterator(Integer[] newStack) {
        this.stack = newStack;
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> iterator = new Iterator<Integer>() {

            private int currentIndex = currentSize - 1;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize;
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    return stack[--currentIndex];
                }
                throw new NoSuchElementException("No such element");
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported!");
            }
        };
        return iterator;
    }
}
