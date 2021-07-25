package com.real;

import java.util.Scanner;

/**
 * @Package com.real
 * @Date 2019/9/21
 * @Auther smallcase
 */


public class num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int num = 0;
        while (n-- > 0) {
            num = Integer.parseInt(sc.nextLine());
            parse(num);
        }
        sc.close();
    }

    private static void parse(int n){
        if (n<=9){
            System.out.println(n);
            return;

        }
        int count = 1;
        while (count * 9 < n) {
            count++;
        }
        int dis = n - (--count) * 9;
        StringBuilder sb = new StringBuilder();
        sb.append(dis);
        while (count-- > 0) {
            sb.append(9);
        }
        System.out.println(sb.toString());

    }
}
