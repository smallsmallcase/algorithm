package com.real;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @package: com.real
 * @date: 2019/4/17 19:57
 * @author: smallcase
 * @description
 */
public class Time {

    private static Integer[] maxTime = new Integer[6];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(sc.nextInt());
        }
        Arrays.fill(maxTime, 0);

        List<Integer> current = new ArrayList<>();
        backTrace(list,current);

        for (int i = 0;i<maxTime.length;i++){
            System.out.println(maxTime[i]);
        }
    }


    private static void backTrace(List<Integer> list,List<Integer> current) {
        if (current.size()==6){
            Integer[] array = new Integer[current.size()];
            current.toArray(array);
            if (isValid(array)){
                maxTime = compare(array, maxTime) ? array : maxTime;
            }
            return;

        }

        for (int i = 0; i < list.size(); i++) {
            Integer temp = list.get(i);
            current.add(temp);
            list.remove(temp);
            backTrace(list, current);
            current.remove(temp);
            list.add(temp);
        }


    }

    private static boolean isValid(Integer[] array){
        if (array[0]==2){
            if (array[1]<4){
                return array[2] < 6 && array[4] < 6;
            }else if (array[1]==4){
                return array[2] == 0 && array[3] == 0 && array[4] == 0 && array[5] == 0;
            } else return false;
        }else if (array[0]<2){
            return array[2] < 6 && array[4] < 6;
        } else return false;

    }

    private static boolean compare(Integer[] a1,Integer[] a2){
        for (int i = 0; i < a1.length; i++) {
            if (a1[i]>a2[i]) return true;
            else if (a1[i]<a2[i]) return false;
        }
        return false;
    }

}
