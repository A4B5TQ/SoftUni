package setsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String,String> phonebook = new HashMap<>();

        String input = sc.nextLine();

        while (!input.equals("search")){
            String[] datas = input.split("-");
            phonebook.put(datas[0],datas[1]);
            input = sc.nextLine();
        }

        input = sc.nextLine();

        while (!input.equals("stop")){
            if (phonebook.containsKey(input)){
                System.out.printf("%s -> %s%n",input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = sc.nextLine();
        }
    }
}
