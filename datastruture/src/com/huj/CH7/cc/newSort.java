package com.huj.CH7.cc;

import java.util.Arrays;

/**
 * @Package com.huj.CH7.cc
 * @Date 2019/9/20
 * @Auther smallcase
 */
public class newSort<T extends Comparable<? super T>> {

    private void insertSort(T[] array){
        System.out.println(Arrays.toString(array));
        int i;
        for (int p = 1; p < array.length; p++) {
            T tmp = array[p];
            for (i = p; i > 0 && array[i - 1].compareTo(tmp) > 0; i--) {
                array[i] = array[i - 1];
            }
            array[i] = tmp;

        }
    }

}
