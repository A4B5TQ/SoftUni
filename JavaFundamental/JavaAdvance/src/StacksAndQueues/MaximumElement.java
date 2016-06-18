package stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Stack<Integer> que = new Stack<>();
        Stack<Integer> maxElements = new Stack<>();
        maxElements.add(Integer.MIN_VALUE);

        while (n > 0) {
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    int element = sc.nextInt();
                    if (element > maxElements.peek())
                        maxElements.add(element);
                    que.add(element);
                    break;
                case 2:
                    int out = que.pop();
                    if (out == maxElements.peek()) {
                        maxElements.pop();
                    }
                    break;
                case 3:
                    System.out.println(maxElements.peek());
                    break;
            }
            n--;
        }
    }
}
