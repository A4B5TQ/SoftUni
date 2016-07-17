package javaOOPBasics.inheritance.mankind;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber){
        if (facultyNumber.trim().length() < 5 ||
                facultyNumber.trim().length() > 10){
            throw new IllegalArgumentException("Invalid faculty number!");
        } else {
            Pattern facultyValidator = Pattern.compile("^(\\p{Alnum}{5,10})$");
            Matcher match = facultyValidator.matcher(facultyNumber);
            if (!match.find()){
                throw new IllegalArgumentException("Invalid faculty number!");
            }
            this.facultyNumber = facultyNumber;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s%n" +
                        "Last Name: %s%n" +
                        "Faculty number: %s%n",
                this.getFirstName(),
                this.getLastName(),
                this.getFacultyNumber()));
        return sb.toString();
    }

    private String getFacultyNumber() {
        return facultyNumber;
    }

    @Override
    protected String getFirstName() {
        return super.getFirstName();
    }

    @Override
    protected String getLastName() {
        return super.getLastName();
    }
}
