package com.sss;

/**
 * package: com.sss
 * date: 2019/3/21 22:42
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class People<K,V> {
    private int a;
    public People(int a){
        this.a = a;
    }

    public V ss(K key,V value){
        return value;
    }


}
