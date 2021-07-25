package com.real;

import java.util.Scanner;

/**
 * @Package com.real
 * @Date 2019/10/14
 * @Auther smallcase
 */
public class IP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String _userIP = sc.nextLine();
        String _blackIP = sc.nextLine();
    }

    private static boolean checkBlackList(String _userIP, String _blackIP) {
        if (!_blackIP.contains("/")) {
            return _userIP.equals(_blackIP);
        }
        int index = _blackIP.indexOf("/");
        int num = Integer.parseInt(_blackIP.substring(index + 1, _blackIP.length()));


        Long userIP = Long.valueOf(_userIP.replace(".", ""));
        Long blackIP = Long.valueOf(_blackIP.substring(0, index).replace(".", ""));

        return userIP >> (32 - num) == blackIP >> (32 - num);
    }
}
