package com.sss;

import java.util.Scanner;

/**
 * package: com.sss
 * date: 2019/3/27 20:12
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class ddd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int i = Integer.parseInt(scanner.nextLine());
            String s = scanner.nextLine();
            System.out.println(fun(s,i));
        }
    }

    public static String fun(String string ,int j){
        String result = "";
        for (int i=0;i<j;i++){
            if ((string.charAt((i*9))+"").equals("0")){
                result = result+new StringBuffer(string.substring(9*i+1,9*i+9)).reverse().toString()+" ";

            }else{
                result = result+string.substring(9*i+1,9*i+9)+" ";
            }
        }
        return result.substring(0, result.length() - 1);
    }
}
