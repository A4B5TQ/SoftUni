import java.io.Serializable;

public class Course implements Serializable {
    private String name;
    private Integer count;

    public Course(String name,Integer count) {
        this.name = name;
        this.count = count;
    }

    public void printInfo(){
        System.out.println(name + " " + count);
    }
}
