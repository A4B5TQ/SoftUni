package Repository;

import IO.OutputWriter;
import StaticData.ExceptionMessages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

public class RepositoryFilters {

    public static void printFilteredStudents(HashMap<String, ArrayList<Integer>> courceData,
                                             String filterType, int numberOfStudents) {

        Predicate<Double> filter = createFilter(filterType);
        if (filter == null) {
            OutputWriter.displayException(ExceptionMessages.INVALID_FILTER);
            return;
        }

        int studentsCount = 0;
        for (String student : courceData.keySet()) {
            if (studentsCount == numberOfStudents) {
                break;
            }
            ArrayList<Integer> studentMarks = courceData.get(student);
            Double averageMark = studentMarks.stream().mapToInt(Integer::valueOf)
                    .average()
                    .getAsDouble();

            Double persentageOfFullfilment = averageMark / 100;

            Double mark = persentageOfFullfilment * 4 + 2;

            if (filter.test(mark)) {
                OutputWriter.printStudent(student, studentMarks);
                studentsCount++;
            }

        }

    }

    private static Predicate<Double> createFilter(String filterType) {

        switch (filterType) {
            case "excellent":
                return mark -> mark >= 5.0;
            case "average":
                return mark -> 3.5 <= mark && mark < 5.0;
            case "poor":
                return mark -> mark < 3.5;
            default:
                return null;
        }
    }

//    private static Double getStudentAverageGrage(ArrayList<Integer> grades) {
//        Double totalSum = 0d;
//        for (Integer grade : grades) {
//            totalSum += grade;
//        }
//        Double percentage = totalSum / (grades.size() * 100.0);
//        return (percentage * 4) + 2;
//    }
}
