import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ImplementRecursiveBinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int element = Integer.parseInt(sc.nextLine());
        Integer[] arr = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Arrays.sort(arr, (e1, e2) -> e1.compareTo(e2));

        int index = getIndexOf(arr, element, 0, arr.length);
        System.out.println(index); //Return the index of the element, or -1, if the element is not found.
    }

    private static int getIndexOf(Integer[] sortedArray, int element, int leftFrom, int rightTO) {

        if (element > sortedArray[rightTO - 1] || element < sortedArray[leftFrom]) {

            return -1;
        }

        int middle = (leftFrom + rightTO) / 2;

        if (element > sortedArray[middle]) {

            return getIndexOf(sortedArray, element, middle + 1, rightTO);

        } else if (element < sortedArray[middle]) {

            return getIndexOf(sortedArray, element, leftFrom, rightTO - 1);

        } else if (element == sortedArray[middle]) {

            return middle;
        }

        return -1;
    }
}
