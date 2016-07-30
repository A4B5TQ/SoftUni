package main.bg.softuni.interfaces;

import java.util.HashMap;

public interface DataFilter {

    void printFilteredStudents(HashMap<String, Double> studentsWithMarks, String filterType, int numberOfStudents);
}
