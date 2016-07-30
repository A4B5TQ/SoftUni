package main.bg.softuni.interfaces;

import main.bg.softuni.dataStructures.SimpleSortedList;

import java.util.Comparator;

public interface Requester {

    void getStudentMarksInCourse(String courseName, String studentName);

    void getStudentsByCourse(String courseName);

    SimpleSortedList<Course> getAllCoursesSorted(Comparator<Course> cmp);

    SimpleSortedList<Student> getAllStudentsSorted(Comparator<Student> cmp);
}
