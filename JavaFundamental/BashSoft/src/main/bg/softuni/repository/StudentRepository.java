package main.bg.softuni.repository;

import main.bg.softuni.dataStructures.SimpleSortedList;
import main.bg.softuni.interfaces.*;
import main.bg.softuni.io.OutputWriter;
import main.bg.softuni.models.SoftUniCourse;
import main.bg.softuni.models.SoftUniStudent;
import main.bg.softuni.staticData.ExceptionMessages;
import main.bg.softuni.staticData.SessionData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentRepository implements Database {

    private HashMap<String, Course> courses;
    private HashMap<String, Student> students;
    private boolean isDataInitialized;
    private DataFilter filter;
    private DataSorter sorter;

    public StudentRepository(DataFilter filter, DataSorter sorter) {
        this.filter = filter;
        this.sorter = sorter;
    }

    public void loadData(String fileName) {
        if (isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }

        this.students = new LinkedHashMap<>();
        this.courses = new LinkedHashMap<>();

        try {
            readData(fileName);
            isDataInitialized = true;
            OutputWriter.writeMessageOnNewLine("Data read.");
        } catch (IOException ioe) {
            OutputWriter.displayException(ExceptionMessages.FILE_NOT_FOUND);
        }
    }

    public void unloadData() {
        if (!isDataInitialized) {
            throw new RuntimeException(ExceptionMessages.DATA_NOT_INITIALIZED);
        }

        this.courses = null;
        this.students = null;
        this.isDataInitialized = false;
    }

    public void getStudentMarksInCourse(String courseName, String studentName) {

        if (!isQueryForStudentPossible(courseName, studentName)) {
            return;
        }
//        double mark = this.courses.get(courseName).getStudentsByName().get(studentName).getMarksByCourseName().get(courseName);
//        OutputWriter.printStudent(studentName, mark);
        String output = students.get(studentName).getMarkForCourse(courseName);
        OutputWriter.writeMessageOnNewLine(output);
    }

    public void getStudentsByCourse(String courseName) {

        if (!isQueryForCoursePossible(courseName)) {
            return;
        }

        OutputWriter.writeMessageOnNewLine(courseName + ":");
        for (Map.Entry<String, Student> student :
                this.courses.get(courseName).getStudentsByName().entrySet()) {

            this.getStudentMarksInCourse(courseName, student.getKey());
        }
    }

    @Override
    public SimpleSortedList<Course> getAllCoursesSorted(Comparator<Course> cmp) {
        SimpleSortedList<Course> courseSortedList = new SimpleSortedList<>(Course.class, cmp);
        courseSortedList.addAll(this.courses.values());

        return courseSortedList;
    }

    @Override
    public SimpleSortedList<Student> getAllStudentsSorted(Comparator<Student> cmp) {
       SimpleSortedList<Student> studentSortedList = new SimpleSortedList<>(Student.class, cmp);
        studentSortedList.addAll(this.students.values());

        return studentSortedList;
    }

    public void filterAndTake(String courseName, String filter) {
        int studentsToTake = this.courses.get(courseName).getStudentsByName().size();
        this.filterAndTake(courseName, filter, studentsToTake);
    }

    public void filterAndTake(String courseName, String filter, int studentsToTake) {
        if (!isQueryForCoursePossible(courseName)) {
            return;
        }

        LinkedHashMap<String, Double> marks = new LinkedHashMap<>();
        for (Map.Entry<String, Student> entry :
                this.courses.get(courseName).getStudentsByName().entrySet()) {
            marks.put(entry.getKey(), entry.getValue().getMarksByCourseName().get(courseName));

        }

        this.filter.printFilteredStudents(marks, filter, studentsToTake);
    }

    public void orderAndTake(String courseName, String orderType, int studentsToTake) {
        if (!isQueryForCoursePossible(courseName)) {
            return;
        }

        LinkedHashMap<String, Double> marks = new LinkedHashMap<>();
        for (Map.Entry<String, Student> entry :
                this.courses.get(courseName).getStudentsByName().entrySet()) {
            marks.put(entry.getKey(), entry.getValue().getMarksByCourseName().get(courseName));

        }

        this.sorter.printSortedStudents(marks, orderType, studentsToTake);
    }

    public void orderAndTake(String courseName, String orderType) {
        int studentsToTake = this.courses.get(courseName).getStudentsByName().size();
        this.orderAndTake(courseName, orderType, studentsToTake);
    }

    private void readData(String fileName) throws IOException {
        String regex = "([A-Z][a-zA-Z#\\+]*_[A-Z][a-z]{2}_\\d{4})\\s+([A-Za-z]+\\d{2}_\\d{2,4})\\s([\\s0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        //String path = SessionData.currentPath + "\\resources\\" + fileName;
        String path = SessionData.currentPath + "\\" + fileName;
        List<String> lines = Files.readAllLines(Paths.get(path));

        for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
            String line = lines.get(lineIndex);
            matcher = pattern.matcher(line);

            if (!line.isEmpty() && matcher.find()) {
                String courseName = matcher.group(1);
                String studentName = matcher.group(2);
                String scoreStr = matcher.group(3);

                try {
                    String[] splitScores = scoreStr.split("\\s+");
                    int[] scores = new int[splitScores.length];
                    for (int i = 0; i < splitScores.length; i++) {
                        scores[i] = Integer.parseInt(splitScores[i]);

                    }
                    if (Arrays.stream(scores).anyMatch(score -> score > 100 || score < 0)) {
                        OutputWriter.displayException(ExceptionMessages.INVALID_SCORE);
                        continue;
                    }

                    if (scores.length > SoftUniCourse.NUMBER_OF_TASKS_ON_EXAM) {
                        OutputWriter.displayException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
                        continue;
                    }

                    if (!this.students.containsKey(studentName)) {
                        this.students.put(studentName, new SoftUniStudent(studentName));
                    }

                    if (!this.courses.containsKey(courseName)) {
                        this.courses.put(courseName, new SoftUniCourse(courseName));
                    }

                    Course softUniCourse = this.courses.get(courseName);
                    Student softUniStudent = this.students.get(studentName);
                    softUniStudent.enrollInCourse(softUniCourse);
                    softUniStudent.setMarksInCourse(courseName, scores);
                    softUniCourse.enrollStudent(softUniStudent);
                } catch (NumberFormatException nfe) {
                    OutputWriter.displayException(nfe.getMessage() + " at line: " + lineIndex);
                }
            }
        }
    }

    private boolean isQueryForCoursePossible(String course) {

        if (!isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }

        if (!this.courses.containsKey(course)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_COURSE);
            return false;
        }
        return true;
    }

    private boolean isQueryForStudentPossible(String courseName, String studentName) {

        if (!isQueryForCoursePossible(courseName)) {
            return false;
        }

        if (!this.courses.get(courseName).getStudentsByName().containsKey(studentName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_STUDENT);
            return false;
        }

        return true;
    }

}
