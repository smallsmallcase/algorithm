package com.real;

import java.util.Scanner;

/**
 * @Package com.real
 * @Date 2019/9/20
 * @Auther smallcase
 */
public class wangguo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());//测试用例个数
        int length=0;
        String line = "";
        while (n-->0){
            length = Integer.parseInt(sc.nextLine());
            line = sc.nextLine();
            solution(length, line);
        }
        sc.close();

    }

    private static void solution(int length,String line){
        if (length<11){
            System.out.println("NO");
            return;
        }

        for (int i = 0; i <= length - 11; i++) {
            if (line.charAt(i)=='8'){
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
