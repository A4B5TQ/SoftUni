import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveAnArrayListOfDoubles {
    static final File LIST_PATH = new File("res/doubles.list");
    public static void main(String[] args) {

        List<Double> doubles = new ArrayList<>(Arrays.asList(1.5d,2.7d,3.8,100.589d));

        try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(LIST_PATH))){
            outStream.writeObject(doubles);
            outStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(LIST_PATH))){
            System.out.println(inputStream.readObject().toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
