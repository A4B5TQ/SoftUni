package javaOOPBasics.defineClasses.problem01And02And03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Person {
   String name;
   int age;

    public Person() {
        this("No name", 1);
    }

    public Person(int age){

        this("No name",age);
    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        int count = Integer.parseInt(reader.readLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] input = reader.readLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            persons.add(new Person(name,age));
        }
        persons.stream()
                .sorted((a,b) -> a.name.compareTo(b.name))
                .filter(e -> e.age > 30)
                .forEach(p -> System.out.printf("%s - %d%n",p.name,p.age));
    }

}