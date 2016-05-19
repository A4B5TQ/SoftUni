package Judge;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MakeFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            sb.append(sc.nextLine());

        }

        File flPath = new File(sb.toString());
        if (!flPath.exists()) {
            System.out.println("creating directory: " + flPath);
            boolean result = false;

            try{
                flPath.mkdir();
                result = true;
            }
            catch(SecurityException se){
                System.out.println("Catchna shibaniq Security");
            }
            if(result) {
                System.out.println("DIR created");
            }
        }
    }
}