import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComparatorsByPesho {
    public static void main(String[] args) {
        HashMap<String, String> testMap = new HashMap<>();

        //Compare by integer value
        Comparator<Map.Entry<String, Integer>> cmp = Comparator.comparing(Map.Entry::getValue);
        //Compare by String key
        Comparator<Map.Entry<String, Integer>> cmp2 = Comparator.comparing(Map.Entry::getKey);

        testMap.put("Pesho1", "123");
        testMap.put("Ivan1", "123569");
        testMap.put("Ivan2", "12");
        testMap.put("Pesho2", "1");
        //testMap.entrySet().stream().sorted((cmp.thenComparing(cmp2))).forEach(System.out::println);
        testMap.entrySet().stream().sorted((d,f) -> {
            return 1;
        }).forEach(System.out::println);
        List<Integer> tst = Arrays.stream("1 2 3 4 5".split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Map.Entry> tm = testMap.entrySet().stream().collect(Collectors.toList());
        Collections.sort(tm, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        Person prs = new Person();
        prs.setNAME("Ivan");
        prs.setAGE(20);
        Person prs2 = new Person();
        prs2.setNAME("Ivan");
        prs2.setAGE(25);
        Person prs3 = new Person();
        prs3.setNAME("MamataSiDjas");
        prs3.setAGE(30);

        List<Person> prsList = new ArrayList<Person>() {{
            add(prs);
            add(prs2);
            add(prs3);
        }};
        Collections.sort(prsList, new Comparator() {
            public int compare(Object o1, Object o2) {
                Person p = (Person) o1;
                Person p2 = (Person) o2;
                return p2.compareTo(p);
            }
        });
        Person f = prsList.stream().sorted(
                Comparator.comparing(Person::getNAME, Comparator.reverseOrder()).
                        thenComparing(Person::getAGE, Comparator.reverseOrder()))
                .filter(a -> a.getAGE() < 30)

                .max(Comparator.comparing(person -> person.getAGE())).get();
        System.out.println(f);
        System.out.println(prsList);
        testMap.entrySet().stream().sorted((e1, e2) -> {
            return e2.getValue().compareTo(e1.getValue());
        }).forEach(System.out::println);
        //System.out.println(testMap);
        System.out.println(tm);
        int a = tst.stream().reduce((c, b) -> c + b).get();
        List<Integer> tst1 = Arrays.asList(1, 2, 3);

        List<Integer> tst2 = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};

        HashMap<String, Integer> testsdsd = new HashMap<String, Integer>() {{
            put("Test", 123);
            put("Test2", 123);
        }};

        System.out.println(a);
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }
}
