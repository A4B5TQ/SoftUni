package solidPrinciples.liskovSubstitution.goodSolutions.employees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager extends Employee {

    private List<String> documents;

    public List<String> getDocuments() {
        ArrayList<String> resultDocuments = new ArrayList<>(this.documents.size());
        Collections.copy(resultDocuments,this.documents);
        return resultDocuments;
    }

    @Override
    public String toString() {
        return super.toString() + "; Documents: " + this.documents.toString();
    }
}
