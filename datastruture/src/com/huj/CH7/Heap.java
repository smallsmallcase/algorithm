package com.huj.CH7;

/**
 * package: com.huj.CH7
 * date: 2018/10/29 19:43
 *构建出一个最大堆，max heap
 * @author smallcase
 * @since JDK 1.8
 */
public class Heap<T extends Comparable<T>> {

    private T[] heap;
    private int N = 0;

    /**
     * 构造出大小为maxN的堆
     * @param maxN
     */
    public Heap(int maxN) {
        this.heap = (T[]) new Comparable[maxN + 1];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }


    /**
     * result is true while heap[i]<heap[j]
     * @param i
     * @param j
     * @return
     */
    public boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    /**
     * 交换
     * @param i
     * @param j
     */
    private void swap(int i, int j) {

        T tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }


    /**
     * 上浮
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k >> 1, k)) {
            swap(k >> 1, k);
            k = k >> 1;
        }
    }


    /**
     * 下沉
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            /*与子节点中的最大的那个进行交换，使满足父节点大于子节点*/
            if (j < N && less(j, j + 1)) {

                j = j + 1;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }


    /**
     * 需要上浮
     * 插入元素，将新元素添加到元素的末尾，然后上浮到合适的位置
     * @param v
     */
    public void insert(T v) {
        heap[++N] = v;
        swim(N);
    }

    /**
     * 需要下沉
     * 顶端的数据和最后一个数据交换，然后删除最后的一个数据， 将顶端的数据下沉到合适的位置
     * @return
     */
    public T deleteMax() {
        T max = heap[1];
        swap(1, N);
        heap[N] = null;
        N--;
        sink(1);
        return max;
    }


    public void sort(T[] nums) {


    }



}
