package com.sss;

import java.util.*;

/**
 * package: com.sss
 * date: 2019/3/28 8:55
 *蜜蜂5个点采蜜
 * @author smallcase
 * @since JDK 1.8
 */
public class been {
    private static class Node{
        public int x;
        public int y;
        public Node(int x,int y) {
            x = x;
            y = y;
        }
    }
    private static double maxV = Double.MAX_VALUE;
    private static double curV = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i++<=4){
            list.add(sc.nextInt() + "#" + sc.nextInt());
        }
        backTrace(list, 0, 0);
        System.out.println((int)maxV);

    }

    private static void backTrace(List<String> list,int preX,int preY){
        if (list.size()==1){
            String node = list.get(0);
            String[] arr = node.split("#");
            double temp = calculate(preX, preY, Integer.parseInt(arr[0]), Integer.parseInt(arr[1])) +
                    calculate(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), 0, 0);
            curV += temp;
            maxV = Math.min(curV, maxV);
            curV -= temp;
            return;
        }

        for (int i = 0;i<list.size();i++){
            String node = list.get(i);
            String[] arr = node.split("#");
            list.remove(node);
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            double temp = calculate(preX,preY,x,y);
            curV += temp;
            backTrace(list, x, y);
            curV -= temp;
            list.add(node);
        }

    }
    //计算两点之间距离
    private static double calculate(int preX,int preY,int X,int Y){
        return Math.sqrt(Math.pow((preX-X),2)+Math.pow((preY-Y),2));
    }
}
