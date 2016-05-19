package Judge;

import java.io.*;
import java.net.*;

public class Testov {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://ivanovbg.com/free/test.txt");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        out.write("var0=" + " " + "&var1=");
        out.close();
        postNewItem();
    }
    static void postNewItem() {
        try {

            URL                url;
            URLConnection      urlConn;
            DataOutputStream   dos;
            DataInputStream    dis;

            url = new URL("http://ivanovbg.com/free/test.txt");
            urlConn = url.openConnection();
            urlConn.setDoInput(true);
            urlConn.setDoOutput(true);
            urlConn.setUseCaches(false);
            //urlConn.setRequestProperty ("Content-Type", "application/x-www-form-urlencoded");

            dos = new DataOutputStream (urlConn.getOutputStream());
            String message = "NEW_ITEM=";
            dos.writeBytes(message);
            dos.flush();
            dos.close();

            // the server responds by saying
            // "SUCCESS" or "FAILURE"

            dis = new DataInputStream(urlConn.getInputStream());
            String s = dis.readLine();
            System.out.println(s);
            dis.close();

            /*if (s.equals("SUCCESS")) {
                toDoList.addItem(addTextField.getText());
                addTextField.setText("");
            } else {
                addTextField.setText("Post Error!");
            }
*/
        } // end of "try"

        catch (MalformedURLException mue) {
            //addTextField.setText("mue error");
        }
        catch (IOException ioe) {
           // addTextField.setText("IO Exception");
        }

    }  // end of postNewItem() method
}