package com.real;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @package: com.real
 * @date: 2019/4/7 20:19
 * @author: smallcase
 * @description
 */
public class fruit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> buy = new HashMap<>();
        Map<Integer, Integer> sell = new HashMap<>();

        int v =0;
        for(int i = 0;i<n;i++){
            v = sc.nextInt();
            if(v>0) buy.put(i,v);
            else sell.put(i,v);
        }
        sc.close();

        int result = 0;
        int currentNeed = 0;
        int currentlocaltion = 0;
        for (Map.Entry<Integer, Integer> entry : buy.entrySet()) {
            currentNeed = entry.getValue();
            currentlocaltion = entry.getKey();
            while (currentNeed>0){
                int nearstseller = foundthenearstSeller(sell, currentlocaltion);
                Integer largestsellNum = - sell.get(nearstseller);
                if (currentNeed>=largestsellNum){
                    result += largestsellNum * Math.abs(currentlocaltion - nearstseller);
                    currentNeed -= largestsellNum;
                    buy.put(currentlocaltion, currentNeed);
                    sell.remove(nearstseller);
                }else {
                    result += currentNeed * Math.abs(currentlocaltion - nearstseller);
                    sell.put(nearstseller, currentNeed - largestsellNum);
                    currentNeed = 0;
                }
            }

        }
        System.out.println(result);

    }

    private static int foundthenearstSeller(Map<Integer,Integer> sellers,int currentLocaltion){
        Set<Integer> integers = sellers.keySet();
        int result = -1;
        int abs = Integer.MAX_VALUE;

        for(Integer i:integers){
            if(Math.abs(i-currentLocaltion)<abs){
                result = i;
                abs = Math.abs(i - currentLocaltion);
            }
        }
        return result;
    }
}
