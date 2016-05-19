import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CriticalBreakpoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<List<Long>> coordinates = new ArrayList<>();

        String input = sc.nextLine();
        boolean isCriticalExist = true;

        BigInteger criticalRatio = new BigInteger("0");

        while (!input.equals("Break it.")){
            coordinates.add(Arrays.stream(input.split("\\s+"))
                    .map(Long::parseLong)
                    .collect(Collectors.toList()));
            input = sc.nextLine();
        }

        for (List<Long> coorPair: coordinates) {

            BigInteger currCalc = new BigInteger("" +
                    ((coorPair.get(3) + coorPair.get(2))
                            - (coorPair.get(0) + coorPair.get(1))))
                    .abs();

            if (!currCalc.equals(BigInteger.ZERO) &&
                    !currCalc.equals(criticalRatio) &&
                    criticalRatio.equals(BigInteger.ZERO)){

                criticalRatio = new BigInteger(currCalc.toString());
            }
            if (!currCalc.equals(BigInteger.ZERO) &&
                    !currCalc.equals(criticalRatio) &&
                    !criticalRatio.equals(BigInteger.ZERO)){

                System.out.println("Critical breakpoint does not exist.");

                isCriticalExist = false;
                break;
            }
        }

        if (isCriticalExist){
            BigInteger result = new BigInteger(String.valueOf(
                    new BigInteger(criticalRatio.pow(coordinates.size()) + "")
                            .remainder(new BigInteger(coordinates.size() + ""))));

            for (List<Long> coordinate : coordinates) {
                System.out.print("Line: ");
                System.out.println(coordinate);
            }
            System.out.println("Critical Breakpoint: " + result.toString());
        }
    }
}
