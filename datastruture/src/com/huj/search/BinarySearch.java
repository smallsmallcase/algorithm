package com.huj.search;

/**
 * package: com.huj.search
 * date: 2019/3/26 16:17
 *时间复杂度O(logN)
 * @author smallcase
 * @since JDK 1.8
 */
public class BinarySearch {


    public int binarySearchIter(int key,int[] a){

        int left = 0, right = a.length;
        int mid;
        while (left < right) {

            mid = left + (right - left) / 2;

            if (a[mid]>=key) {
                //只能取到最左边的值
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }


    /**
     * 递归版本的实现
     * @param key
     * @param array
     * @param left
     * @param right
     * @return
     */
    public int binarySearchI(int key,int[] array,int left,int right){
        if (left>right){
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] > key) {
            right = mid - 1;
            return binarySearchI(key, array, left, right);
        } else if (array[mid] < key) {
            left = mid + 1;
            return binarySearchI(key, array, left, right);
        } else {
            return mid;
        }
    }

    /**
     * 二分查找，不是边界值，不确定性
     * 普通二分查找
     *
     * @param key
     * @param a
     * @return
     */
    public int standBinarySearch(int key, int[] a) {
        int left = 0, right = a.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (key < a[mid]) {
                right = mid - 1;
            } else if (key > a[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 改进的二分查找，插值查找，非递归版本，不是边界值，不确定性
     * @param key
     * @param a
     * @return
     */
    public int insertBinarySearch(int key,int[] a){
        int left = 0, right = a.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) * ((key - a[left]) / a[right] - a[left]);
            if(key<a[mid]) {
                right = mid-1;
            } else if(key>a[mid]) {
                left = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
