package com.datastructureandalgorithm;

import java.util.*;

public class RatInAMaze {
    static int[] di = {-1 , 1 , 0, 0};
    static int[] dj = {0, 0 , -1 , 1};
    static String dir = "UDLR";
    public static void helper(int[][] m , int n , int row , int col, List<String> ans , String temp){
        if(row == n-1 && col==n-1){
            ans.add(temp);
            return;
        }
        if(row < 0 || row >=n || col<0 || col>=n || m[row][col]==0) {
            return;
        }

        for(int i=0; i<4;i++){
            m[row][col] = 0;
            helper(m,n,row+di[i],col+dj[i],ans,temp+dir.charAt(i));
            m[row][col] = 1;
        }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        int row = 0;
        int col = 0;
        ArrayList<String> ans = new ArrayList<>();
        String temp = "";
        helper(m,n,row,col,ans,temp);
        return ans;
    }

    public static void main(String[] args) {
     int[][] maze = {{1, 0, 0, 0},
                     {1, 1, 0, 1},
                     {1, 1, 0, 0},
                     {0, 1, 1, 1}};
     int n = maze.length;
     List<String> ans = findPath(maze,n);
     System.out.println(ans);

    }
}
