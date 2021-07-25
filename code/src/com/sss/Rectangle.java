package com.sss;

/**
 * package: com.sss
 * date: 2019/3/29 19:16
 *
 * @author smallcase
 * @since JDK 1.8
 */
import java.util.*;

public class Rectangle {


    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] array = new Node[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Node(sc.nextInt(), sc.nextInt());
        }
        sc.close();
        int count = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1; j < n-1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isOk(array[i], array[j], array[k])) count++;
                }
            }
        }

        System.out.println(count);


    }

    private static boolean isOk(Node one, Node two, Node three) {
        return (one.y - two.y) * (one.x - three.x) != (one.y - three.y) * (one.x - two.x);
    }

}
