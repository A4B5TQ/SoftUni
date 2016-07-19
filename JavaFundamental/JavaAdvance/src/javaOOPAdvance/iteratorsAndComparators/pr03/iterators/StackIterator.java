package javaOOPAdvance.iteratorsAndComparators.pr03.iterators;

import java.util.Iterator;

public class StackIterator implements Iterable<Integer> {

    private Integer[] stack;
    private int currentSize;

    public StackIterator(Integer[] newStack) {
        this.stack = newStack;
        this.currentSize = stack.length;
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> iterator = new Iterator<Integer>() {

            private int currentIndex = currentSize - 1;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && currentIndex > 0;
            }

            @Override
            public Integer next() {
                return stack[--currentIndex];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported!");
            }
        };
        return iterator;
    }
}
