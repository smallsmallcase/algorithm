package com.sss;

/**
 * package: com.sss
 * date: 2019/3/25 15:01
 *
 * @author smallcase
 * @since JDK 1.8
 */
import java.util.*;
public class zuobiao{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] xarray = new int[n];
        String[] str;
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++){
            str = sc.nextLine().trim().split(" ");
            map.put(Integer.valueOf(str[0]),Integer.valueOf(str[1]));
            xarray[i] = Integer.valueOf(str[0]);
        }

        Arrays.sort(xarray);
        int maxY=0,x,y;
        for(int i=n-1;i>=0;i--){
            x = xarray[i];
            y = map.get(x);
            if(maxY<=y){
                maxY = y;
            }else {
                map.remove(x);
            }
        }

        for(Map.Entry e:map.entrySet()){

            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}

