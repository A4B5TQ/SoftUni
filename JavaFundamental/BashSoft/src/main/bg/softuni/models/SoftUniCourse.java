package main.bg.softuni.models;

import main.bg.softuni.exceptions.DuplicateEntryInStructureException;
import main.bg.softuni.exceptions.InvalidStringException;
import main.bg.softuni.interfaces.Course;
import main.bg.softuni.interfaces.Student;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class SoftUniCourse implements Course{

    public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
    public static final int MAX_SCORE_ON_EXAM_TASK = 100;

    private String name;
    private LinkedHashMap<String, Student> studentsByName;

    public SoftUniCourse(String name) {
        this.setName(name);
        this.studentsByName = new LinkedHashMap<>();
    }

    public Map<String, Student> getStudentsByName() {
        return Collections.unmodifiableMap(this.studentsByName);
    }

    public String getName() {
        return this.name;
    }

    public void enrollStudent(Student softUniStudent) {
        if (studentsByName.containsKey(softUniStudent.getUserName())) {
            throw new DuplicateEntryInStructureException(
                    softUniStudent.getUserName(), this.name);
        }

        this.studentsByName.put(softUniStudent.getUserName(), softUniStudent);
    }

    @Override
    public int compareTo(Course other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }

    private void setName(String name) {
        if (name == null || name.equals("")) {
            throw new InvalidStringException();
        }
        this.name = name;
    }


}
