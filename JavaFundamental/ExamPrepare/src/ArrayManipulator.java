import java.util.*;
import java.util.stream.Collectors;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> arr = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String inputs = sc.nextLine();

        while (!inputs.equals("end")) {
            String[] commands = inputs.split("\\s+");
            switch (commands[0]) {
                case "exchange":
                    int currIndex = Integer.parseInt(commands[1]);
                    if (currIndex >= 0 && currIndex < arr.size()) {
                        exchange(currIndex, arr);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    String maxOddOrEven = commands[1];
                    boolean isFindMax = false;
                    int index = arr.size() - 1;
                    int maxElement = Integer.MIN_VALUE;
                    for (int i = index; i >= 0; i--) {
                        if (maxOddOrEven.equals("odd")) {
                            if (arr.get(i) % 2 != 0 && arr.get(i) > maxElement) {
                                maxElement = arr.get(i);
                                isFindMax = true;
                            }
                        } else {
                            if (arr.get(i) % 2 == 0 && arr.get(i) > maxElement) {
                                maxElement = arr.get(i);
                                isFindMax = true;
                            }
                        }
                    }
                    if (isFindMax) {
                        System.out.println(arr.lastIndexOf(maxElement));
                    } else {
                        System.out.println("No matches");
                    }
                    break;
                case "min":
                    String minOddOrEven = commands[1];
                    boolean isFindMin = false;
                    int minElement = Integer.MAX_VALUE;
                    for (int i = 0; i < arr.size(); i++) {
                        if (minOddOrEven.equals("odd")) {
                            if (arr.get(i) % 2 != 0 && arr.get(i) < minElement) {
                                minElement = arr.get(i);
                                isFindMin = true;
                            }
                        } else {
                            if (arr.get(i) % 2 == 0 && arr.get(i) < minElement) {
                                minElement = arr.get(i);
                                isFindMin = true;
                                break;
                            }
                        }
                    }
                    if (isFindMin) {
                        System.out.println(arr.lastIndexOf(minElement));
                    } else {
                        System.out.println("No matches");
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(commands[1]);
                    String firstOddOrEven = commands[2];
                    if (count <= arr.size()) {
                        List<Integer> tmpList = getResult(arr, firstOddOrEven);
                        System.out.println(tmpList.subList(0, count < tmpList.size() ? count : tmpList.size()));
                    } else {
                        System.out.println("Invalid count");
                    }
                    break;
                case "last":
                    int counter = Integer.parseInt(commands[1]);
                    String lastOddOrEven = commands[2];
                    if (counter <= arr.size()) {
                        List<Integer> tmpList = getResult(arr, lastOddOrEven);
                        System.out.println(tmpList.subList(tmpList.size() - counter < 0 ? 0 : tmpList.size() - counter, tmpList.size()));
                    } else {
                        System.out.println("Invalid count");
                    }
                    break;
            }

            inputs = sc.nextLine();
        }
        System.out.println(arr);
    }

    private static List<Integer> getResult(List<Integer> arr, String firstOddOrEven) {
        List<Integer> result = new ArrayList<>();
        if (firstOddOrEven.equals("odd")) {
            for (Integer num : arr) {
                if (num % 2 != 0) {
                    result.add(num);
                }
            }
        } else {
            for (Integer num : arr) {
                if (num % 2 == 0) {
                    result.add(num);
                }
            }
        }
        return result;
    }

    private static void exchange(int index, List<Integer> ls) {
        List<Integer> tmp = new ArrayList<>();
        //int ind = 0;
        for (int i = 0; i <= index; i++) {
            tmp.add(ls.get(0));
            int remove = ls.get(0);
            ls.remove((Object)remove);
        }
        ls.addAll(tmp);
    }
}
/*
    int index = 0;
for (int k = j; k < matrix.get(i).size(); k++) {
        if (matrix.get(i).get(k) != 0) {
        index = k;
        break;
        }
        matrix.get(i).set(j, matrix.get(i).get(index));
        matrix.get(i).set(index, 0);
        }*/
