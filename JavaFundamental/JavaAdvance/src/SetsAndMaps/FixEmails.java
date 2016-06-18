package setsAndMaps;

import java.util.*;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> namesAndEmails = new LinkedHashMap<>();

        String input;

        while (!(input = sc.nextLine()).equals("stop")){
            String mail = sc.nextLine();
                String check = mail.split("\\.")[1];
                if (!namesAndEmails.containsKey(input) && !check.equals("us") && !check.equals("uk")){
                    namesAndEmails.put(input,mail);
                }
            }
        namesAndEmails.entrySet().stream().forEach(nameAndEmail -> System.out.printf("%s -> %s%n", nameAndEmail.getKey(), nameAndEmail.getValue()));
    }
}
