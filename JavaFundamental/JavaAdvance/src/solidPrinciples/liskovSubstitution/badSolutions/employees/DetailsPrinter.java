package solidPrinciples.liskovSubstitution.badSolutions.employees;

import java.util.ArrayList;
import java.util.List;

public class DetailsPrinter {
    private Iterable<Employee> employees;

    public DetailsPrinter(List<Employee> employees)
    {
        this.employees = employees;
    }

    public void print()
    {
        for (Employee employee : this.employees)
        {
            if (employee instanceof Manager)
            {
                this.printManager((Manager) employee);
            }
            else
            {
                this.printEmployee(employee);
            }
        }
    }

    private void printEmployee(Employee employee)
    {
        String name = employee.getName();

        // print name
    }

    private void printManager(Manager manager)
    {
        String name = manager.getName();
        List<String> documents = new ArrayList<>();
        manager.getDocuments().forEach(documents::add);

        // print name and documents
    }
}
