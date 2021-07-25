package com.huj.ch3;

import java.util.HashMap;

/**
 * package: com.huj.ch3
 * date: 2018/11/23 14:26
 *用数组实现简单列表
 * @author smallcase
 * @since JDK 1.8
 */
public class ListWithArray {


    private static int CAPACITY = 40; //队列默认容量为40
    private int capacity;
    private int front=0;
    private int back=0;
    private int currentSize=0;
    private Object [] theArray;

    public ListWithArray(int capacity) {
        this.capacity = capacity;
        this.theArray = new Object[capacity];
    }

    public ListWithArray() {
        this(CAPACITY);
    }


    public void enqueue(Object v) {
        currentSize++;
        this.theArray[back++] = v;

    }


    public Object dequeue() {
        currentSize--;
        return theArray[front++];
    }

    public int getSize() {
        return currentSize;
    }


    public static void main(String[] args) {
        ListWithArray arrayList = new ListWithArray();

        System.out.println("开始入队");
        arrayList.enqueue(1L);
        System.out.println(arrayList.getSize());

        arrayList.enqueue(2L);
        System.out.println(arrayList.getSize());

        arrayList.enqueue(3L);
        System.out.println(arrayList.getSize());

        System.out.println("开始出对");
        System.out.println("出来的数字是：" + arrayList.dequeue());
        System.out.println("现在的大小为：" + arrayList.getSize());

        System.out.println("出来的数字是：" + arrayList.dequeue());
        System.out.println("现在的大小为：" + arrayList.getSize());

    }
}
