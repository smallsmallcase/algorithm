package com.real;

import java.util.Scanner;

/**
 * @Package com.real
 * @Date 2019/9/1
 * @Auther smallcase
 */
public class ludeng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while (count-- > 0) {
            int cnt = sc.nextInt();
            String str = sc.next();
            solution(cnt, str);

        }

        sc.close();
    }


    private static void solution(int cnt, String str) {

        int count = 0;
        for (int i = 0; i < cnt; i++) {
            if ('.' == str.charAt(i)) {
                count++;
                i = i + 2;
            }
        }
        System.out.println(count);

    }

}



