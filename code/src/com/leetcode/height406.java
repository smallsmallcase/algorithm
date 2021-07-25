package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @package: com.leetcode
 * @date: 2019/4/7 14:54
 * @author: smallcase
 * @description
 */
import java.util.*;
class height406 {
    public int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0||people[0].length==0){
            return new int[0][0];
        }

//        Arrays.sort(people, (a, b) -> ((a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]));
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
            }
        });
        List<int[]> list = new LinkedList<>();
        for(int[] p: people){
            list.add(p[1],p);
        }

        return list.toArray(new int[list.size()][2]);
    }
}