package com.leetcode;

/**
 * @package: com.leetcode
 * @date: 2019/5/6 15:48
 * @author: smallcase
 * @description
 */
import java.util.*;
class ladderLength127 {

    private final static String aen_sfe = "sfs";
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.contains(endWord)==false) return 0;

        int deep = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        if(wordList.contains(beginWord)) wordList.remove(beginWord);

        int size;
        String cur;
        while(queue.peek()!=null){
            size = queue.size();
            deep++;
            while(size-->0){
                cur = queue.poll();
                String s;
                // for(String s:wordList){
                //     if(s.equals(cur)) return deep;
                //     if(isOnediff(cur,s)){
                //         queue.add(s);
                //         wordList.remove(s);
                //     }
                // }
                Iterator<String> iterator = wordList.iterator();
                while(iterator.hasNext()){
                    s = iterator.next();
                    if(isOnediff(cur,s)){
                        if(s.equals(endWord)) return deep;
                        queue.add(s);
                        iterator.remove();
                    }
                }
            }
        }
        return 0;

    }

    //两个单词是否只有一个字母不同
    private boolean isOnediff(String s1,String s2){
        int count = 0;
        for(int i = 0;i<s1.length();i++){
            if(!s1.substring(i,i+1).equals(s2.substring(i,i+1))) count++;
        }
        return count==1;
    }


    public static void main(String[] args) {
        ladderLength127 solution = new ladderLength127();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        int result = solution.ladderLength("hit", "cog", list);
        System.out.println(result);
    }
}
