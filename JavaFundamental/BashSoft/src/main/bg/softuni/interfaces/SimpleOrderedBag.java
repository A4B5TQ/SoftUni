package main.bg.softuni.interfaces;

import java.util.Collection;

public interface SimpleOrderedBag<T extends Comparable<T>> extends Iterable<T> {

    boolean remove(T element);

    int capacity();

    void add(T element);

    void addAll(Collection<T> elements);

    int size();

    String joinWith(String joiner);
}
