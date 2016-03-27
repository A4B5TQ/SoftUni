import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Integer> userAndDuration = new TreeMap<>();
        TreeMap<String, TreeSet<String>> userAndIps = new TreeMap<>();

        int count = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < count; i++) {
            String[] inputs = sc.nextLine().split("\\s+");
            getUserAndDuration(userAndDuration, inputs);
            getUserAndIPs(userAndIps, inputs);
        }

        for (Map.Entry entry : userAndDuration.entrySet()) {
            System.out.printf("%s: %d %s\n",entry.getKey(),entry.getValue(),userAndIps.get(entry.getKey()));
        }
    }

    private static void getUserAndIPs(TreeMap<String, TreeSet<String>> userAndIps, String[] inputs) {
        if (!userAndIps.containsKey(inputs[1])){
            TreeSet<String> tempSet = new TreeSet<>();
            tempSet.add(inputs[0]);
            userAndIps.put(inputs[1],tempSet);
        } else {
            TreeSet<String> tempSet = userAndIps.get(inputs[1]);
            tempSet.add(inputs[0]);
            userAndIps.put(inputs[1],tempSet);
        }
    }

    private static void getUserAndDuration(TreeMap<String, Integer> userAndDuration, String[] inputs) {
        if (!userAndDuration.containsKey(inputs[1])){
            userAndDuration.put(inputs[1],Integer.parseInt(inputs[2]));
        } else {
            int temp = userAndDuration.get(inputs[1]) + Integer.parseInt(inputs[2]);
            userAndDuration.put(inputs[1],temp);
        }
    }
}
