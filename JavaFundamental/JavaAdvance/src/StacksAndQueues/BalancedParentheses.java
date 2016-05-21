package StacksAndQueues;

import java.util.*;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> brace = new Stack<>();

        boolean isBalanced = true;
        for (char c : sc.nextLine().toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                brace.push(c);
            } else if(!brace.isEmpty()){
                StringBuilder sb = new StringBuilder(brace.pop() + "" + c);
                if (!sb.toString().equals("{}") && !sb.toString().equals("[]") && !sb.toString().equals("()")) {
                    isBalanced = false;
                    break;
                }
            } else {
                isBalanced = false;
                break;
            }
        }

        if (isBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
