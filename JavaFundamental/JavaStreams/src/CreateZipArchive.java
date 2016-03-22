import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    static final File words = new File("res/words.txt");
    static final File chars = new File("res/count-chars.txt");
    static final File lines = new File("res/lines.txt");
    static final File SAVE_ZIP = new File("res/text-files.zip");

    public static void main(String[] args) {
        try (FileInputStream readerWords = new FileInputStream(words);
             FileInputStream readerChars = new FileInputStream(chars);
             FileInputStream readerLines = new FileInputStream(lines);
             ZipOutputStream zipWriter = new ZipOutputStream(new FileOutputStream(SAVE_ZIP))) {

            zipWriter.putNextEntry(new ZipEntry(words.getName()));
            Integer s;
            while ((s = readerWords.read()) != -1) {
                zipWriter.write(s);
            }
            zipWriter.closeEntry();

            zipWriter.putNextEntry(new ZipEntry(chars.getName()));
            while ((s = readerChars.read()) != -1) {
                zipWriter.write(s);
            }
            zipWriter.closeEntry();

            zipWriter.putNextEntry(new ZipEntry(lines.getName()));
            while ((s = readerLines.read()) != -1) {
                zipWriter.write(s);
            }
            zipWriter.closeEntry();

            zipWriter.finish();
            zipWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
