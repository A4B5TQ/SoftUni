package javaOOPAdvance.iteratorsAndComparators.pr01and02.listyIterator;

import java.util.*;
import java.util.function.Consumer;

public class ListyIteratorImpl implements ListyIterator {
    private List<String> data;
    private int index = 0;

    public ListyIteratorImpl(String... elements) {
        this.data = new ArrayList<>();
        this.setData(elements);
    }

    @Override
    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        return (this.index + 1) < this.data.size();
    }

    @Override
    public void print() {
        if (this.data.size() > 0){
            System.out.println(this.data.get(index));
        }
        else {
            throw new NoSuchElementException("Invalid Operation!");
        }
    }

    @Override
    public void printAll() {
        StringBuilder printResult = new StringBuilder();
        this.data.forEach(e -> printResult.append(e).append(" "));
        System.out.println(printResult.toString().trim());
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public String next() {
                return data.get(index++);
            }
        };
    }

    @Override
    @SuppressWarnings("unchecked")
    public void forEach(Consumer action) {
        Iterator<String> iterator = iterator();
        while (iterator.hasNext()){
            action.accept(iterator.next());
        }
    }

    private void setData(String... args) {
        this.data.addAll(Arrays.asList(args));
    }
}
