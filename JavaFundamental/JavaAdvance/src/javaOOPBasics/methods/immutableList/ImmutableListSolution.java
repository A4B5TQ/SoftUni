package javaOOPBasics.methods.immutableList;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class ImmutableList {
    List<Integer> listOfNumbers;

    public ImmutableList(){
        this.listOfNumbers = new ArrayList<>();
    }

    public ImmutableList getImmutableList(){
        return new ImmutableList();
    }
}
public class ImmutableListSolution {
    public static void main(String[] args) {
        Class listClass = ImmutableList.class;
        Field[] fields = listClass.getDeclaredFields();
        if (fields.length < 1) {
            throw new ClassFormatException();
        }

        Method method = listClass.getDeclaredMethods()[0];
        System.out.println(method.getReturnType().getSimpleName());

    }
}
