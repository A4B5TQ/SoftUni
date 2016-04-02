import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectResources {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] res = sc.nextLine().split("\\s+");
        int N = Integer.parseInt(sc.nextLine());
        long maxCollectedRes = 0;

        for (int i = 0; i < N; i++) {
            long currenCollected = 0;
            String[] input = sc.nextLine().split("\\s+");
            int currentPoss = Integer.parseInt(input[0]);
            int step = Integer.parseInt(input[1]);
            int nextPoss = currentPoss;
            Set<Integer> poss = new HashSet<>();
            while (!poss.contains(nextPoss)) {
                poss.add(nextPoss);
                String currentRes = res[nextPoss];
                Pattern pat = Pattern.compile("\\d+");
                Matcher match = pat.matcher(currentRes);
                if (currentRes.contains("wood") || currentRes.contains("stone") || currentRes.contains("gold") || currentRes.contains("food")) {
                   if (match.find()){
                       currenCollected+=Long.parseLong(match.group());
                   }else{
                       currenCollected++;
                   }
                }
                nextPoss = (step + nextPoss) % res.length;
            }
            if (currenCollected > maxCollectedRes){
                maxCollectedRes = currenCollected;
            }
        }
        System.out.println(maxCollectedRes);
    }
}
