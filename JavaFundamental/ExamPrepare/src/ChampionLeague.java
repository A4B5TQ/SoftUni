import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ChampionLeague {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String,Integer> teamWins = new TreeMap<>();
        TreeMap<String,List<String>> teamOpponents = new TreeMap<>();

        Pattern pat = Pattern.compile("(?<team1>[A-Za-z ]+) \\| (?<team2>[A-Za-z\\s]+) \\| (?<team1Goals>\\d+):(?<team2AwaiGoal>\\d+) \\| (?<team2Goals>\\d+):(?<team1AwaiGoal>\\d+)");

        String inpputLines = sc.nextLine();

        while (!inpputLines.contains("stop")){
            Matcher match = pat.matcher(inpputLines);
            while (match.find()){
                if (!teamOpponents.containsKey(match.group("team1"))){
                    teamOpponents.put(match.group("team1"),new ArrayList<>());

                }
                if (!teamOpponents.containsKey(match.group("team2"))){
                    teamOpponents.put(match.group("team2"),new ArrayList<>());
                }
                if (!teamWins.containsKey(match.group("team1")))
                    teamWins.put(match.group("team1"),0);
                if (!teamWins.containsKey(match.group("team2")))
                    teamWins.put(match.group("team2"),0);

                teamOpponents.get(match.group("team1")).add(match.group("team2"));
                teamOpponents.get(match.group("team2")).add(match.group("team1"));

                int team1SumGoals = Integer.parseInt(match.group("team1Goals")) +
                        Integer.parseInt(match.group("team1AwaiGoal"));
                int team2SumGoals = Integer.parseInt(match.group("team2Goals")) +
                        Integer.parseInt(match.group("team2AwaiGoal"));

                if (team1SumGoals > team2SumGoals){
                    int num = teamWins.get(match.group("team1"));
                    teamWins.put(match.group("team1"),num + 1);
                } else if (team1SumGoals < team2SumGoals) {
                    int num = teamWins.get(match.group("team2"));
                    teamWins.put(match.group("team2"),num + 1);
                } else {
                    int team1AwaiGoals = Integer.parseInt(match.group("team1AwaiGoal"));
                    int team2AwaiGoals = Integer.parseInt(match.group("team2AwaiGoal"));
                    if (team1AwaiGoals>team2AwaiGoals){
                        int num = teamWins.get(match.group("team1"));
                        teamWins.put(match.group("team1"),num + 1);
                    } else {
                        int num = teamWins.get(match.group("team2"));
                        teamWins.put(match.group("team2"),num + 1);
                    }
                }
            }
            inpputLines = sc.nextLine();
        }
        teamWins.entrySet().stream().sorted((e1,e2) -> Integer.compare(e2.getValue(),e1.getValue()))
                .forEach(e -> {
            System.out.println(e.getKey());
            System.out.println("- Wins: " + e.getValue());
            if (teamOpponents.containsKey(e.getKey()))
            System.out.printf("- Opponents: %s\n",String.join(", ",teamOpponents.get(e.getKey())
                    .stream().sorted(String::compareTo).collect(Collectors.toList())));
        });
    }
}
