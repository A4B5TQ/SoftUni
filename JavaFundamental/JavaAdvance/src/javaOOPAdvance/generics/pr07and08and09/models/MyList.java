package javaOOPAdvance.generics.pr07and08and09.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class MyList<E extends Comparable<E>> implements Iterable<E> {
    private List<E> data;

    public MyList() {
        this.data = new ArrayList<>();
    }

    public E get(int index){
       return this.data.get(index);
    }

    public int size(){
        return this.data.size();
    }

    public void sort(){
        Sorter.sort(this);
    }
    public void add(E element){
        this.data.add(element);
    }

    public void remove(int index){
        this.data.remove(index);
    }

    public boolean contains(E element){
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex){
        E firstElement = this.data.get(firstIndex);
        E secondElement = this.data.get(secondIndex);
        this.data.set(firstIndex,secondElement);
        this.data.set(secondIndex,firstElement);
    }

    public int countGreaterThan(E element){
        int count = 0;

        for (E e : this.data) {
            if (e.compareTo(element) > 0){
                count++;
            }
        }

        return count;
    }

    public E getMax(){
        return this.data.stream().max(Comparable::compareTo).get();
    }

    public E getMin(){
        return this.data.stream().min(Comparable::compareTo).get();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public E next() {
                return data.get(index++);
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterator<E> iterator = data.iterator();
        while (iterator.hasNext()){
            action.accept(iterator.next());
        }
    }

    /*public void print() {
        StringBuilder customOutput = new StringBuilder();
        for (E e : data) {
            customOutput.append(e).append(System.lineSeparator());
        }
        System.out.print(customOutput.toString());
    }*/

}
