package com.huj.kmp;


/**
 * package: com.huj.kmp
 * date: 2018/11/16 21:25
 *
 * @author smallcase
 * @since JDK 1.8
 */
public class Test {

    public static void main(String[] args) {
        String str = "fafa1313rweavvavkanvkajnv";
        String pattern = "wea";
        System.out.println(calIndex(str, pattern));

    }


    /**
     * 时间复杂度O(str.length*pattern.length)
     * @param str
     * @param pattern
     * @return
     */
    private static int calIndex(String str, String pattern) {

        //获取字符数组
        char[] st = str.toCharArray();
        char[] pt = pattern.toCharArray();

        int i = 0, j = 0;
        while (i < st.length && j < pt.length) {
            //当两个字符相同就比较下一个
            if (st[i] == pt[j]) {
                i++;
                j++;
            } else {
                //j回归0，i回到每次匹配到第一个字符的下一个
                i = i-j + 1;
                j=0;

            }
        }

        //匹配到了
        if (j == pt.length) {
            return i - j;

        //没有匹配到
        } else {
            return -1;
        }
    }
}
