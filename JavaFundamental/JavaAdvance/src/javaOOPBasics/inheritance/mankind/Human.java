package javaOOPBasics.inheritance.mankind;

public class Human {
    private String firstName;
    private String lastName;

    protected Human(String firstName, String lastName) {
        this.setFirtsName(firstName);
        this.setLastName(lastName);
    }

    private void setFirtsName(String name) {
        if (!Character.isUpperCase(name.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if (name.trim().length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }

        this.firstName = name;
    }

    private void setLastName(String name) {
        if (!Character.isUpperCase(name.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if (name.trim().length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = name;
    }

    protected String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }
}
