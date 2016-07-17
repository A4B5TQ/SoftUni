package javaAdvance.setsAndMaps;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern pat = Pattern.compile("IP=(?<ip>[0-9A-F.:]*)\\s*message='(?<message>.*)'\\s*user=(?<username>.*)");

        TreeMap<String, LinkedHashMap<String, Integer>> mamataSiDjas = new TreeMap<>();

        String input = sc.nextLine();

        while (!input.equals("end")) {

            Matcher match = pat.matcher(input);

            while (match.find()) {
                if (!mamataSiDjas.containsKey(match.group("username"))) {
                    mamataSiDjas.put(match.group("username"), new LinkedHashMap<>());
                }
                if (!mamataSiDjas.get(match.group("username")).containsKey(match.group("ip"))) {
                    mamataSiDjas.get(match.group("username")).put(match.group("ip"), 0);
                }

                int counter = mamataSiDjas.get(match.group("username")).get(match.group("ip"));
                counter++;
                LinkedHashMap<String, Integer> tmp = mamataSiDjas.get(match.group("username"));
                tmp.put(match.group("ip"), counter);
                mamataSiDjas.put(match.group("username"), tmp);
            }
            input = sc.nextLine();
        }

        mamataSiDjas.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey().trim() + ":");
            String[] arr = e.getValue().entrySet().stream().map(Object::toString).toArray(String[]::new);
            List<String> tmp = new LinkedList<String>();
            Arrays.stream(arr).forEach(a -> {
                a = a.replace("="," => ");
                tmp.add(a);
            });
            System.out.print(String.join(", ",tmp));
            System.out.println(".");
        });
    }
}
