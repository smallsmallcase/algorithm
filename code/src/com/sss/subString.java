package com.sss;

/**
 * package: com.sss
 * date: 2019/3/22 17:45
 *
 * @author smallcase
 * @since JDK 1.8
 */
import java.util.*;
public class subString{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        int count=1,maxCount=1;
        String last;
        String current = str.substring(0,1);
        for(int i=1;i<str.length();i++){
            last = current;
            current = str.substring(i,i+1);
            if(!last.equals(current)){
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else{
                count = 1;
            }
        }
        System.out.println(maxCount);
    }
}
