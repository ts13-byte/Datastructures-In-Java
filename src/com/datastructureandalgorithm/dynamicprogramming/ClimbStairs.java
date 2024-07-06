package com.datastructureandalgorithm.dynamicprogramming;

import java.util.Arrays;

public class ClimbStairs {
    public static int ways(int n,int[] dp) {
        if(n==0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = ways(n-1,dp)+ways(n-2,dp);
    }
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(ways(n,dp));
    }
}
