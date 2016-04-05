package com.company;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    private static final File FILE_PATH = new File("res/test.txt");

    public static void main(String[] args) throws IOException {

        try {
            URL url = new URL("ftp://ivan:3191222058s@ftp.ivanovbg.com");
            URLConnection urlc = url.openConnection();
            OutputStream os = urlc.getOutputStream(); // To upload
            OutputStream buffer = new BufferedOutputStream(os);
            PrintStream output = new PrintStream(buffer);
            output.print("hiiiii");


            output.close();
            buffer.close();
            os.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
        }
    }
}
