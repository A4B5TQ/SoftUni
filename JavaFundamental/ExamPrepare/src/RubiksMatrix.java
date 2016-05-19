import java.util.Arrays;
import java.util.Scanner;

public class RubiksMatrix {
    private static int row;
    private static int col;
    private static int[][] rubik;

    public static void main(String[] args) { // 100/100
        Scanner sc = new Scanner(System.in);

        Integer[] dim = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        row = dim[0];
        col = dim[1];
        rubik = new int[row][col];
        int counter = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rubik[i][j] = counter;
                counter++;

            }
        }
        int commandsCount = Integer.parseInt(sc.nextLine());

        while (commandsCount > 0) {
            String[] input = sc.nextLine().split("\\s+");
            int targetRowOrCol = Integer.parseInt(input[0]);
            int moves = Integer.parseInt(input[2]);

            switch (input[1]) {
                case "up":
                    int times = (row + moves) % row;
                    while (times > 0) {
                        int tmpValue = rubik[0][targetRowOrCol];
                        for (int i = 0; i < row - 1; i++) {
                            rubik[i][targetRowOrCol] = rubik[i + 1][targetRowOrCol];
                        }
                        rubik[row - 1][targetRowOrCol] = tmpValue;
                        times--;
                    }
                    break;
                case "down":
                    times = (row + moves) % row;
                    while (times > 0) {
                        int tmpValue = rubik[row - 1][targetRowOrCol];
                        for (int i = row - 1; i > 0; i--) {
                            rubik[i][targetRowOrCol] = rubik[i - 1][targetRowOrCol];
                        }
                        rubik[0][targetRowOrCol] = tmpValue;
                        times--;
                    }
                    break;
                case "left":
                    times = (col + moves) % col;
                    while (times > 0) {
                        int tmpValue = rubik[targetRowOrCol][0];
                        for (int i = 0; i < col - 1; i++) {
                            rubik[targetRowOrCol][i] = rubik[targetRowOrCol][i + 1];
                        }
                        rubik[targetRowOrCol][col - 1] = tmpValue;
                        times--;
                    }
                    break;
                case "right":
                    times = (col + moves) % col;
                    while (times > 0) {
                        int tmpValue = rubik[targetRowOrCol][col - 1];
                        for (int i = col - 1; i > 0; i--) {
                            rubik[targetRowOrCol][i] = rubik[targetRowOrCol][i - 1];
                        }
                        rubik[targetRowOrCol][0] = tmpValue;
                        times--;
                    }
                    break;
            }
            /*printMatrix();
            System.out.println();*/
            commandsCount--;
        }
        counter = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rubik[i][j] == counter) {
                    System.out.println("No swap required");
                    counter++;
                } else {
                    int[] index = getIndex(counter);
                    System.out.printf("Swap (%d, %d) with (%d, %d)\n", i, j, index[0], index[1]);
                    rubik[index[0]][index[1]] = rubik[i][j];
                    rubik[i][j] = counter;
                    counter++;
                }
            }
        }
    }

    private static int[] getIndex(int num) {
        int[] index = new int[2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rubik[i][j] == num) {
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        return index;
    }

    public static void printMatrix() {
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(rubik[i]));
        }
    }
}
