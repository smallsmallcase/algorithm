package com.real;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Package com.real
 * @Date 2019/9/20
 * @Auther smallcase
 */
public class zhanli {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {
            return;
        }
        int n = Integer.parseInt(sc.nextLine());
        int num = 0;

        String line = "";
        while (n-- > 0) {
            num = Integer.parseInt(sc.nextLine());
            line = sc.nextLine();
            solution(num, line);
        }
        sc.close();


    }

    private static void solution(int num,String line){
        LinkedList<Integer> list = new LinkedList<>();
        String[] array = line.split(" ");
        for (String str : array) {
            list.add(Integer.parseInt(str));
        }

        int left = 0;
        int right = 0;
        Collections.sort(list);
        int size = list.size();
        if (num % 2 == 0) {
            while (size >= 4) {
                left += list.pollFirst() + list.pollLast();
                right += list.pollFirst() + list.pollLast();
                size = size - 4;
            }
            size = list.size();
            if (size == 2) {
                int a = list.pollFirst();
                int b = list.pollLast();
                if (left > right) {
                    left += a;
                    right += b;
                } else {
                    left += b;
                    right += a;
                }
            }

            System.out.println(Math.min(left, right) + " " + Math.max(left, right));

        } else {
            while (size >= 5) {
                left += list.pollFirst() + list.pollLast();
                right += list.pollFirst() + list.pollLast();
                size = size - 4;
            }
            size = list.size();
            if (size == 3) {

                if (left < right) {
                    left += list.pollFirst() + list.pollFirst();
                    right += list.pollLast();
                } else {
                    right += list.pollFirst() + list.pollFirst();
                    left += list.pollLast();
                }
            } else if (size == 1) {
                if (left < right) {
                    left += list.poll();
                } else {
                    right += list.poll();
                }
            }

            System.out.println(Math.min(left, right) + " " + Math.max(left, right));
        }



    }
}
