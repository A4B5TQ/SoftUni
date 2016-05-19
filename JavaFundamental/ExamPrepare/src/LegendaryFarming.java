import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LegendaryFarming {
    private static LinkedHashMap<String, Integer> mainItems = new LinkedHashMap<>();
    private static TreeMap<String, Integer> junk = new TreeMap<>();
    private static boolean isValanyrObtained = false;
    private static boolean isDragonwrathObtained = false;
    private static boolean isShadowmourneObtained = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mainItems.put("fragments", 0);
        mainItems.put("motes", 0);
        mainItems.put("shards", 0);
        String winItem = "";
        String line = sc.nextLine();

        while (!line.equals("")) {
            Pattern pat = Pattern.compile("\\b([0-9]+\\s[^0-9\\s]+)\\b", Pattern.CASE_INSENSITIVE);
            Matcher match = pat.matcher(line);
            while (match.find()) {
                if (isValanyrObtained||isShadowmourneObtained||isDragonwrathObtained)break;
                String[] currMatch = match.group().split("\\s+");
                int currCount = Integer.parseInt(currMatch[0]);
                String currMaterial = currMatch[1].toLowerCase();
                collect(currMaterial, currCount);
                for (Map.Entry<String, Integer> items : mainItems.entrySet()) {
                    if (items.getValue() >= 250) {
                        if (items.getKey().equals("fragments")) {
                            isValanyrObtained = true;
                            winItem = "fragments";
                            mainItems.put(winItem, items.getValue() - 250);
                            break;
                        } else if (items.getKey().equals("shards")) {
                            isShadowmourneObtained = true;
                            winItem = "shards";
                            mainItems.put(winItem, items.getValue() - 250);
                            break;
                        } else if (items.getKey().equals("motes")) {
                            isDragonwrathObtained = true;
                            winItem = "motes";
                            mainItems.put(winItem, items.getValue() - 250);
                            break;
                        }
                    }
                }
            }
            if (isValanyrObtained||isShadowmourneObtained||isDragonwrathObtained)break;
            line = sc.nextLine();
        }

        print(isDragonwrathObtained,isShadowmourneObtained,isValanyrObtained,mainItems);
    }

    private static void print(boolean isDragonwrathObtained, boolean isShadowmourneObtained, boolean isValanyrObtained, HashMap<String, Integer> items) {
        LinkedHashMap<String,Integer> sortedItems = new LinkedHashMap<>(sortByValue(items));
        if (isDragonwrathObtained){
            System.out.println("Dragonwrath obtained!");
        } else if (isShadowmourneObtained){
            System.out.println("Shadowmourne obtained!");
        } else if (isValanyrObtained){
            System.out.println("Valanyr obtained!");
        }
        sortedItems.entrySet().stream().forEach(e -> System.out.printf("%s: %d\n",e.getKey(),e.getValue()));
        junk.entrySet().stream().forEach(e -> System.out.printf("%s: %d\n",e.getKey(),e.getValue()));
    }

    private static void collect(String material, int count) {
        if (mainItems.containsKey(material)) {
            int temp = mainItems.get(material);
            mainItems.put(material, count + temp);
        } else {
            if (!junk.containsKey(material)) {
                junk.put(material, count);
            } else {
                int temp = junk.get(material);
                junk.put(material, count + temp);
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

        Map result = new LinkedHashMap<>();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry)it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
