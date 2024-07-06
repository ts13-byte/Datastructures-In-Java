package com.datastructureandalgorithm.dynamicprogramming;

import java.util.Arrays;

public class CountSubsetsWithSumK {
    public static void main(String[] args) {
        int arr[] = {0,0,1};
        int k = 1;
        int n = arr.length;

        int[][] dp = new int[n][k+1];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        System.out.println(countSubsets(arr,k,n));
    }

    public static int countSubsetsMemo(int[] arr , int target ,int index,int[][] dp) {

        if(index == 0) {
            if(target == 0 && arr[0] == 0) return 2;
            else if(target == 0 || target == arr[0]) return 1;
            else return 0;
        }

        if(dp[index][target] != -1) return dp[index][target];

        int notTaken = countSubsetsMemo(arr,target,index-1,dp);
        int taken = 0;
        if(arr[index] <= target) {
            taken = countSubsetsMemo(arr,target-arr[index],index-1,dp);
        }

        int ways = notTaken + taken;

        return dp[index][target] = ways;
    }

    private static int countSubsets(int[] arr, int k, int n) {
        int[][] dp = new int[n][k+1];

        for(int i=0;i<n;i++) {
            dp[i][0] = 1;
        }
        if(arr[0] <= k) {
            dp[0][arr[0]] = 1;
        }

        for(int index = 1;index<n;index++){
            for(int target = 1;target<=k;target++) {
                int notTaken = dp[index-1][target];

                int taken = 0;
                if(arr[index] <= target){
                    taken = dp[index-1][target-arr[index]];
                }

                dp[index][target] = taken + notTaken;
            }
        }
        return dp[n-1][k];
    }
}

