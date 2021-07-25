package com.sss;
import java.util.Scanner;

/**
 * package: com.sss
 * date: 2019/3/27 19:31
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class bianma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine().trim();
        String[] dp = new String[n];

        boolean needReverse;
        int start=0,begin;
        String temp;
        for (int i = 0;i<n;i++){
            if(str.substring(start,start+1).equals("0")) needReverse = true;
            else needReverse = false;
            start++;
            begin = start;
            while (start<=str.length()-1&&!str.substring(start,start+1).equals("0")&&!str.substring(start,start+1).equals("1")){
                start++;
            }
            temp = str.substring(begin, start);
            if (needReverse) temp = reverse(temp);
            dp[i] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for(String v:dp){
            sb.append(v).append(" ");
        }
        System.out.println(sb.toString().trim());

    }

    private static String reverse(String str){
        char[] array = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=array.length-1;i>=0;i--){
            sb.append(array[i]);
        }
        return sb.toString();
    }
}
