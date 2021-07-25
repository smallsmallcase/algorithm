package com.real;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @package: com.real
 * @date: 2019/4/14 20:27
 * @author: smallcase
 * @description
 */
public class sanchushuzu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        String str = sc.nextLine();
        sc.close();
        String[] array = str.split(" ");
        for (String s : array) {
            list.add(Integer.valueOf(s));
        }
        int dis = 0;
        int location = 0;
        while (list.size()>1){
            dis++;
            location += dis;
            while (location+1>list.size()){
                location = location-list.size();
            }
            list.remove(location);
        }
        System.out.println(list.peek());
    }
}
