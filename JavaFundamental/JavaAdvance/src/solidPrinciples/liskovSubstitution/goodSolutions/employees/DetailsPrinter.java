package solidPrinciples.liskovSubstitution.goodSolutions.employees;

import java.util.List;

public class DetailsPrinter {
    private List<Employee> employees;

    public DetailsPrinter(List<Employee> employees)
    {
        this.employees = employees;
    }

    public void print() {
        for (Employee employee : this.employees) {

           String result =  employee.toString();

            //print result
        }
    }
}
