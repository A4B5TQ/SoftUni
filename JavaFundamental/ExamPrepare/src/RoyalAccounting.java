import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoyalAccounting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern pat = Pattern.compile("^(?<employeeName>[a-zA-Z]+);(?<workingHour>-?\\d+);(?<payment>-?\\d+\\.?\\d*);(?<team>[a-zA-Z]+)$");

        String str = sc.nextLine();

        TreeMap<String,Long> teamEmployeeWorkingHour = new TreeMap<>();
        HashMap<String,TreeMap<String,Double>> teamEmployeeDailyPayment = new HashMap<>();

        while (!"Pishi kuf i da si hodim".equals(str)){
            Matcher match = pat.matcher(str);
            while (match.find()){
                Long workH = Long.parseLong(match.group("workingHour"));
                if (!teamEmployeeWorkingHour.containsKey(match.group("employeeName"))){
                    teamEmployeeWorkingHour.put(match.group("employeeName"),workH);
                    if (!teamEmployeeDailyPayment.containsKey(match.group("team"))){
                        teamEmployeeDailyPayment.put(match.group("team"), new TreeMap<>());
                    }
                } else {
                    break;
                }
                Double dayPay = Double.parseDouble(match.group("payment"));
                dayPay = (dayPay * workH) / 24.0;
                TreeMap<String,Double> tmpEDP = teamEmployeeDailyPayment.get(match.group("team"));
                tmpEDP.put(match.group("employeeName"),dayPay);
                teamEmployeeDailyPayment.put(match.group("team"),tmpEDP);
            }
            str = sc.nextLine();
        }

        teamEmployeeDailyPayment.entrySet().stream().sorted((e1,e2) -> {
            Double e1Money = 0.0 ;
            Double e2Money = 0.0 ;

            for (Double num : e1.getValue().values()) {
                e1Money += num * 30.0;
            }
            for (Double num : e2.getValue().values()) {
                e2Money += num * 30.0;
            }
            return e2Money.compareTo(e1Money);
        }).forEach(pair -> {
            System.out.println("Team - " + pair.getKey());
            pair.getValue().keySet().stream().sorted((e1,e2) -> {
                if (Long.compare(teamEmployeeWorkingHour.get(e2),teamEmployeeWorkingHour.get(e1)) == 0L){
                    Double b2 = pair.getValue().get(e2);
                    Double b1 = pair.getValue().get(e1);
                    return Double.compare(b2,b1);
                }
                return Long.compare(teamEmployeeWorkingHour.get(e2),teamEmployeeWorkingHour.get(e1));
            }).forEach(e -> {
                System.out.printf("$$$%s - %d - %f\n",e,teamEmployeeWorkingHour.get(e),pair.getValue().get(e));
            });
        });
    }
}