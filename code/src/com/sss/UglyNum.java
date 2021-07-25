package com.sss;

/**
 * package: com.sss
 * date: 2019/3/22 17:02
 *
 * @author smallcase
 * @since JDK 1.8
 */
import java.util.*;
public class UglyNum{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] dp = new int[n];
        dp[0] = 1;
        int i2=0,i3=0,i5=0;
        int next2=0,next3=0,next5=0;
        for(int i=1;i<n;i++){
            next2 = dp[i2]*2;
            next3 = dp[i3]*3;
            next5 = dp[i5]*5;
            dp[i] = Math.min(next2,Math.min(next3,next5));
            if(next2==dp[i]) i2++;
            if(next3==dp[i]) i3++;
            if(next5==dp[i]) i5++;
        }
        System.out.println(dp[n-1]);
    }
}
