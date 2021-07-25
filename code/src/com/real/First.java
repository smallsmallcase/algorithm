package com.real;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * package: com.real
 * date: 2019/3/28 19:59
 *
 * @author smallcase
 * @since JDK 1.8
 */

/**
 * 假设一条记录的字段间用'#'隔开
 */
public class First {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        Queue<String> result = new LinkedList<>();
        int lastAbnormalLine = 0,currentLine = 0;
        while (sc.hasNextLine()) {
            queue.add(sc.nextLine());
        }

        int count = 0;
        while (queue.peek() != null) {
            currentLine++;
            String data = queue.poll();
            //如果该条记录异常
            if (isAbnormal(data)) {
                count++;
                result.add(normalMerge(data));
                if (currentLine - lastAbnormalLine < 10) {
                    String one = result.poll();
                    result.add(merge(one, data));
                }
                lastAbnormalLine = count;
            }
        }
        while (result.peek() != null) {
            System.out.println(result.poll());
        }

    }


    //判断该条信息是不是异常
    //假设一条记录的字段间用'#'隔开
    private static boolean isAbnormal(String line){
        String cong_index = line.split("#")[2];
        return Integer.parseInt(cong_index) > 2;
    }
    //将两条异常记录合并
    private static String merge(String one,String two){
        String[] data1 = one.split("#");
        String p1 = data1[1].split(",")[1];
        String[] data2 = two.split("#");
        String p2 = data2[1].split(",")[1];
        String realp = p1 + "," + p2;
        StringBuilder sb = new StringBuilder();
        sb.append(data1[0]).append("#").append(realp).append("#").append(data1[2]);
        return sb.toString();
    }

    private static String normalMerge(String s) {
        String[] str = s.split("#");
        StringBuilder sb = new StringBuilder();
        sb.append(str[0]).append("#").append(str[1]).append(",").
                append(str[1]).append("#").append(str[2]);
        return sb.toString();
    }
}
