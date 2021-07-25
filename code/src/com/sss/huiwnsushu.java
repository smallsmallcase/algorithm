package com.sss;

import java.util.Scanner;

/**
 * package: com.sss
 * date: 2019/3/27 11:01
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class huiwnsushu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int count = 0;
        for (int i=l;i<=r;i++){
            if (isPrime(i)&&isPalindrome(i)) count++;
        }
        System.out.println(count);

    }


    /**
     * 判断是不是素数
     * @param n
     * @return
     */
    private static boolean isPrime(int n){
        if (n==1) return false;
        int i = (int)Math.sqrt(n);
        while (i>1){
            if (n%i==0) return false;
            i--;
        }
        return true;
    }


    /**
     * 判断是不是回文数字
     * @param n
     * @return
     */
    private static boolean isPalindrome(int n){
        int m = 0;
        while (m<n){
            m = m * 10 + n % 10;
            n /= 10;
        }
        return m == n || m / 10 == n;
    }
}
