package javaOOPAdvance.generics.pr03and04;

public class Box<T> {
    private T data;

    public Box(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.getClass().getName() + ": " + String.valueOf(this.data);
    }
}

