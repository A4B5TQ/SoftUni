package javaOOPBasics.methods.methodSayHello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Person {
    String name;

    public Person(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name + " says \"Hello\"!";
    }
}
public class MethodSayHello {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String name = sc.readLine();

        Person person = new Person(name);

        System.out.println(person.toString());
    }
}
