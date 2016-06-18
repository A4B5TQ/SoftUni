package trainTheTrainers;

import java.util.Arrays;

public class ArraysLive {
    public static void main(String[] args) {

        int[] myArray = new int[10];

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i + 1;
        }
        System.out.println(myArray);
        System.out.println(Arrays.toString(myArray));

        for (int i : myArray) {
            System.out.print(i + " ");
        }
    }
}
