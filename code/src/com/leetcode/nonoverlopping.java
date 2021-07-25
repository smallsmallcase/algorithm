package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @package: com.leetcode
 * @date: 2019/4/7 10:33
 * @author: smallcase
 * @description
 */
public class nonoverlopping {

    // Definition for an interval.
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
     }

    public int eraseOverlapIntervals(Interval[] intervals){
        if (intervals.length==0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        int cnt = 1;
        int end = intervals[0].end;

        for(int i = 1;i<intervals.length;i++){
            if (intervals[i].start<end) {
                continue;
            }
            cnt++;
            end = intervals[i].end;
        }
        return intervals.length - cnt;
    }
}
