package main.bg.softuni.interfaces;

public interface OrderedTaker {

    void orderAndTake(String courseName, String orderType, int studentsToTake);

    void orderAndTake(String courseName, String orderType);
}
