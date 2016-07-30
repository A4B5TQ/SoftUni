package javaOOPAdvance.reflection;

import java.util.Arrays;

public class MyList<T> {
    private T[] tst;

    public MyList(T... args){
        this.tst=args;

    }

    public T[] getAll(){
        return Arrays.copyOf(this.tst,tst.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.tst);
    }
}
