package com.real;

import java.util.Scanner;

/**
 * @package: com.real
 * @date: 2019/4/5 20:46
 * @author: smallcase
 * @description
 */
public class guaishou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] str = sc.nextLine().split(" ");
        long[] power = new long[n];
        for(int i = 0;i<n;i++){
            power[i] = Long.valueOf(str[i]);
        }

        String[] str2 = sc.nextLine().split(" ");
        int[] money = new int[n];
        for(int i = 0;i<n;i++){
            money[i] = Integer.valueOf(str2[i]);
        }
        sc.close();

        int index = 0, tail = n - 1;
        long totalPower = power[0];
        while (index <= tail) {
            if(totalPower<power[tail]){
                index++;
                totalPower += power[index];
            }else {
                tail--;
            }
        }

        long totalMoney = 0;
        for(int i = 0;i<=index;i++){
            totalMoney+=(long)money[i];
        }

        System.out.println(totalMoney);


    }
}
