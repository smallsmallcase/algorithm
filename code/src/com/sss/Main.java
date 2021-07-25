package com.sss;

/**
 * package: com.sss
 * date: 2019/3/21 20:18
 *
 * @author smallcase
 * @since JDK 1.8
 */
import java.util.*;
public class Main{
    private final static long val= 1000000007L;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] array = sc.nextLine().trim().split(" ");
        int n = Integer.valueOf(array[0]);
        int k = Integer.valueOf(array[1]);
        long[] np = new long[k+1];
        Arrays.fill(np,1L);
        for(int i=1;i<n;i++){//长度是n,数字都在1到k之间

            long[] temp = Arrays.copyOf(np, np.length);
            for(int j=1;j<=k;j++){
                int t = 1;
                while(t<j){
                    np[j]+=temp[t];
                    t++;
                }

                t++;
                while (t<=k){
                    if(t%j!=0) np[j]+=temp[t];
                    t++;
                }
                np[j] %= val;

            }
        }

        long res = 0L;
        for(int i=1;i<=k;i++){
            res+=np[i];
        }
        System.out.println(res%val);

    }
}
