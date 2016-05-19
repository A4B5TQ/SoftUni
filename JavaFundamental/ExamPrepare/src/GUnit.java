import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUnit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, TreeMap<String, TreeSet<String>>> classesMethodAndTest = new TreeMap<>();

        Pattern pat = Pattern.compile("^(?<class>[A-Z][A-Za-z0-9]{1,}){1,}\\s\\|\\s(?<method>[A-Z][A-Za-z0-9]{1,}){1,}\\s\\|\\s(?<unit>[A-Z][A-Za-z0-9]{1,}){1,}$");

        String input = sc.nextLine();

        while (!input.equals("It's testing time!")) {
            Matcher match = pat.matcher(input);
            while (match.find()) {
                if (!classesMethodAndTest.containsKey(match.group("class"))) {
                    TreeMap<String, TreeSet<String>> tmpMap = new TreeMap<>();
                    TreeSet<String> tmpSet = new TreeSet<>();
                    tmpSet.add(match.group("unit"));
                    tmpMap.put(match.group("method"), tmpSet);
                    classesMethodAndTest.put(match.group("class"), tmpMap);
                } else {
                    TreeMap<String, TreeSet<String>> tmpMap = new TreeMap<>(classesMethodAndTest.get(match.group("class")));
                    TreeSet<String> tmpSet = new TreeSet<>();
                    if (!tmpMap.containsKey(match.group("method"))) {
                        tmpSet.add(match.group("unit"));
                        tmpMap.put(match.group("method"), tmpSet);
                    } else {
                        tmpSet = new TreeSet<>(tmpMap.get(match.group("method")));
                        tmpSet.add(match.group("unit"));
                        tmpMap.put(match.group("method"), tmpSet);
                    }
                    classesMethodAndTest.put(match.group("class"), tmpMap);
                }
            }
            input = sc.nextLine();
        }
/*        methodAndTest.entrySet().stream().sorted((e1, e2) -> {
            /// sorting the outer map by most inner values
            int amountOfTest1 = e1.getValue().values().stream().collect(Collectors.summingInt(value -> value.size()));
            int amountOfTest2 = e2.getValue().values().stream().collect(Collectors.summingInt(value -> value.size()));

            if (amountOfTest1 == amountOfTest2) {
                // sorting by methods // inner map keys //
                int innerMapKeys1 = e1.getValue().size();
                int innerMapKeys2 = e2.getValue().size();

                return Integer.compare(innerMapKeys1, innerMapKeys2);

            } else {
                //sorting by count of tests // inner values //
                return Integer.compare(amountOfTest2, amountOfTest1);// Count of test
            }
        }).forEach(classesAndMethods -> {
            System.out.println(classesAndMethods.getKey() + ":");

            // sorting methods by count of the tests
            classesAndMethods.getValue().entrySet().stream().sorted((a1, a2) -> {
                int testCount1 = a1.getValue().size();
                int testCount2 = a2.getValue().size();
                return Integer.compare(testCount2, testCount1);
            }).forEach(methodAndTests -> {
                System.out.printf("##%s\n", methodAndTests.getKey());
                //sorting the test by there length
                methodAndTests.getValue().stream().sorted((a, b2) -> Integer.compare(a.length(), b2.length())).forEach(tests -> {
                    System.out.printf("####%s\n", tests);
                });
            });
        });*/

        classesMethodAndTest.entrySet().stream().sorted((e1, e2) -> {
            /// sorting the outer map by most inner values

            int amountOfTest1 = 0;
            int amountOfTest2 = 0;

            for (TreeSet<String> tests : e1.getValue().values()) {
                amountOfTest1 += tests.size();
            }

            for (TreeSet<String> tests : e2.getValue().values()) {
                amountOfTest2 += tests.size();
            }

            int result = Integer.compare(amountOfTest2,amountOfTest1);
            if (result == 0) {
                // sorting by methods // inner map keys //
                int innerMapKeys1 = e1.getValue().size();
                int innerMapKeys2 = e2.getValue().size();

                result = Integer.compare(innerMapKeys1, innerMapKeys2);

            }
            return result;
        }).forEach(classesAndMethods -> {
            System.out.println(classesAndMethods.getKey() + ":");

            // sorting methods by count of the tests
            classesAndMethods.getValue().entrySet().stream().sorted((a1, a2) -> {
                int testCount1 = a1.getValue().size();
                int testCount2 = a2.getValue().size();
                return Integer.compare(testCount2, testCount1);
            }).forEach(methodAndTests -> {
                System.out.printf("##%s\n", methodAndTests.getKey());
                //sorting the test by there length
                methodAndTests.getValue().stream().sorted((a, b2) -> Integer.compare(a.length(), b2.length())).forEach(tests -> {
                    System.out.printf("####%s\n", tests);
                });
            });
        });
    }
}
