package com.huj.ch3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * package: com.huj.ch3
 * date: 2018/10/3 16:23
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class MyList {

    public static void main(String[] args) {
        /*
        传入LinkedList
         */
        LinkedList<Integer> linkedList = new LinkedList<>();
        makeList(linkedList, 13);



        /*
        传入ArrayList
         */
        ArrayList<Integer> arrayList = new ArrayList<>();
        makeList(arrayList, 13);


        System.out.println(arrayList.toString());

        for (Integer anArrayList : arrayList) {
            System.out.println(anArrayList);

        }


        /*
        上面的方法是增强的for 循环，最后由编译器编译成下面的这种方法
         */
        Iterator<Integer> iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }


        System.out.println(1 << 30);


    }

    private static void makeList(List<Integer> lst, int N) {
        lst.clear();
        for (int i = 0; i < N; i++) {
            lst.add(i);
        }

    }
}
