package solidPrinciples.singleResponibility.badSolutions.pr01;

public class Book {
    private String title;
    private String author;
    private String location;

    public String turnPage(int page){
        return "Current page";
    }

}
