import java.util.Locale;
import java.util.Scanner;

public class GetAverage {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ROOT);

        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double avarage = getAvarage(a,b,c);

        System.out.printf("%.2f",avarage);
    }

    private static double getAvarage(double a, double b, double c) {

        return (a + b + c) / 3;
    }

}
