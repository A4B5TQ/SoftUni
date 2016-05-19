import java.util.Iterator;
import java.util.function.Consumer;

public class Person implements Comparable,Iterable{
    private String NAME;
    private Integer AGE;

    public Person() {
    }

    public Integer getAGE() {
        return this.AGE;
    }

    public void setAGE(Integer age) {
        this.AGE = age;
    }

    public void setNAME(String name) {
        this.NAME = name;
    }

    public String getNAME() {
        return this.NAME;

    }

    @Override
    public String toString() {
        return String.format("%s -> %d",this.NAME,this.AGE);
    }

    @Override
    public int compareTo(Object other2) {
        Person other = (Person) other2;
        int i = NAME.compareTo(other.NAME);
        if (i != 0) return i;

        return Integer.compare(AGE, other.AGE);
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
    }
}

