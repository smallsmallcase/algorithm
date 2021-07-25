package algrithm;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * package: algrithm
 * date: 2019/3/1 17:07
 *48. 最长不含重复字符的子字符串
 * @author smallcase
 * @since JDK 1.8
 */
public class longeststr {
    public int longestSubStringWithoutDuplication(String str){
        int[] lastIndexs = new int[26];

        int maxLen = 0;
        int newLen = 0;
        int c;
        int lastI;
        Arrays.fill(lastIndexs, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            c = str.charAt(curI);
            lastI = lastIndexs[c];
            if (lastI==-1||curI-lastI>newLen) newLen++;
            else {
                maxLen = Math.max(maxLen, newLen);
                newLen = curI-lastI;
            }
            lastIndexs[c] = curI;
        }
        return Math.max(maxLen, newLen);
    }

    //无重复字符串最大长度
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int max = 0,p = 0;
        String substring = "";
        int index = 0;
        for(int i = 0;i<array.length;i++){
            substring = s.substring(p,i+1);
            index = substring.indexOf(String.valueOf(array[i]));
            if(index<0||index==i-p){
                max = Math.max(max,i+1-p);
            }else{
                p = index+1;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        longeststr func = new longeststr();
        String s = "bbtablud";
        int i = func.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
