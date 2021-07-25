package com.real;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @package: com.real
 * @date: 2019/4/8 19:33
 * @author: smallcase
 * @description
 */
public class lianbiao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().trim().split(",");
        Set<String> set = new HashSet<>();
        boolean flag = false;
        for (String str : array) {
            if (set.contains(str)) {
                flag = true;
                break;
            } else {
                set.add(str);
            }
        }

        System.out.println(flag);

    }
}
