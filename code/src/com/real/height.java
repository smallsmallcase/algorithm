package com.real;


import java.util.*;
/**
 * @Package com.real
 * @Date 2019/9/7
 * @Auther smallcase
 */
public class height {
    private static List<Long> list = new ArrayList<>();
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        //num组测试数据
        int num = sc.nextInt();
        int height = 0;
        list.add(1L);
        int size = 0;
        while(num-->0){
            size = list.size();
            height = sc.nextInt();
            if(height<=size-1){
                System.out.println(list.get(height-1));
            }else{
                //需要添加高度
                addHeight(list,height,size);
            }
        }
        sc.close();
    }


    private static void addHeight(List<Long> list,int height,int size){
        int dis = height-size;
        long value = 0;
        while(dis-->=0){
            value = addOne(list, size++);
            list.add(value);
        }

        System.out.println(value);

    }


    private static long addOne(List<Long> list,int size){
        double n = 0;
        long result = 0;
        int index = size-(int)Math.pow(2,n);
        while(index>=0){
            result+=list.get(index);
            n++;
            index = size - (int) Math.pow(2, n);
        }
        return result % (long) (Math.pow(10, 9) + 3);
    }
}
