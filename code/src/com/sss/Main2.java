package com.sss;

/**
 * package: com.sss
 * date: 2019/3/22 13:43
 *
 * @author smallcase
 * @since JDK 1.8
 */
import java.util.*;
public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int k1 = sc.nextInt();
        int x2 = sc.nextInt();
        int k2 = sc.nextInt();

        int n1 = Integer.valueOf(x1).toString().length();
        int n2 = Integer.valueOf(x2).toString().length();

        long res1=0L;
        long res2 = 0L;
        while(k1-- >0){
            res1 = res1*(long)Math.pow(10,n1)+x1;
        }
        while(k2-- >0){
            res2 = res2*(long)Math.pow(10,n2)+x2;
        }
        if(res1==res2) System.out.println("Equal");
        else if(res1<res2) System.out.println("Less");
        else System.out.println("Greater");
    }
}
