package com.niuke69;

/**
 * @package: com.niuke69
 * @date: 2019/4/6 10:02
 * @author: smallcase
 * @description
 */
public class n19 {
    public boolean match(char[] str, char[] pattern){
        return onMatch(str, pattern, 0, 0);
    }

    private boolean onMatch(char[] str,char[] pattern,int indexS,int indexP){
        if (indexS==str.length&&indexP==pattern.length) return true;
        if (indexS==str.length&&indexP!=pattern.length){
            if (pattern.length-2<=indexP&&pattern[pattern.length-1]=='*') return true;
            else return false;
        }
        if (indexS!=str.length&&indexP==pattern.length) return false;
        if (str[indexS]==pattern[indexP]||pattern[indexP]=='.'){
            return onMatch(str,pattern,indexS+1,indexP+1);
        }else{
            if (pattern[indexP]!='*') return false;
            else {
                return onMatch(str, pattern, indexS + 1, indexP) ||
                        onMatch(str, pattern, indexS + 1, indexP + 1) ||
                        onMatch(str, pattern, indexS, indexP + 1);
            }
//            if (str[indexS]==pattern[indexP-1]){
//                return onMatch(str,pattern,indexS+1,indexP);
//            }else {
//                return onMatch(str, pattern, indexS + 1, indexP + 1);
//            }
        }
    }



    private boolean oneMatch(char[] str,char[] pattern, int indexL,int indexR){
        if(indexL==str.length&&indexR==pattern.length) return true;
        if(indexL==str.length&&indexR!=pattern.length){
            if(pattern.length-indexR<=2&&pattern[pattern.length-1]=='*'){
                return true;
            }else return false;
        }
        if(indexL!=str.length&&indexR==pattern.length) return false;

        if(str[indexL]==pattern[indexR]){
            return oneMatch(str,pattern,indexL+1,indexR+1);
        }
        if(str[indexL]!=pattern[indexR]){
            if(pattern[indexR]=='.') return oneMatch(str,pattern,indexL+1,indexR+1);
            if(indexR<=pattern.length-2&&pattern[indexR+1]=='*') return oneMatch(str,pattern,indexL,indexR+2);
            if(pattern[indexR]=='*'){
                if(str[indexL]==str[indexL-1]){
                    return oneMatch(str,pattern,indexL+1,indexR);
                }else if(pattern[indexR-1]=='.'){
                    return oneMatch(str,pattern,indexL+1,indexR+1);
                }else return oneMatch(str,pattern,indexL,indexR+1);

            }
            return false;
        }
        return false;
    }
}
