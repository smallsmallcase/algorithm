package com.huj.CH7;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.huj.CH7
 * date: 2019/3/31 21:31
 * 最大堆
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class MyHeap<T extends Comparable<T>> {

    private int size;
    private T[] heap;


    public MyHeap(int N) {
        this.heap = (T[]) new Comparable[N + 1];
        this.size = 0;
    }

    public void insert(T v) {
        //从下标为1的位置开始插入
        heap[++size] = v;
        //int index = size;
        swim(size);
    }

    public T deleteMax() {
        swap(1, size);
        T tmp = heap[size];
        heap[size] = null;
        size--;
        //最顶端下沉到合适的位置
        sink(1);
        return tmp;
    }

    private void sink(int i) {
        while (i <= size >>> 1 && heap[i].compareTo(heap[i << 1]) < 0) {
            swap(i, i << 1);
            i = i << 1;
            if (i + 1 <= size && heap[i].compareTo(heap[i + 1]) < 0) {
                swap(i, i++);
            }
        }
    }


    private void swim(int index) {
        while (index > 1 && heap[index].compareTo(heap[index >>> 1]) > 0) {
            swap(index, index >>> 1);
            index = index >>> 1;
        }
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String ss = new String("11");
        list.add(ss);
        ss = new String("14");
        list.add(ss);
        System.out.println(list);
    }
}
