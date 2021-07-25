package com.real;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;

public class ddddd {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        String lastDate = split[0].replace("T", " ");
        long lastTime = simpleDateFormat.parse(lastDate).getTime();
        String date = "";
        String apiName = split[1];
        HashMap<String, Integer> map = new HashMap<>();
        map.put(apiName, 1);
        while (sc.hasNextLine()) {
            str = sc.nextLine();
            split = str.split(" ");
            date = split[0];
            apiName = split[1];
            long time = simpleDateFormat.parse(date.replace("T", " ")).getTime();
            if (time - lastTime <= 300000) {
                if (map.containsKey(apiName)) {
                    Integer integer = map.get(apiName);
                    map.put(apiName, integer + 1);
                } else {
                    map.put(apiName, 1);
                }
            } else {
                map.clear();
                lastTime = time;
            }
        }
    }
}
