package com.real;

import java.util.List;
import java.util.Scanner;

/**
 * @Package com.real
 * @Date 2019/9/8
 * @Auther smallcase
 */
public class fangkuai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l = sc.nextLine();
        String[] s = l.split(" ");
        int n = Integer.parseInt(s[0]);
        long m = Long.parseLong(s[1]);
        int q = Integer.parseInt(s[2]);

        String str = sc.nextLine();
        while (q-- > 0) {
            solution(str, n, sc.nextLine());
        }


    }

    private static void solution(String str, int n, String range) {
        String[] array = str.split(" ");
        String[] ran = range.split(" ");
        int begin = Integer.parseInt(ran[0]) - 1;
        int end = Integer.parseInt(ran[1]) - 1;
        boolean right = true;//方向向左
        boolean symbol = false;

        long score = 0L;
        int cur = begin;
        while (cur >= begin && cur <= end) {
            if ("<".equals(array[cur]) || ">".equals(array[cur])) {
                if (symbol) {
                    array[cur] = "0";
                } else if ("<".equals(array[cur])) {
                    right = false;
                    symbol = true;
                } else {
                    right = true;
                    symbol = true;
                }
            } else {
                long s = Long.parseLong(array[cur]);
                if (s == 0) {
                    break;
                }
                symbol = false;
                score += s;
                array[cur] = Long.toString(s - 1);
            }

            if (right) {
                cur++;
            } else {
                cur--;
            }

        }

        System.out.println(score);

    }
}
