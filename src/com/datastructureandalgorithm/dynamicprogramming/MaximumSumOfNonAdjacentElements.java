package com.datastructureandalgorithm.dynamicprogramming;

import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 9};

        // Get the length of the array.
        int n = arr.length;

        int dp[] = new int[n];

        // Initialize the dp array with -1 to indicate that values are not calculated yet.
        Arrays.fill(dp, -1);

        // Call the recursive solver for the last index (n-1).
        System.out.println(findMaxSum(0, arr, dp));

        int[] dp1 = new int[n-1];
        int[] dp2 = new int[n-1];
        int maxSum = Math.max(findMaxSumCircular(0,n-2,arr,dp1),findMaxSumCircular(1,n-1,arr,dp2));
        System.out.println(maxSum);

    }

    private static int  findMaxSum(int i, int[] arr, int[] dp) {
        int n = arr.length;

        if(i>=n) return 0;

        if(dp[i] != -1) return dp[i];

        int pick = arr[i] + findMaxSum(i+2,arr,dp);
        int notPick = findMaxSum(i+1,arr,dp);

        return dp[i] = Math.max(pick,notPick);
    }

    private static int  findMaxSumTabulation(int[] arr) {
        int n = arr.length;

        int[] dp = new int[n+2];
        dp[n] = 0;
        dp[n+1] = 0;

        for(int i=n-1;i>=0;i--) {
            int pick = arr[i] + dp[i+2];
            int notPick = dp[i+1];
            dp[i] = Math.max(pick,notPick);
        }

        return dp[0];
    }

    private static int  findMaxSumCircular(int start,int end, int[] arr, int[] dp) {

        if(start>=end) return 0;

        if(dp[start] != -1) return dp[start];

        int pick = arr[start] + findMaxSumCircular(start+2,end,arr,dp);
        int notPick = findMaxSumCircular(start+1,end,arr,dp);

        return dp[start] = Math.max(pick,notPick);
    }
}
