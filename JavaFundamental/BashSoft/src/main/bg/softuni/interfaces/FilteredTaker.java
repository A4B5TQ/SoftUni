package main.bg.softuni.interfaces;

public interface FilteredTaker {

    void filterAndTake(String courseName, String filter);

    public void filterAndTake(String courseName, String filter, int studentsToTake);
}
