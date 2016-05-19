package Judge;

import java.util.Scanner;

public class TestBoolean {
    static Boolean[][] parking;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] matrixSize = sc.nextLine().split("\\s+");
        try{
            parking = new Boolean[Integer.parseInt(matrixSize[0])][Integer.parseInt(matrixSize[0])];
        } catch (OutOfMemoryError err){

        } finally {
            System.out.println("Fuck the judge");
        }

        String[] coordinates = sc.nextLine().split("\\s+");
        while (coordinates[0].equals("stop")){
            coordinates = sc.nextLine().split("\\s+");
        }
    }
}
