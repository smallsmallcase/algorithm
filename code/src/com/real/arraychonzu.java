package com.real;

import java.util.*;
public class arraychonzu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = Integer.parseInt(sc.nextLine());
        Queue<Integer> queue;

        List<Queue> list = new LinkedList<>();
        String[] str;
        String line;
        while (sc.hasNextLine()&&!"".equals(line=sc.nextLine().trim())) {
            queue = new LinkedList<>();
            str = line.split(",");
            for(String s:str){
                if(!"".equals(s)) {
                    queue.add(Integer.valueOf(s));
                }
            }
            list.add(queue);
        }
        sc.close();


        StringBuilder sb = new StringBuilder();
        while (list.size()!=0){
            for(Queue q: list){
                int count = 0;
                while (q.peek()!=null&&count<length){
                    count++;
                    sb.append((int) q.poll()).append(" ");
                }
                if (q.size()==0) list.remove(q);
            }
        }

        System.out.println(sb.toString().trim());

    }
}
