package javaOOPAdvance.generics.pr05and06;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>>{
    private T data;

    public Box(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.getClass().getName() + ": " + String.valueOf(this.data);
    }


    @Override
    public int compareTo(Box<T> o) {
        return this.data.compareTo(o.data);
    }
}

