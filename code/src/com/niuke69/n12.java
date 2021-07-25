package com.niuke69;

import java.util.Arrays;

/**
 * package: com.niuke69
 * date: 2019/3/29 20:02
 * @author smallcase
 * @since JDK 1.8
 */
public class n12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){

        boolean[] isVisited = new boolean[matrix.length];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(isVisited, false);
                if (isMatchAtHere(matrix, rows,cols,i, j, str, isVisited, count)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isMatchAtHere(char[] matrix,int rows,int cols,int row,int col,char[] str,boolean[] isVisited,int count){
        int index = row*cols+col;
        if (row>=rows||col>=cols||row<0||col<0||str[count]!=matrix[index]||isVisited[index]){
            return false;
        }

        isVisited[index] = true;
        if (++count == str.length) return true;
        if(isMatchAtHere(matrix,rows,cols,row+1,col,str,isVisited,count)||
           isMatchAtHere(matrix,rows,cols,row,col+1,str,isVisited,count)||
           isMatchAtHere(matrix,rows,cols,row,col-1,str,isVisited,count)||
           isMatchAtHere(matrix,rows,cols,row-1,col,str,isVisited,count)){
            return true;

        }

        //回溯
        isVisited[index] = false;
        return false;

    }


}
