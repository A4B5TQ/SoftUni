package Judge;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class NovTest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Scanner sc = new Scanner(System.in);
        String tst = sc.nextLine();
        String tst2 = sc.nextLine();
        String fnl = tst+"_"+tst2;
        fnl = fnl.replaceAll(" ","_");
        URI uri = new URI("http://ivanovbg.com/test.php?name=" + fnl);
        URL url = uri.toURL(); //get URL from your uri object
        InputStream stream = url.openStream();

    }
}
