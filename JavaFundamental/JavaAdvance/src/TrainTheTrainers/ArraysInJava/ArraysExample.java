package trainTheTrainers.ArraysInJava;

public class ArraysExample {
    public static void main(String[] args) {

        int[] numbers = new int[10];

        for (int i=0; i<numbers.length; i++) {
            numbers[i] = i+1;
        }

        numbers[3] = 20;
        numbers[5] = numbers[2] + numbers[7];

        String[] arr = new String[5];
        System.out.println(arr[0]);

        System.out.println(System.getProperty("user.dir"));

    }
}
