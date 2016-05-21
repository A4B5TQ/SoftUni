package StacksAndQueues;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int popCount = sc.nextInt();
        int checkNum = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<>();

        Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stack::push);

        if (stack.isEmpty()){
            System.out.println(0);
        } else {
            for (int i = 0; i < popCount; i++) {
                stack.pop();
            }

            if (stack.contains(checkNum)){
                System.out.println(true);
            } else {
                Integer min = Integer.MAX_VALUE;

                int size = stack.size();

                for (int i = 0; i < size; i++) {
                    if (min > stack.peek()){
                        min = stack.pop();
                    }else {
                        stack.pop();
                    }
                }

                if (min == Integer.MAX_VALUE){
                    System.out.println(0);
                    return;
                }
                System.out.println(min);
            }
        }
    }
}
