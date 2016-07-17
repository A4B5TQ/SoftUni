package javaOOPBasics.defineClasses.problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {

    String name;
    Double salary;
    String position;
    String department;
    String email;
    Integer age;

    public Employee(String name, Double salary, String position, String department, String email, Integer age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, Double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    public Employee(String name, Double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    public Employee(String name, Double salary, String position, String department, Integer age) {
        this(name, salary, position, department, "n/a", age);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(sc.readLine());

        LinkedHashMap<String, List<Employee>> employees = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] inputData = sc.readLine().split("\\s+");
            String name = inputData[0];
            Double salary = Double.parseDouble(inputData[1]);
            String position = inputData[2];
            String department = inputData[3];

            Employee employee = new Employee(name, salary, position, department);

            if (inputData.length == 5) {
                try {
                    Integer age = Integer.parseInt(inputData[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (Exception ex) {
                    String email = inputData[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else if (inputData.length == 6) {
                String email = inputData[4];
                Integer age = Integer.parseInt(inputData[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }

            if (!employees.containsKey(department)) {
                employees.put(department, new ArrayList<>());
            }

            employees.get(department).add(employee);
        }

        String department = "";

        System.out.printf("Highest Average Salary: %s%n", department = employees.entrySet()
                .stream().sorted((e1, e2) -> {
                    double curAvgSalaryE1 = e1.getValue().stream()
                            .collect(Collectors.averagingDouble(a -> a.salary));

                    double curAvgSalaryE2 = e2.getValue().stream()
                            .collect(Collectors.averagingDouble(a -> a.salary));

                    return Double.compare(curAvgSalaryE2, curAvgSalaryE1);

                }).findFirst().get().getKey());

        employees.get(department).stream()
                .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
                .forEach(e -> System.out.printf("%s %.2f %s %d%n",
                        e.name,
                        e.salary,
                        e.email,
                        e.age));
    }
}
