package com.real;

import java.util.*;

/**
 * @Package com.real
 * @Date 2019/9/20
 * @Auther smallcase
 */
public class tuoyan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] line;
        int num;
        int time;
        int min = Integer.MAX_VALUE;
        LinkedList<Integer> deque = new LinkedList<>();

        while (n-->0){
            line = sc.nextLine().split(" ");
            num = Integer.parseInt(line[0]);
            time = Integer.parseInt(line[1]);
            while (num-->0){
                deque.add(time);
            }
        }
        sc.close();

        int M = deque.size();
        Collections.sort(deque);

        while (M > 0) {
            min = Math.min(min, (deque.pollFirst() + deque.pollLast()));
            M = M - 2;
        }
        System.out.println(min);

    }
}
