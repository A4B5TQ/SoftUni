package javaOOPAdvance.generics.pr01and02;

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

