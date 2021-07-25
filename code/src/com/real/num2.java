package com.real;

import java.util.*;

/**
 * @Package com.real
 * @Date 2019/9/21
 * @Auther smallcase
 */
public class num2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int count = 0;
        String line = "";
        while (n-- > 0) {
            count = Integer.parseInt(sc.nextLine());
            line = sc.nextLine();
            solution(count, line);
        }
        sc.close();

    }

    private static void solution(int count, String line) {
        String[] str = line.split(" ");
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(str[i]);
        }

        int sum = 0;
        int finalCount = 0;
        int thisCount = 0;
        for (int i = 0; i < count - 1; i++) {
            for (int j = i; j < count - 1; j++) {
                if (sum > array[j + 1]) {
                    break;
                }
                sum += array[j];
                thisCount++;
            }

            finalCount = Math.max(finalCount, thisCount);
        }
        System.out.println(finalCount);
    }
}
