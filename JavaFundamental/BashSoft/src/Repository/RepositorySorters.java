package Repository;

import IO.OutputWriter;

import java.util.*;
import java.util.stream.Collectors;

public class RepositorySorters {


    public static void printSortedStudents(HashMap<String, ArrayList<Integer>> courceData,
                                           String comparisonType, int numberOfStudents) {

        Comparator<Map.Entry<String, ArrayList<Integer>>> comparator = (x, y) ->
                Double.compare(
                        x.getValue().stream().mapToInt(Integer::valueOf).average().getAsDouble(),
                        y.getValue().stream().mapToInt(Integer::valueOf).average().getAsDouble());


        List<String> sortedStudents = courceData
                .entrySet()
                .stream()
                .sorted(comparator)
                .limit(numberOfStudents)
                .map(x -> x.getKey())
                .collect(Collectors.toList());

        if (comparisonType.equals("descending")) {
            Collections.reverse(sortedStudents);
        }

        for (Map.Entry<String, ArrayList<Integer>> student : courceData.entrySet()) {
            OutputWriter.printStudent(student.getKey(), student.getValue());
        }

    }
}

