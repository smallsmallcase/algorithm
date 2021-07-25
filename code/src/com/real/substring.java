package com.real;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Package com.real
 * @Date 2019/9/8
 * @Auther smallcase
 */
public class substring {
    public static void main(String[] args){
        String dddd = dddd("19:39:91");
        System.out.println(111);

        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        long[] array = new long[m];
        int n =0;

        String str;

        while(n<m){
            str = sc.nextLine();
            array[n] = Long.parseLong(str.substring(str.length() - 6));
            n++;
        }
        sc.close();

        Arrays.sort(array);
        for(long num:array){
            System.out.println(num);
        }
    }


    private static String dddd(String time){
        String sub = time.substring(3,5);
        String sub2 = time.substring(6,8);
        if(Integer.parseInt(sub)>59){
            char[] array = time.toCharArray();
            array[3] = '0';
            if(Integer.parseInt(sub2)>59){
                array[6] = '0';
            }
            return String.valueOf(array);
        }

        return time;
    }
}
