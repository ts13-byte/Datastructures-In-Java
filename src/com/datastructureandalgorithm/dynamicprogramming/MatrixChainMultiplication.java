package com.datastructureandalgorithm.dynamicprogramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int n = arr.length;

        System.out.println("The minimum number of operations are " + matrixMultiplicationTabulation(arr, n));
    }

    private static int matrixMultiplicationTabulation(int[] arr, int n) {
        int[][] dp = new int[n][n];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        // Initialize the diagonal with 0
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int minOperations = Integer.MAX_VALUE;

                // Partitioning loop to find the optimal split point
                for (int k = i; k <= j - 1; k++) {
                    int operations = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    minOperations = Math.min(minOperations, operations);
                }

                dp[i][j] = minOperations;
            }
        }

        // The result is stored in dp[1][N-1]
        return dp[1][n - 1];

    }

    private static int matrixMultiplication(int[] arr , int n , int i , int j) {

        if(i==j) return 0;

        int mini = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int steps = arr[i-1] * arr[k] * arr[j] + matrixMultiplication(arr,n,i,k) + matrixMultiplication(arr,n,k+1,j);
            mini = Math.min(mini,steps);
        }
        return mini;
    }
}
