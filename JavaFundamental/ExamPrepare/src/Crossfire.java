import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire { //100/100
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dim = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(dim[0]);
        int colums = Integer.parseInt(dim[1]);

        List<List<Integer>> matrix = new ArrayList<>();
        int counter = 1;
        for (int i = 0; i < rows; i++) {
            List<Integer> currLine = new ArrayList<>();
            for (int j = 0; j < colums; j++) {
                currLine.add(counter);
                counter++;
            }
            matrix.add(currLine);
        }
        String command = sc.nextLine();

        while (!command.equals("Nuke it from orbit")){
            String[] target = command.split("\\s+");
            int targetRow = Integer.parseInt(target[0]);
            int targetColumn= Integer.parseInt(target[1]);
            int targetRadius = Integer.parseInt(target[2]);

            for (int i = targetColumn - targetRadius; i <= targetColumn + targetRadius; i++) {
                if (targetRow >= 0 && targetRow < matrix.size() && i < matrix.get(targetRow).size() && i >= 0) {
                    matrix.get(targetRow).set(i,0);
                }
            }

            for (int i = targetRow - targetRadius; i <= targetRow + targetRadius; i++) {
                if (i >= 0 && i < matrix.size() && targetColumn >= 0 && targetColumn < matrix.get(i).size()) {
                    matrix.get(i).set(targetColumn,0);
                }
            }

            for (int i = 0; i < matrix.size(); i++) {
                if (matrix.get(i).stream().mapToInt(Integer::valueOf).sum() == 0) {
                    matrix.remove(i);
                    i--;
                } else {
                    for (int j = 0; j < matrix.get(i).size(); j++) {
                        if (matrix.get(i).get(j) == 0) {
                            int index = 0;
                            boolean toSwap = false;
                            for (int k = j; k < matrix.get(i).size(); k++) {
                                if (matrix.get(i).get(k) != 0){
                                    index = k;
                                    toSwap = true;
                                    break;
                                }
                            }
                            if (toSwap){

                                matrix.get(i).set(j, matrix.get(i).get(index));
                                matrix.get(i).set(index, 0);
                            }
                        }
                    }
                }

            }
            command = sc.nextLine();
        }

        for (int i = 0; i < matrix.size(); i++) {
            String row = "";
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j)!=0){
                    row += matrix.get(i).get(j) + " ";
                }
            }
            row = row.trim();
            System.out.println(row);
        }
    }
}