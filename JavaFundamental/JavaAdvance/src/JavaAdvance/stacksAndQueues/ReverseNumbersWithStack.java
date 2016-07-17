package javaAdvance.stacksAndQueues;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();

        Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).forEach(st::push);

        String out = "";

        int size = st.size();
        for (int i = 0; i < size; i++) {
            out += st.pop() + " ";
        }

        System.out.println(out.trim());
    }
}
