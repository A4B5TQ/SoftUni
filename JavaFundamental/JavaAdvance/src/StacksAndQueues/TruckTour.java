package stacksAndQueues;

import java.util.Scanner;

public class TruckTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 0;
        int startIndex = 0;

        for (int i = 0; i < n; i++) {

            int petrol = sc.nextInt();
            int distance = sc.nextInt();
            sum += petrol - distance;

            if (sum < 0) {
                sum = 0;
                startIndex = i + 1;
            }
        }
        System.out.println(startIndex);
    }
}
