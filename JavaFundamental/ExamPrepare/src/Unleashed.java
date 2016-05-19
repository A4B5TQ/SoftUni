import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String,Long>> inputData = new LinkedHashMap<>();

        String input = sc.nextLine();

        Pattern pat = Pattern.compile("(?<singer>[\\p{L}\\s]+)\\s@(?<venue>[\\p{L}\\s]+)\\s(?<ticketsCount>[0-9]+)\\s(?<ticketsPrice>[0-9]+)");

        while (!"End".equals(input)){
            Matcher match = pat.matcher(input);
            if (match.find()){
                if (!inputData.containsKey(match.group("venue"))){
                    LinkedHashMap<String,Long> tempMap = new LinkedHashMap<>();
                    tempMap.put(match.group("singer"),Long.parseLong(match.group("ticketsCount")) * Long.parseLong(match.group("ticketsPrice")));
                    inputData.put(match.group("venue"),tempMap);
                } else {
                    LinkedHashMap<String,Long> tempMap = inputData.get(match.group("venue"));
                    if (!tempMap.containsKey(match.group("singer"))){
                        tempMap.put(match.group("singer"),Long.parseLong(match.group("ticketsCount")) * Long.parseLong(match.group("ticketsPrice")));
                    } else {
                        long singerMoney = tempMap.get(match.group("singer"));
                        tempMap.put(match.group("singer"),singerMoney + (Long.parseLong(match.group("ticketsCount")) * Long.parseLong(match.group("ticketsPrice"))));
                    }

                    inputData.put(match.group("venue"),tempMap);

                }
            }
            input = sc.nextLine();
        }

        for (String s : inputData.keySet()) {
            System.out.printf("%s\n",s);
            LinkedHashMap<String,Long> temp = new LinkedHashMap<>(sortByValue(inputData.get(s)));
            for (Map.Entry entry : temp.entrySet()) {
                System.out.printf("#  %s -> %d\n",entry.getKey(),entry.getValue());
            }
        }
    }
    static Map sortByValue(Map map)  { //Descending! Exchange objects to ascending
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator(){
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        Map result = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry)it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
