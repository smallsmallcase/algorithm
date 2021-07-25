package com.sss;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * package: com.sss
 * date: 2019/3/24 21:23
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String[] array = sc.nextLine().trim().split(" ");

        Deque<String> deque = new LinkedList<>();
        boolean needReverse = false;
        for (String s : array) {
            if(needReverse) deque.addLast(s);
            else deque.addFirst(s);
            needReverse = !needReverse;
        }

        StringBuilder sb = new StringBuilder();
        while (n-->0){
            sb.append(deque.pollLast());
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());

    }
}
