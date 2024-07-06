package com.datastructureandalgorithm.dynamicprogramming;

import java.util.Arrays;

public class FrogJumpWithKDistances {
    public static int findTotalCost(int i, int[] height,int n, int k,int[] dp) {
        if(i==n-1) return 0;
        int minCost = Integer.MAX_VALUE;
        for(int j = 1 ; j<=k ; j++) {
            if(i<(n-j)) {
                int jumpCost =  findTotalCost(i + j, height, n, k, dp) + Math.abs(height[i + j] - height[i]);
                minCost = Math.min(minCost,jumpCost);
            }
        }
        return minCost;
    }

    public static int findTotalCostTabulation(int[] height , int k , int n) {
        int[] dp = new int[n];
        dp[n-1] = 0;
        for(int i = n-2; i>=0 ; i--) {
            int minCost = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i<(n-j)) {
                    int jumpCost = Math.abs(height[i + j] - height[i]) + dp[i+j];
                    minCost = Math.min(minCost,jumpCost);
                }
                dp[i] = minCost;
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int k = 8;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println(findTotalCost(0, height,n, k,dp));

        System.out.println(findTotalCostTabulation(height,k,n));
    }
}
