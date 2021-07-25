package com.real;

import java.util.Scanner;

/**
 * @package: com.real
 * @date: 2019/4/8 19:40
 * @author: smallcase
 * @description
 */
public class lianbiaofanzhuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String old = sc.nextLine().trim();
        int length = Integer.valueOf(sc.nextLine());
        if (length<2){
            System.out.println(old);

        }else{
            String str = old.substring(1, old.length() - 1);
            String[] array = str.split(",");

            int i = 0;
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (i<array.length-length){
                for(int j = i+length-1;j>=i;j--){
                    sb.append(array[j]).append(" ");
                }
                i = i + length;
            }


            for(int j = i;j<array.length;j++){
                sb.append(array[j]).append(" ");
            }

            String res = sb.toString().trim().replaceAll(" ", ",");
            System.out.println(res + "]");
        }

    }
}
