package javaOOPAdvance.generics.pr03and04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int boxCount = Integer.valueOf(reader.readLine());

        List<Box> boxes = new ArrayList<>();

        for (int i = 0; i < boxCount; i++) {
            Integer boxData = Integer.parseInt(reader.readLine());
            Box<Integer> box = new Box<>(boxData);
            boxes.add(box);
        }

        String[] swapTokens = reader.readLine().split("\\s+");
        swap(boxes, Integer.valueOf(swapTokens[0]), Integer.valueOf(swapTokens[1]));

        for (Box box : boxes) {
            System.out.println(box);
        }

    }

    private static <T> void swap(List<T> datas, int firstIndex, int secondIndex) {
        T firsObject = datas.get(firstIndex);
        T secondObject = datas.get(secondIndex);
        datas.set(firstIndex,secondObject);
        datas.set(secondIndex,firsObject);
    }
}
