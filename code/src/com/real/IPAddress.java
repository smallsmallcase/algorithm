package com.real;

import java.util.Scanner;

/**
 * @Package com.real
 * @Date 2019/9/16
 * @Auther smallcase
 */
public class IPAddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        if (str.contains(".")) {
            delO(str);
        } else if (str.contains(":")) {

            delH(str);
        } else {
            System.out.println("Neither");

        }
    }

    private static void delO(String str){
        String[] address = str.split("\\.");
        if (address.length != 4) {
            System.out.println("Neither");
            return;
        }
        int num = 0;
        for (int i = 0; i < 4; i++) {
            if (i == 0 && address[i].startsWith("0")) {
                System.out.println("Neither");
                return;
            } else if (address[i].startsWith("0") && address[i].length() > 1) {
                System.out.println("Neither");
                return;
            }else {
                try {
                    num = Integer.parseInt(address[i]);
                    if (num >= 0 && num <= 255) {
                        continue;
                    } else {
                        System.out.println("Neither");
                        return;
                    }
                }catch (Exception e){
                    System.out.println("Neither");
                    return;
                }
            }
        }

        System.out.println("IPv4");

    }

    private static void delH(String str) {
        String[] address = str.split(":");
        if (address.length != 8) {
            System.out.println("Neither");
            return;
        }

        for (String num : address) {
            if (num.length() > 0 && num.length() <= 4) {
                if (num.startsWith("00")) {
                    System.out.println("Neither");
                    return;
                } else {
                    char[] array = num.toCharArray();
                    for (char c : array) {
                        if (c <= 9 || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                            continue;
                        } else {
                            System.out.println("Neither");
                            return;
                        }
                    }

                }
            } else {
                System.out.println("Neither");
                return;
            }
        }

        System.out.println("Ipv6");

    }
}
