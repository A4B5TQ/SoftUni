package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int push = sc.nextInt();
        int pop = sc.nextInt();
        int check = sc.nextInt();

        Queue<Integer> que = new ArrayDeque<>();
        int minElement = Integer.MAX_VALUE;

        while (push > 0){
            int a = sc.nextInt();
            if (a < minElement)
                minElement = a;
            que.add(a);
            push--;
        }

        while (pop > 0){
            que.poll();
            pop--;
        }

        if (que.size() == 0){
            System.out.println(0);
        } else if(que.contains(check)){
            System.out.println(true);
        } else {
            System.out.println(minElement);
        }
    }
}
