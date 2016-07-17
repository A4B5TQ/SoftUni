package javaOOPBasics.inheritance.mankind;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String[] studentInput = scanner.nextLine().split("[\\s]+");
            String studentName = studentInput[0];
            String studentLastName = studentInput[1];
            String facultyNumber = studentInput[2];

            String[] workerInput = scanner.nextLine().split("[\\s]+");
            String workerName = workerInput[0];
            String workerLastName = workerInput[1];
            Double salary = Double.valueOf(workerInput[2]);
            Double workHours = Double.valueOf(workerInput[3]);

            Student student = new Student(studentName, studentLastName, facultyNumber);
            Worker worker = new Worker(workerName, workerLastName, salary, workHours);

            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
