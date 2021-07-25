package com.sss;

/**
 * package: com.sss
 * date: 2019/3/27 15:28
 *
 * @author smallcase
 * @since JDK 1.8
 */
import java.util.*;
public class DNA{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] array = sc.nextLine().trim().toCharArray();
        int[] dp = new int[4];
        Arrays.fill(dp,0);
        int a=0,c=0,g=0,t=0;
        char pre = '0';
        for(char ca: array){

            if(ca=='A'){
                if(pre!=ca){
                    a = 1;
                }else a++;
                dp[0] = Math.max(a,dp[0]);
            }else if(ca=='C'){
                if(pre!=ca){
                    c = 1;
                }else c++;
                dp[1] = Math.max(c,dp[1]);
            }else if(ca=='G'){
                if(pre!=ca){
                    g=1;
                }else g++;
                dp[2] = Math.max(g,dp[2]);
            }else{
                if(pre!=ca){
                    t = 1;
                }else t++;
                dp[3] = Math.max(t,dp[3]);
            }
            pre = ca;

        }
        Arrays.sort(dp);
        System.out.println(dp[0]+1);
    }
}
