package com.real;

/**
 * @package: com.real
 * @date: 2019/4/5 21:19
 * @author: smallcase
 * @description
 */
import java.util.Scanner;
import java.util.Stack;

public class zifuchuan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int len = Integer.parseInt(sc.nextLine());
            String string = sc.nextLine();
            char ss[] = string.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                if (stack.isEmpty()) {
                    stack.push(ss[i]);
                    continue;
                }
                if (ss[i] == '1') {
                    if (stack.peek() == '0') {
                        stack.pop();
                    } else {
                        stack.push(ss[i]);
                    }
                } else {

                    if (ss[i] == '0') {
                        if (stack.peek() == '1') {
                            stack.pop();
                        } else {
                            stack.push(ss[i]);
                        }
                    }
                }
            }
            System.out.println(stack.size());

        }
    }
}



