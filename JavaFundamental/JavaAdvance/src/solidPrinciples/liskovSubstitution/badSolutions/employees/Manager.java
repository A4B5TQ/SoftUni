package solidPrinciples.liskovSubstitution.badSolutions.employees;

public class Manager extends Employee{

    private Iterable<String> documents;

    public Iterable<String> getDocuments() {
        return this.documents;
    }
}
