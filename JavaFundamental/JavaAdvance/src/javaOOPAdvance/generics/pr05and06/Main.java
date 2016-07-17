package javaOOPAdvance.generics.pr05and06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int boxCount = Integer.valueOf(reader.readLine());

        List<Box<Double>> boxes = new ArrayList<>();

        for (int i = 0; i < boxCount; i++) {
            Double boxData = Double.valueOf(reader.readLine());
            Box<Double> box = new Box<>(boxData);
            boxes.add(box);
        }

        Box<Double> compareBox = new Box<>(Double.valueOf(reader.readLine()));
        int count = countGreaterThan(boxes, compareBox);

        System.out.println(count);
    }

    private static <T extends Comparable<T>> int countGreaterThan(List<T> boxes, T element) {
        int count = 0;

        for (T box : boxes) {
            if (box.compareTo(element) > 0){
                count++;
            }
        }

        return count;
    }
}
