package com.huj.CH7;

/**
 * package: com.huj.CH7
 * date: 2019/2/24 15:38
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class FastSort {
    private int[] array;
    public FastSort(int[] array){
        this.array = array;
    }

    public void QuickSort(int left, int right) {
        if (left>=right) {
            return;
        }
        int index = PartSort(left, right);
        QuickSort(left, index - 1);
        QuickSort(index + 1, right);
        //数组中第index小的数字确定，包括位置
    }

    //左右指针法
    private int PartSort(int left, int right) {
        int mid = right;
        while (left < right) {
            while (array[left] <= array[mid] && left < right) {
                left++;
            }
            while (left<right&&array[right]>=array[mid]) {
                right--;
            }
            swap(left, right);
        }
        swap(mid,left);//因为上面先是left++,之后就会有left==right
        return left;
    }



    private void swap(int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
