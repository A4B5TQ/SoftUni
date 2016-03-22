import java.io.*;

public class SumLines {
    static final File FILE_PATH = new File("res/lines.txt");

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                long charSum = 0;
                for (int i = 0; i < line.length(); i++) {
                    charSum += line.charAt(i);
                }
                System.out.println(charSum);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
