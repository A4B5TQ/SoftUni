import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OlympicsAreComing {
    public static void main(String[] args) { //TODO
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String,LinkedHashMap<String,Integer>> report = new LinkedHashMap<>();

        String input = sc.nextLine();
        Pattern pat = Pattern.compile("(?<athlete>[A-Za-z ]*)\\s?\\|\\s?(?<country>[a-zA-Z ]*)");

        while (!input.equals("report")){
            input = input.replaceAll("\\s+"," ");
            Matcher match = pat.matcher(input);
            while (match.find()){
                LinkedHashMap<String,Integer> tempMap = new LinkedHashMap<>();
                if (!report.containsKey(match.group("country").trim())){
                    tempMap.put(match.group("athlete").trim(),1);
                    report.put(match.group("country").trim(),tempMap);
                } else {
                    tempMap = report.get(match.group("country").trim());
                    if (!tempMap.containsKey(match.group("athlete").trim())){
                        tempMap.put(match.group("athlete").trim(),1);
                    } else {
                        int tempValue = tempMap.get(match.group("athlete").trim()) + 1;
                        tempMap.put(match.group("athlete").trim(),tempValue);
                    }
                    report.put(match.group("country").trim(),tempMap);
                }
            }
            input = sc.nextLine();
        }
        report.entrySet().stream().sorted((e1,e2) -> {
            return Integer.compare(e2.getValue().values().stream().mapToInt(Integer::intValue).sum(),e1.getValue().values().stream().mapToInt(Integer::intValue).sum());
        }).forEach(pair -> {
            System.out.print(pair.getKey());
            System.out.printf(" (%d participants): ",pair.getValue().values().size());
            System.out.println(pair.getValue().values().stream().mapToInt(Integer::intValue).sum() + " wins");
        });
    }
}
