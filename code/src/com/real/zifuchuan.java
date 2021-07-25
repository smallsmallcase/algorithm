package com.real;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @package: com.real
 * @date: 2019/4/5 20:20
 * @author: smallcase
 * @description
 */
public class zifuchuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String str = sc.nextLine().trim();

        List<Character> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(str.charAt(i));
        }

        char pre,p;
        int count = list.size();
        while (list.size()!=0){
            pre = list.get(0);
            for(int i = 1;i<list.size();i++){
                p = list.get(i);
                if(pre!=p){//相邻两个不一样
                    list.remove(i);
                    list.remove(i-1);
                    break;

                }
                pre = p;
            }

            if (count==list.size()){
                break;
            }else {
                count = list.size();
            }

        }

        System.out.println(list.size());

    }
}
