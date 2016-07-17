package javaOOPBasics.inheritance.mankind;

public class Worker extends Human {
    private double salary;
    private double hoursPerDay;

    public Worker(String firstName, String lastName, double salary, double hoursPerDay) {
        super(firstName, lastName);
        this.setSalary(salary);
        this.setHoursPerDay(hoursPerDay);
    }

    private void setSalary(Double salary) {
        if (salary < 11) {
            throw new IllegalArgumentException("Expected value mismatch! Argument: weekSalary");
        }

        this.salary = salary;
    }

    private void setHoursPerDay(Double workingHours){
        if (workingHours < 1 || workingHours > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.hoursPerDay = workingHours;
    }

   private double getMoneyPerHour() {
        double daySalary = this.salary / 7.0;
        return daySalary / this.hoursPerDay;
    }

    private double getHoursPerDay(){
        return this.hoursPerDay;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("First Name: %s%n" +
                        "Last Name: %s%n" +
                        "Week Salary: %.2f%n" +
                        "Hours per day: %.2f%n" +
                        "Salary per hour: %.2f%n",
                this.getFirstName(),
                this.getLastName(),
                this.getWeekSalary(),
                this.getHoursPerDay(),
                this.getMoneyPerHour()));
        return sb.toString();
    }

    private double getWeekSalary() {
        return this.salary;
    }
}
