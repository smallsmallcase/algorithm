package com.huj.ch1;

/**
 * package: com.huj.ch1
 * date: 2018/10/2 15:26
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class MaxSubSum {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7, -1, -3, -9, 32, 333,5657,-65,-7575,233};
        int[] b = {1, 2, 3, 4, 5, 6, -1, -1, -1, 23, 23};
        int i = maxSubSum4(b);
        System.out.println(i);
    }


    /**
     * 最大子序列求和
     * @param a
     * @return
     */
    private static int maxSubSum1(int[] a) {

        long startTime = System.currentTimeMillis();

        int maxSubSum = 0;
        for (int i = 0; i < a.length; i++) {


            for (int j = i; j < a.length; j++) {

                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += a[k];
                }
                if (maxSubSum < thisSum) {
                    maxSubSum = thisSum;
                }
            }
        }

        System.out.println(System.currentTimeMillis() - startTime);

        return maxSubSum;
    }


    private static int maxSubSum2(int[] a) {
        long startTime = System.currentTimeMillis();

        int maxSubSum = 0;
        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;

            for (int j = i; j < a.length; j++) {
                thisSum += a[j];

                if (thisSum > maxSubSum) {
                    maxSubSum = thisSum;
                }
            }
        }

        System.out.println(System.currentTimeMillis() - startTime);
        return maxSubSum;
    }

    private static int maxSubSum4(int[] a){
        int maxSum = 0, thisSum = 0;

        for (int j = 0; j < a.length; j++) {
            thisSum += a[j];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }

        return maxSum;
    }

}
