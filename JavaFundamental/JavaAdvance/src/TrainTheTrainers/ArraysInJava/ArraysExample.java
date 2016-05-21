package TrainTheTrainers.ArraysInJava;

public class ArraysExample {
    public static void main(String[] args) {

        int[] numbers = new int[10];

        for (int i=0; i<numbers.length; i++) {
            numbers[i] = i+1;
        }

        numbers[3] = 20;
        numbers[5] = numbers[2] + numbers[7];

    }
}
