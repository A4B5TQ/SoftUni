package javaOOPBasics.methods.oldestFamilyMember;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public Integer getAge(){
        return this.age;
    }

    @Override
    public String toString(){
        return this.name + " " + this.age;
    }
}

class Family {
    List<Person> persons;

    public Family(){
        this.persons = new ArrayList<>();
    }

    public void addMember(Person person){
        this.persons.add(person);
    }

    public Person getOldestMember(){
        return this.persons.stream().sorted((firstPerson,secondPerson) ->
                Integer.compare(secondPerson.getAge(),firstPerson.getAge()))
                .findFirst().get();
    }
}


public class OldestFamilyMember {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int personsCount = Integer.parseInt(sc.readLine());

        Family family = new Family();

        for (int i = 0; i < personsCount; i++) {
            String[] personsInfo = sc.readLine().split("\\s+");
            Person person = new Person(personsInfo[0],Integer.parseInt(personsInfo[1]));

            family.addMember(person);
        }

        System.out.println(family.getOldestMember().toString());
    }
}
