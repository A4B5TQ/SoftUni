package javaOOPAdvance.reflection;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
     MyList<Integer> tsts = new MyList<Integer>(1,2,3);
        System.out.println(tsts.toString());
        Integer[] dgd = tsts.getAll();
        System.out.println(Arrays.toString(dgd));
        dgd[0] = 5;
        System.out.println(Arrays.toString(dgd));
        System.out.println(tsts);
    }
}
