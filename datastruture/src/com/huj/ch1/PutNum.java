package com.huj.ch1;

/**
 * package: com.huj.ch1
 * date: 2018/10/1 21:31
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class PutNum {
    public static void main(String[] args) {
        int v = 12345;
        printOut(v);
    }

    private static void printOut(int n) {
        if (n >= 10)
            printOut(n/10);
        System.out.print(n % 10);
    }

}
