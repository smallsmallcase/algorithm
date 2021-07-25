package com.huj.CH7;

/**
 * package: com.huj.CH7
 * date: 2018/11/30 22:15
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class Merge {


    public void MergeSort(int[] array) {
        int[] temp = new int[array.length];//先建好一个长度等于原数组长度的数组，避免递归过程中频繁开辟空间
        sort(array, 0, array.length - 1, temp);
    }

    /**
     * 排序，递归
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    private void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp); //拆分出左序列，左边归并排序，使左子序有序
            sort(arr, mid + 1, right, temp);//拆分出右序列，右边归并排序，使右子序有序
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 归并，将两个有序序列合并成一个有序序列
     * @param arr，原始数组
     * @param left，左序列第一个位置
     * @param mid，右序列第一个位置
     * @param right，右序列最后一个位置
     * @param temp，临时数组
     */
    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0; //临时数组的指针，每一次从0开始

        /*
        两边都有剩余，一次比较，较小者放入temp中
         */
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        /*
        左边有剩余，依次复制到temp中
         */
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        /*
        右边有剩余，依次复制temp中
         */
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        /*
        最后一步，将temp复制到原数组中
         */
        t = 0; //temp的t指针置0
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
