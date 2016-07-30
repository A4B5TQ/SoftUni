package main.bg.softuni.models;

import main.bg.softuni.exceptions.DuplicateEntryInStructureException;
import main.bg.softuni.exceptions.InvalidStringException;
import main.bg.softuni.exceptions.KeyNotFoundException;
import main.bg.softuni.interfaces.Course;
import main.bg.softuni.interfaces.Student;
import main.bg.softuni.staticData.ExceptionMessages;

import java.util.*;

public class SoftUniStudent implements Student {

    private String userName;
    private LinkedHashMap<String, Course> enrolledCourses;
    private LinkedHashMap<String, Double> marksByCourseName;

    public SoftUniStudent(String userName) {
        this.setUserName(userName);
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourseName = new LinkedHashMap<>();
    }

    public String getUserName() {
        return userName;
    }

    public Map<String, Course> getEnrolledCourses() {
        return Collections.unmodifiableMap(this.enrolledCourses);
    }

    public Map<String, Double> getMarksByCourseName() {
        return Collections.unmodifiableMap(this.marksByCourseName);
    }

    public void enrollInCourse(Course softUniCourse) {
        if (this.enrolledCourses.containsKey(softUniCourse.getName())) {
            throw new DuplicateEntryInStructureException(
                    this.userName, softUniCourse.getName());

        }
        this.enrolledCourses.put(softUniCourse.getName(), softUniCourse);
    }

    public void setMarksInCourse(String courseName, int... scores) {
        if (!this.enrolledCourses.containsKey(courseName)) {
            throw new KeyNotFoundException();
        }

        if (scores.length > SoftUniCourse.NUMBER_OF_TASKS_ON_EXAM) {
            throw new IllegalArgumentException(
                    ExceptionMessages.INVALID_NUMBER_OF_SCORES);
        }

        double mark = calculateMark(scores);
        this.marksByCourseName.put(courseName, mark);
    }

    public String getMarkForCourse(String courseName) {
        String output = String.format("%s - %f",
                this.userName, marksByCourseName.get(courseName));
        return output;
    }

    @Override
    public int compareTo(Student other) {
        return this.getUserName().compareTo(other.getUserName());
    }

    @Override
    public String toString() {
        return this.getUserName();
    }

    private double calculateMark(int[] scores) {
        double persentageOfSolvedExam = Arrays.stream(scores).sum() / (double) (SoftUniCourse.NUMBER_OF_TASKS_ON_EXAM * SoftUniCourse.MAX_SCORE_ON_EXAM_TASK);
        double mark = persentageOfSolvedExam * 4 + 2;
        return mark;
    }

    private void setUserName(String userName) {
        if (userName == null || userName.equals("")) {
            throw new InvalidStringException();
        }
        this.userName = userName;
    }

}
