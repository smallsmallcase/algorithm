package com.sss;

/**
 * package: com.sss
 * date: 2019/3/26 9:27
 *
 * @author smallcase
 * @since JDK 1.8
 */
import java.util.*;
public class crazylist{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=1){
            System.out.println(0);
            return;
        }
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        boolean flag = true;
        int minValue=0,maxValue=0;
        while(i<n/2){
            minValue = array[i];
            maxValue = array[n-1-i];
            i++;
            if(flag){
                deque.addFirst(minValue);
                deque.addLast(maxValue);
            }else{
                deque.addFirst(maxValue);
                deque.addLast(minValue);
            }
            flag = !flag;
        }
        int res=0;
        int lastV=deque.poll();
        int temp;
        while(deque.peek()!=null){
            temp = deque.poll();
            res+=Math.abs(lastV-temp);
            lastV = temp;
        }
        if(n%2!=0){
            res+=Math.max(Math.abs(array[i]-minValue),Math.abs(array[i]-maxValue));
        }
        System.out.println(res);

    }
}