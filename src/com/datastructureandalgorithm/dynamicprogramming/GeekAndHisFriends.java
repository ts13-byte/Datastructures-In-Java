package com.datastructureandalgorithm.dynamicprogramming;

import java.util.Arrays;

public class GeekAndHisFriends {
    static int maximumChocolates(int n, int m, int[][] grid) {
        // Create a 3D array to store computed results
        int dp[][][] = new int[n][m][m];

        // Initialize the dp array with -1
        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }

        // Call the utility function to find the maximum number of chocolates
        return maxChocoUtilTabulation(grid,n,m);
    }

    private static int maxChocoUtil(int row, int Ac, int Bc, int n, int m, int[][] grid, int[][][] dp) {
        int[] dirCols = new int[]{-1,0,1};

        if(Ac<0 || Ac>=m || Bc<0 || Bc>=m) {
            return Integer.MIN_VALUE;
        }

        if(dp[row][Ac][Bc] != -1) {
            return dp[row][Ac][Bc];
        }

        if(row == n-1){
            if(Ac==Bc){
                return grid[row][Ac];
            }
            else {
                return grid[row][Ac] + grid[row][Bc];
            }
        }

        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int ans;
                int newAc = Ac+dirCols[i];
                int newBc = Bc+dirCols[j];
                if(Ac == Bc) {
                 ans = grid[row][Ac] + maxChocoUtil(row+1,newAc,newBc,n,m,grid,dp);
                } else {
                    ans = grid[row][Ac] + grid[row][Bc] + maxChocoUtil(row + 1, newAc, newBc, n, m, grid, dp);
                }
                maxi = Math.max(maxi,ans);
            }
        }

        return dp[row][Ac][Bc] = maxi;
    }

    public static int maxChocoUtilTabulation(int[][] grid , int n , int m) {
        int[][][] dp = new int[n][m][m];
        int[] dirCols = new int[]{-1,0,1};
        // finding all the ways to reach last row in grid for both alice and bob
        for(int Ac=0;Ac<m;Ac++) {
            for(int Bc=0;Bc<m;Bc++){
                // if both reach same row,col on grid then count only one
                if(Ac==Bc) {
                    dp[n-1][Ac][Bc] = grid[n-1][Ac];
                } else {
                    dp[n-1][Ac][Bc] = grid[n-1][Ac] + grid[n-1][Bc];
                }
            }
        }
        // now from last row keep on calculating ways to reach last row
        for(int row=n-2;row>=0;row--){
            for(int Ac=0;Ac<m;Ac++) {
                for(int Bc=0;Bc<m;Bc++) {
                    int maxi = Integer.MIN_VALUE;

                    for(int i=0;i<3;i++){
                        for(int j=0;j<3;j++){
                            int ans;
                            int newAc = Ac+dirCols[i];
                            int newBc = Bc+dirCols[j];

                            if(newAc<0 || newAc>=m || newBc<0 || newBc>=m) {
                                ans = Integer.MIN_VALUE;
                            } else {
                                if (Ac == Bc) {
                                    ans = grid[row][Ac] + dp[row + 1][newAc][newBc];
                                } else {
                                    ans = grid[row][Ac] + grid[row][Bc] + dp[row + 1][newAc][newBc];
                                }
                            }
                            maxi = Math.max(maxi,ans);
                        }
                    }
                    dp[row][Ac][Bc] = maxi;
                }
            }
        }

        return dp[0][0][m-1];
    }

    public static void main(String args[]) {
        int matrix[][] = {{2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}};
        int n = matrix.length;
        int m = matrix[0].length;
        System.out.println(8/3);

        // Call the maximumChocolates function and print the result
        System.out.println(maximumChocolates(n, m, matrix));
    }
}
