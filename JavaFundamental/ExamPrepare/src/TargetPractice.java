import java.util.*;

public class TargetPractice { //100/100
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dim = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(dim[0]);
        int colums = Integer.parseInt(dim[1]);

        String fillText = sc.nextLine();
        StringBuilder filler = new StringBuilder();

        for (int i = 0; i < rows * colums; i++) {
            filler.append(fillText);
        }
        List<List<Character>> matrix = new ArrayList<>();
        int countFrom = 0;
        int countTo = colums;

        for (int i = 1; i <= rows; i++) {
            List<Character> currLine = new ArrayList<>();
            for (int j = countFrom; j < countTo; j++) {
                currLine.add(filler.toString().charAt(j));
            }

            if (i % 2 != 0) {
                Collections.reverse(currLine);
                matrix.add(currLine);
            } else {
                matrix.add(currLine);
            }
            countFrom += colums;
            countTo += colums;
        }
        Collections.reverse(matrix);

        String[] target = sc.nextLine().split("\\s+");
        int targetRow = Integer.parseInt(target[0]);
        int targetColumn= Integer.parseInt(target[1]);
        int targetRadius = Integer.parseInt(target[2]);

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if ((Math.pow((i - targetRow),2) + Math.pow((j - targetColumn),2))<= Math.pow(targetRadius,2)){
                    matrix.get(i).set(j,' ');
                }
            }
        }

        for (int i = rows - 1; i > 0; i--) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) == ' '){
                    for (int k = i; k >= 0; k--) {
                        if (matrix.get(k).get(j) != ' '){
                            matrix.get(i).set(j,matrix.get(k).get(j));
                            matrix.get(k).set(j,' ');
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                System.out.print(matrix.get(i).get(j));
            }
            System.out.println();
        }
    }
}
