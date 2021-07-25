package com.real;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @package: com.real
 * @date: 2019/4/8 20:14
 * @author: smallcase
 * @description
 */
public class Path {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().trim().split(" ");
        sc.close();

        int n = Integer.valueOf(array[0]);
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 1;i<array.length;i++){
            if (array[i].substring(array[i].length()-1).equals("/")){
                array[i] = array[i].substring(0,array[i].length() - 1);
            }
            sb.append("1");
            Integer count = (map.get(array[i]) == null) ? 1 : 1 + map.get(array[i]);
            int length = array[i].substring(1).split("/").length - 2;//path的长度
            int length2 = length + 2;
            while (length-->0){
                sb.append(count.toString());
            }
            map.put(array[i], count);
            if (length2>=2){
                sb.append("1").append(" ");
            }else{
                sb.append(" ");
            }
        }

        System.out.println(sb.toString().trim());

    }
}
