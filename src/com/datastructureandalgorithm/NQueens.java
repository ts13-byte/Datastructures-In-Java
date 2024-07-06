package com.datastructureandalgorithm;

import java.util.*;

public class NQueens {
    public static List<String> construct(char[][] arr){
        List<String> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            String temp="";
            for(int j=0;j< arr.length;j++){
                temp+=arr[i][j];
            }
            res.add(temp);
        }
        return res;
    }
    // in this method only check for lower , upper diagonals and back cols of current possible position.
    public static boolean isValid(int row , int col , char[][] arr){
        int n = arr.length;
      int dupRow = row;
      int dupCol = col;
      //check the back cols in this loop
      while(dupCol>=0){
          if(arr[dupRow][dupCol] == 'Q'){
              return false;
          }
          dupCol--;
      }
      dupRow = row;
      dupCol = col;
      //check the upper diagonal to the back of the current pos in this loop
      while(dupCol>=0 && dupRow>=0 ){
          if(arr[dupRow][dupCol] == 'Q'){
              return false;
          }
          dupRow--;
          dupCol--;
      }

        dupRow = row;
        dupCol = col;
        //check the lower diagonal to the back of the current pos in this loop
        while(dupCol>=0 && dupRow<n){
            if(arr[dupRow][dupCol] == 'Q'){
                return false;
            }
            dupCol--;
            dupRow++;
        }

        return true;
    }
    public static void helper(int col , List<List<String>> ans, char[][] arr){
        if(col==arr.length){
            ans.add(construct(arr));
            return;
        }
        for(int row = 0; row < arr.length ; row++){
            if(isValid(row,col,arr)){
                arr[row][col] = 'Q';
                helper(col+1,ans,arr);
                arr[row][col] = '.';
            }
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        helper(0,ans,arr);
        return ans;
    }
    public static void main(String[] args) {
        List<List<String>> ans = solveNQueens(4);
        System.out.println(ans);
    }
}
