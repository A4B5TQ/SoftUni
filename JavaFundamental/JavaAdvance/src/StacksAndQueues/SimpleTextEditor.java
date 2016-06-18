package stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<String> datas = new Stack<>();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    String input = sc.nextLine().trim();
                    if (!datas.isEmpty()) {
                        datas.push(datas.peek() + input);
                    } else {
                        datas.push(input);
                    }
                    break;
                case 2:
                    int count = sc.nextInt();
                    input = datas.peek().substring(0, datas.peek().length() - count);
                    datas.push(input);
                    break;
                case 3:
                    int index = sc.nextInt();
                    input = datas.peek();
                    System.out.println(input.charAt(index - 1));
                    break;
                case 4:
                    datas.pop();
                    break;
            }
        }
    }
}
