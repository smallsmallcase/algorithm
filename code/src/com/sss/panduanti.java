package com.sss;

/**
 * package: com.sss
 * date: 2019/3/22 18:04
 *
 * @author smallcase
 * @since JDK 1.8
 */
import java.util.*;
public class panduanti{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int a = sc.nextInt();
        System.out.println(n-Math.abs(t-a));
    }
}
