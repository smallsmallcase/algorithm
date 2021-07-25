package lru;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * package: lru
 * date: 2019/3/7 15:46
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class LRU<K, V> implements Iterable<K> {

    private Node head;
    private Node tail;
    private HashMap<K,Node> map;
    private int maxSize;

    /**
     * inner class
     */
    private class Node{
        Node pre;
        Node next;
        K k;
        V v;
        public Node(K k,V v){
            this.k = k;
            this.v = v;
        }
    }

    /**
     *
     * @param maxSize
     */
    public LRU(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<>(maxSize * 4 / 3);
        head = new Node(null, null);
        tail = new Node(null, null);

    }

    private void appendHead(Node node){
        Node temp = head;
        temp.pre = node;
        node.next = temp;
        head = node;
    }

    private Node removeTail(){
        Node temp = tail;
        Node pre = tail.pre;
        pre.next = null;
        tail.pre = null;
        tail = pre;
        return temp;
    }

    private void unlink(Node node) {
        Node next = node.next;
        Node pre = node.pre;
        if (next == null) {
            removeTail();
        } else if (pre == null) {
            next.pre = null;
            node.next = null;
            head = next;
            node = null;

        } else {
            next.pre = pre;
            pre.next = next;
            node.pre = null;
            node.next = null;
        }

    }

    public void put(K key,V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            unlink(node);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        appendHead(node);
        if (map.size() > maxSize) {
            Node toRemove = removeTail();
            map.remove(toRemove.k);
        }
    }

    public V get(K key){

        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        V value = node.v;
        unlink(node);
        appendHead(node);
        return value;
    }



    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private Node cur = head;

            @Override
            public boolean hasNext() {
                return cur.next != tail;
            }

            @Override
            public K next() {
                K k = cur.k;
                cur = cur.next;
                return k;
            }
        };
    }
}
