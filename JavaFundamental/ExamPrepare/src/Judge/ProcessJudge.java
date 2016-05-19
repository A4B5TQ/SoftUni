package Judge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessJudge {
    public static void main(String[] args) {
        try {
            String line;
            Process p = Runtime.getRuntime().exec
                    (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line); //<-- Parse data here.
            }
            input.close();

        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
