package javaAdvance.Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Matcher matcher = Pattern.compile("^(\\p{Alnum}{5,10})$").matcher(sc.readLine());

        if (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
