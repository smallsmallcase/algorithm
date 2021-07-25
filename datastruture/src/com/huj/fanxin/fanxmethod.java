package com.huj.fanxin;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * package: com.huj.fanxin
 * date: 2018/9/28 14:32
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class fanxmethod {

    private static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        c.addAll(Arrays.asList(a));
    }

    public static void main(String[] args) {
        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<>();
        fromArrayToCollection(oa, co);

        String[] sa = new String[]{"ddadad","fsfsfsf"};
        Collection<String> cs = new ArrayList<>();
        fromArrayToCollection(sa, cs);


        /*

         */
//        fromArrayToCollection(oa, cs);
        fromArrayToCollection(sa, co);

        if (co.iterator().hasNext()) {
            System.out.println(co.iterator().next());

        }


    }
}
