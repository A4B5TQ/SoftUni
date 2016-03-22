import java.io.*;

public class SaveACustomObjectInAFile {
    static final File FILE_PATH = new File("res/course.save");

    public static void main(String[] args) {

        Course java = new Course("Java Basic", 250);

        try (ObjectOutputStream objWriter = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            objWriter.writeObject(java);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objReader = new ObjectInputStream(new FileInputStream(FILE_PATH))){
            Course readedCourse = (Course)objReader.readObject();
            readedCourse.printInfo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
