package com.huj.CH7;

import java.util.Arrays;

/**
 * package: com.huj.CH7
 * date: 2018/10/25 21:12
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class Sort<T extends Comparable<? super T>> {


    /**
     * 插入排序
     * @param array
     */
    private void insertSort(T[] array) {

        System.out.println(array.length);
        for (int p = 1; p < array.length; p++) {
            T tmp = array[p];
            int j;
            for (j = p; j > 0 && tmp.compareTo(array[j - 1]) < 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = tmp;
        }
    }

    /**
     * 希尔排序（可并行化）
     * @param array
     */
    private void shellSort(T[] array) {
        System.out.println(array.length);

        for (int gap = array.length >> 2; gap > 0; gap = gap >> 2) {

            for (int i = gap; i < array.length; i++) {

                int j;
                T tmp = array[i];
                for (j = i; j >= gap && tmp.compareTo(array[j - gap]) < 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = tmp;
            }
        }


    }


    /**
     * 选择排序中的直接排序
     * 思路：在未排序的序列中找到最小值，放在该序列的起始位置，
     * （将起始位置的值和最小值位置互换）再在剩下的序列中重复
     * 时间复杂度   最好和最坏都是N^2，个人感觉比冒泡排序差，不稳定
     * @param array
     */
    private void selectSort(T[] array) {
        System.out.println("数量为：" + array.length);
        int minary;        //定义最小下标
        T temp; //定义临时变量

        for (int i = 0; i < array.length - 1; i++) {
            minary = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minary]) < 0) {
                    minary = j;
                }
            }
            if (minary != i) {
                temp = array[i];
                array[i] = array[minary];
                array[minary] = temp;
            }
        }
    }


    /**
     * 堆排序（选择排序的一种），构造堆O(N),删除最大元素N*logN，总体是N*logN
     * @param array
     */
    private void heapSort(int[] array){
        MyHeap<Integer> heap = new MyHeap<>(10);
        //构造堆
        for (Integer value : array) {
            heap.insert(value);
        }



        //删除最大元素
        while (!heap.isEmpty()) {
            System.out.println(heap.deleteMax());
        }

    }


    /**
     * 最原始的冒泡牌序（冒泡排序是交换排序的一种）
     * @param array
     */
    private void BubbleSort(T[] array) {
        System.out.println("数量为：" + array.length);
        for (int i = 0; i < array.length-1; i++) {    /*
                                                    外层循环控制排序的次数，每一次循环结束都能
                                                    确定该循环中最大的数放在array.length-1-i的位置
                                                    */
            for (int j = 0; j < array.length - 1 - i; j++) { //内层循环控制每一次排序多少次
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 改进后的冒泡排序
     * @param array
     */
    private void ExtendedBubbleSort(T[] array) {
        System.out.println("数量为：" + array.length);
        boolean isOk; //true表示不需要进一步的排序
        for (int i = 0; i < array.length-1; i++) {
            isOk = true;

            for (int j = 0; j < array.length - 1 - i; j++) { //内层循环控制每一次排序多少次
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isOk = false;
                }

            }
            if (isOk) {
                break; //true表示不需要进一步排序
            }
        }
    }


    /**
     * 奇偶排序（可并行化）
     * @param array
     */
//    private void core(int[] array) {
//        int arrayLength = array.length;
//        boolean oddSorted = false;
//        boolean evenSorted = false;
//
//        while(!oddSorted || !evenSorted) {
//            int base = 0;
//            oddSorted = true;
//            evenSorted = true;
//
//            for (int i = base; i < arrayLength - 1; i += 2) {
//                if (array[i] > array[i + 1]) {
//                    ArrayUtils.swap(array, i, i + 1);
//                    oddSorted = false;
//                }
//            }
//
//            base = 1;
//            for (int i = base; i < arrayLength - 1; i += 2) {
//                if (array[i] > array[i + 1]) {
//                    ArrayUtils.swap(array, i, i + 1);
//                    evenSorted = false;
//                }
//            }
//        }
//    }


    /**
     * 归并排序
     * @param array
     */
    private void MergeSort(int[] array) {
        Merge merge = new Merge();
        merge.MergeSort(array);
    }



    public static void main(String[] args) {


        String s1 = new String("777");
        String s2 = "aaa777";
        System.out.println(s2 == s2.intern());
        String s4 = "aaa" + s1;
        System.out.println(s2 == s4);

        s4 = s4.intern();
        System.out.println(s2 == s4);

        char[] aa = {'a','b'};
        char[] bb = {'a','b'};
        System.out.println("数组比较"+aa.equals(bb));

        String s3 = new String("1") + new String("1");
//        String s = s3.intern();
        String s5 = "11";
        System.out.println(s3 == s5);
        Sort<Integer> sort = new Sort<>();


        int[] array = new int[5];
        array[0] = 55;
        array[1] = 24;
        array[2] = 3;
        array[3] = 12;
        array[4] = 1;
//        insertSort.insertSort(array);

        sort.heapSort(array);
//        sort.MergeSort(array);//归并排序

        System.out.println(Arrays.toString(array));

    }
}













