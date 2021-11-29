package com.huj.Interface.thread;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author xuanwo
 * @date 2021/8/21
 * @description:
 */
public class FutureTest {
    public static void main(String[] args) {

        Callable<String> callableJob = new Callable<String>() {
            public String call() throws Exception {
                return "任务结束";
            }
        };
        FutureTask<String> task = new FutureTask<String>(callableJob);

        new Thread(task).start();

        FutureTest futureTest = new FutureTest();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        futureTest.merge(nums1, 3, nums2, 3);

        System.out.println(1);


    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        int a = m-1;
        int b = n-1;
        for(int i=index;i>=0;i--){
            if(a<0){
                System.arraycopy(nums2,0,nums1,0,b+1);
                break;
            }else if(b<0){
                break;
            }
            if(nums1[a]<nums2[b]){
                nums1[index] = nums2[b--];
            }else{
                nums1[index] = nums1[a--];
            }
        }
    }
}
