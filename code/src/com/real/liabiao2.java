package com.real;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/**
 * @package: com.real
 * @date: 2019/4/8 21:22
 * @author: smallcase
 * @description
 */
public class liabiao2 {



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int n=str.length();
        //System.out.println(n);
        String[] strs = str.substring(1,n-1).split(",");
        int len=strs.length;
        int []res=new int[strs.length];
        for(int i=0;i<len;i++){
            res[i]=Integer.valueOf(strs[i]);
        }

        int K=Integer.valueOf(br.readLine());
        for(int i=0;i<len/K;i++){
            swap(res,i*K,(i+1)*K-1);
        }

        System.out.print("[");
        for(int i=0;i<len-1;i++){
            System.out.print(res[i]+",");
        }
        System.out.println(res[len-1]+"]");

    }

    private static void swap(int[] res, int start, int end){
        for(int i=0;i<=(end-start)/2;i++){
            int temp=res[start+i];
            res[start+i]= res[end-i];
            res[end-i]=temp;
        }
    }

}
