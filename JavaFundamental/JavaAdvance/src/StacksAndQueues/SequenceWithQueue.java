package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SequenceWithQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Long> que = new ArrayDeque<>();
        que.add(sc.nextLong());
        int count = 0;
        while (count < 50){
            que.add(que.peek() + 1);
            que.add(2 * que.peek() + 1);
            que.add(que.peek() + 2);
            count++;
            System.out.printf("%d ",que.poll());
        }
    }
}
