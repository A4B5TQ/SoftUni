package main.bg.softuni.interfaces;

public interface Database extends Requester, FilteredTaker, OrderedTaker{

    void loadData(String fileName);

    void unloadData();
}
