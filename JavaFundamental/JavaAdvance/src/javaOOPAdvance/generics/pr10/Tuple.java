package javaOOPAdvance.generics.pr10;

public class Tuple<Item1, Item2> {
    private Item1 firstItem;
    private Item2 secondItem;

    public Tuple(Item1 item1, Item2 item2) {
        this.firstItem = item1;
        this.secondItem = item2;
    }

    public void print(){
        System.out.println(String.format("%s -> %s",firstItem,secondItem));
    }
}
