import java.io.*;
import java.util.ArrayList;

public class CountCharacterTypes {
    static final File WORDS_PATH = new File("res/words.txt");
    static final File COUNT_CHARS_PATH = new File("res/count-chars.txt");

    public static void main(String[] args) {

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        ArrayList vowelsArray = getVowelsList();
        ArrayList punctuationArray = getPunctuationList();

        try (BufferedReader reader = new BufferedReader(new FileReader(WORDS_PATH));
             PrintWriter writer = new PrintWriter(new FileWriter(COUNT_CHARS_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (vowelsArray.contains(line.charAt(i))) {
                        vowels++;
                    } else if (punctuationArray.contains(line.charAt(i))) {
                        punctuation++;
                    } else if (Character.isSpaceChar(line.charAt(i))) {
                        continue;
                    } else {
                        consonants++;
                    }
                }
                writer.printf("Vowels: %d\n", vowels);
                writer.printf("Consonants: %d\n", consonants);
                writer.printf("Punctuation:%d\n", punctuation);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList getPunctuationList() {
        return new ArrayList() {{
            add('!');
            add(',');
            add('.');
            add('?');
        }};
    }

    private static ArrayList getVowelsList() {
        return new ArrayList() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
    }
}
