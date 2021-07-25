package com.huj.tanxing;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * package: com.huj.tanxing
 * date: 2019/2/25 18:44
 *提前最优，贪心算法
 * @author smallcase
 * @since JDK 1.8
 */
public class Tanxin {

    /**
     * 剪绳子
     * @param n
     * @return
     */
    public static int greedy_cut_rope(int n){
        if (n==2) return 1;
        if (n==3) return 2;

        int numOf3 = n / 3;
        if (n%3==1) numOf3--;
        int numOf2 = (n - 3 * numOf3) / 2;
        return (int) (Math.pow(3, numOf3) * Math.pow(2, numOf2));
    }

    /**
     * 剪绳子 递归法
     * @param n
     * @return
     */
    public static int greedy_cut_rope2(int n){
        int a =1;
        int b = 2;
        System.out.println(a ^ b);
        if (n==2) return 2;
        if (n==3) return 3;
        if (n==4) return 4;
        return 3 * greedy_cut_rope2(n - 3);
    }


    /**
     * 给定N个物品和一个容量为C的背包,物品i的重量为Wi，其价值为Vi，
     * 背包问题是如何选择装入背包的物品，使得装入背包中物品的总价值最大。
     * 注意在背包问题中，可以将某种物品的一部分装入背包中，但是不可以重复装入。
     * @param w w[i] 第i个物品的质量
     * @param v v[i] 降序的第i件物品的单位价值
     * @param n 物品个数
     * @param c 背包容量
     * @return
     */
    public static double bag(int[] w,int[] v,int n,int c){


//        double[] cal = new double[n];
        double maxValue = 0;
        int i;
        for (i = 0; w[i] < c && i < n - 1; i++) {
            maxValue += v[i] * w[i];
            c -= w[i];
//            cal[i] = 1;
        }

//        cal[i] = (double) c / w[i];//物品i存放的比重
        maxValue += c * w[i];
        return maxValue;
    }
}
