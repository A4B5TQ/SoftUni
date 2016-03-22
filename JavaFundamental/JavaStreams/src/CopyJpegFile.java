import java.io.*;

public class CopyJpegFile {
    static final File IMAGE_PATH = new File("res/Skull.jpg");
    static final File OUTPUT_IMAGE_PATH = new File("res/my-copied-skull.jpg");

    public static void main(String[] args) {
        try (FileInputStream reader = new FileInputStream(IMAGE_PATH);
             FileOutputStream writer = new FileOutputStream(OUTPUT_IMAGE_PATH)) {
            Integer readedBytes;
            while ((readedBytes = reader.read()) != -1) {
                writer.write(readedBytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
