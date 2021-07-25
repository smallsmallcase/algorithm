package com.sss;

/**
 * package: com.sss
 * date: 2019/3/24 21:07
 *
 * @author smallcase
 * @since JDK 1.8
 */
import java.util.*;
public class tangguo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String[] na = sc.nextLine().trim().split(" ");
        int[] narray = new int[na.length];
        for(int i = 0;i<na.length;i++) narray[i] = Integer.parseInt(na[i]);

        int m = Integer.parseInt(sc.nextLine().trim());
        String[] ma = sc.nextLine().trim().split(" ");
        int[] marray = new int[ma.length];
        for(int i = 0;i<ma.length;i++) marray[i] = Integer.parseInt(ma[i]);

        Arrays.sort(marray);
        Arrays.sort(narray);

        int i=n-1,j=m-1,count = 0;
        while(i>=0&&j>=0){
            if(marray[j]>=narray[i]){
                i--;
                j--;
                count++;
            }else{
                i--;
            }
        }
        System.out.println(count);
    }
}
