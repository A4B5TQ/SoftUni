package javaOOPBasics.inheritance.person;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name){
        if (name.trim().length()< 3){
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }

        this.name = name;
    }

    protected void setAge(int age){
        if (age < 0){
            throw new IllegalArgumentException("Age must be positive!");
        }

        this.age = age;
    }

    private String getName(){
        return this.name;
    }

    private int getAge(){
        return this.age;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge()));
        return stringBuilder.toString();
    }

}
