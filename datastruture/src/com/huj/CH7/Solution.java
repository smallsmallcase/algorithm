package com.huj.CH7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * package: com.huj.CH7
 * date: 2018/12/5 20:04
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        //如果长度是0，算了，早点滚吧
        if(numbers.length==0||length==0){
            return false;
        }

        for(int i=0;i<length;i++){

            if(numbers[i]!=i){//当位置i处的值不等于i,将该值放在numbers[i]处
                swap(numbers,numbers[i],i);
            }
        }

        for(int i=0;i<length;i++){
            if(numbers[i]!=i){
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;
    }

    /*
    交换位置i和j的值
    */
    private void swap(int[] numbers,int i,int j){
        int temp = numbers[i];
        numbers[i]= numbers[j];
        numbers[j]= temp;

    }


    public static void main(String[] args) {
        char s = 'f';
        int[] a = new int[256];
        a[s] = 1;
        int i = 10;
        char c = '1';
        int v = i + c;
        int vv = c - '0';
        int v2 = i + (c - '0');

        Solution solution = new Solution();
        int[] array = {1, 4, 3, 4, 0, 5};
        String[] abb = new String[3];
        abb[0] = "1";
        abb[1] = "2";
        abb[2] = "3";
        Arrays.sort(abb);

        Arrays.sort(abb, ((o1, o2) -> (o1 + o2).compareTo(o2 + o1)));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Collections.sort(list, ((o1, o2) -> o2 - o1));
        int[] t = new int[1];
        boolean duplicate = solution.duplicate(array, array.length, t);
        System.out.println(duplicate);

        System.out.println(Arrays.toString(t));

    }
}
