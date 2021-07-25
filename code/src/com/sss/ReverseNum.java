package com.sss;

/**
 * package: com.sss
 * date: 2019/3/24 12:26
 *
 * @author smallcase
 * @since JDK 1.8
 */
import java.util.*;
public class ReverseNum{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        boolean negative  = value < 0;
        char[] array  =Integer.toString(value).toCharArray();
        int i=0;
        int result = 0;
        if(negative) i++;
        int count = 0;
        for(;i<array.length;i++){
            result +=Math.pow(10,count++)*(array[i]-'0');
        }
        if(negative) result = -result;
        System.out.println(result);

    }
}
