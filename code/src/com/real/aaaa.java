package com.real;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @Package com.real
 * @Date 2019/9/15
 * @Auther smallcase
 */
public class aaaa{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String uri = sc.nextLine();
        uri = uri.replace("\"", "");
        int endIndex = uri.indexOf('<');
        String name = uri.substring(0, endIndex);
        if (name.startsWith("%22")) {
            name = name.substring(3);
        }
        if (name.endsWith("%22")) {
            name = name.substring(0, name.length() - 3);
        }
        System.out.println(name);
    }

}