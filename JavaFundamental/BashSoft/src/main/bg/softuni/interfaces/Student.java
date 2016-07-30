package main.bg.softuni.interfaces;

import java.util.Map;

public interface Student extends Comparable<Student> {
    String getUserName();

    Map<String, Course> getEnrolledCourses();

    Map<String, Double> getMarksByCourseName();

    void enrollInCourse(Course softUniCourse);

    void setMarksInCourse(String courseName, int... scores);

    String getMarkForCourse(String courseName);

}
