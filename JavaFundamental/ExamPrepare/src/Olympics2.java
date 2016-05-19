import java.util.*;

public class Olympics2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Set<String>> olympiansData = new HashMap<>();
        Map<String, Integer> countryWins = new LinkedHashMap<>();
        String line;
        while (!"report".equals((line = sc.nextLine()))) {
            String[] olympianCountry = line.replaceAll("\\s+", " ").split("\\|");
            String name = olympianCountry[0].trim();
            String country = olympianCountry[1].trim();
            if (!olympiansData.containsKey(country)) {
                olympiansData.put(country, new HashSet<>());
                countryWins.put(country, 0);
            }
            olympiansData.get(country).add(name);
            countryWins.put(country, countryWins.get(country) + 1);
        }
        countryWins.entrySet()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue(), t1.getValue()))
                .forEach(country -> System.out.printf("%s (%d participants): %d wins%n"
                        , country.getKey(), olympiansData.get(country.getKey()).size(), country.getValue()));
    }
}
