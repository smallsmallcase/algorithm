package com.real;

import java.util.Scanner;

/**
 * @Package com.real
 * @Date 2019/9/22
 * @Auther smallcase
 */
public class jimu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (matchSinceHere(n, i, chars)) {
                i = i + n - 1;
            } else {
                sb.append(chars[i]);
            }

        }
        System.out.println(sb.toString());
    }

    private static boolean matchSinceHere(int n,int index, char[] array) {
        int count = 0;
        for (int i = index; i < array.length; i++) {
            if (array[i] == '0') {
                count++;
            }else {
                return false;
            }
            if (count == n) {
                if (i == array.length - 1) {
                    return true;
                }
                if (array[i + 1] != '0') {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
