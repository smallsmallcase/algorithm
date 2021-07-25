package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: com.leetcode
 * @date: 2019/4/8 12:38
 * @author: smallcase
 * @description
 */
public class str763 {
    static class Solution {
        public List<Integer> partitionLabels(String S) {
            int[] lastIndexOfChar = new int[26];
            for(int i = 0;i<S.length();i++){
                lastIndexOfChar[char2Index(S.charAt(i))] = i;
            }
            List<Integer> list = new ArrayList<>();

            int cur = 0,firstIndex = 0,lastIndex = 0;
            int c = char2Index(S.charAt(0));
            while(cur<S.length()){
                lastIndex = (lastIndex<lastIndexOfChar[c])?lastIndexOfChar[c]:lastIndex;
                if(cur<lastIndex){
                    cur++;
                    c = char2Index(S.charAt(cur));
                }else{
                    list.add(lastIndex-firstIndex+1);
                    firstIndex = lastIndex+1;
                    cur = firstIndex;
                    if (cur<S.length()){
                        c = char2Index(S.charAt(cur));

                    }
                }
            }
            return list;
        }



        private int char2Index(char c){
            return c-'a';
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> integers = solution.partitionLabels(s);
        System.out.println(integers.toString());

    }
}
