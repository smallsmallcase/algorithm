package com.real;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Package com.real
 * @Date 2019/9/7
 * @Auther smallcase
 */
public class tower {
    static class Node implements Comparable{
        private int loc;
        private int value;
        Node (int loc,int value){
            this.loc = loc;
            this.value = value;
        }
        public int getLoc(){
            return loc;
        }

        public int getValue(){
            return value;
        }
        @Override
        public int compareTo(Object o){
            return Integer.compare(this.value,((Node)o).value);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int start = 0;
        Node[] nodes = new Node[n];
        while(sc.hasNextInt()&&start<n){
            nodes[start] = new Node(start+1,sc.nextInt());
            start++;
        }
        sc.close();
        Arrays.sort(nodes);
        int count = 0;
        Queue<Integer> list = new LinkedList<>();
        while((nodes[n-1].value-nodes[0].value>1)&&count<k){
            count++;
            list.add(nodes[n-1].loc);
            nodes[n-1].value--;
            list.add(nodes[0].loc);
            nodes[0].value++;
            Arrays.sort(nodes);
        }

        System.out.println(nodes[n-1].value-nodes[0].value+" "+count);
        while(count-- > 0){
            System.out.println(list.poll()+" "+list.poll());
        }
    }

}
