package com.leetcode;

/**
 * @author xuanwo
 * @date 2021/8/8
 * @description:
 * 
 * 方法2：继承LinkedHashMap ，实现removeEldestEntry
 */
class Lru146 {

    class DLinkedQueue{
        int key;
        int value;
        DLinkedQueue pre;
        DLinkedQueue next;
        public DLinkedQueue(){}

        public DLinkedQueue(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    //容量
    private int capacity;
    private int size;
    private DLinkedQueue head;
    private DLinkedQueue tail;

    private Map<Integer,DLinkedQueue> cache = new HashMap<>();

    public Lru146(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedQueue();
        this.tail = new DLinkedQueue();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }else{
            DLinkedQueue node = cache.get(key);
            moveToHead(node);
            return node.value;
        }

    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            DLinkedQueue node = cache.get(key);
            node.value = value;
            moveToHead(node);
        }else{
            size++;
            DLinkedQueue node = new DLinkedQueue(key,value);
            addToHead(node);
            if(size>capacity){
                //如果超出容量，删除双向链表的尾部，并从hash表中删除对应的key
                DLinkedQueue node = removeTail();
                cache.move(node.key);
            }
        }
    }

    private DLinkedQueue removeTail(){
        DLinkedQueue node = tail.pre;
        tail.pre = node.pre;
        node.pre.next = tail;
        return node;
    }

    private void moveToHead(DLinkedQueue node){
        //前提是node已经存在队列里面
        removeNode(node);
        addToHead(node);

    }

    //从队列中间删除节点
    private void removeNode(DLinkedQueue node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    //将节点添加到头部
    private void addToHead(DLinkedQueue node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

}
