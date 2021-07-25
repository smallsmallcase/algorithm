package com.huj;

import java.nio.ByteBuffer;
import java.util.*;

/**
 * package: com.huj
 * date: 2018/9/26 10:14
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class array {
    public static void main(String[] args) {
        int[] a = {1, 2, 4};

//        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
        String str1 = "abc";
        "sdsf".intern();
        String str2 = new String("def");
        String str3 = "abc";
        String str4 = str2.intern();
        String str5 = "def";
        String str6 = new String("def");
        System.out.println(str1 == str3);//true
        System.out.println(str2 == str4);//false
        System.out.println(str4 == str5);//true
        System.out.println(str2 == str6);//false

        String ssss = new StringBuilder("计算机").append("技术").toString();
        System.out.println(ssss.intern() == ssss);//true



        String sss = new StringBuilder("ja").append("va").toString();

        System.out.println(sss.intern() == sss);//false

//        String ddd = "java";
//        String sss = new String("java");
//        String bb = sss.intern();
//        System.out.println(ddd == sss);//false
//        System.out.println(ddd == bb);//true
//        System.out.println(sss == bb);//false
    }
}
