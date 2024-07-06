package com.datastructureandalgorithm.dynamicprogramming;

import java.util.Arrays;

public class SubsetSum {
    static boolean subsetSumToK(int n, int k, int[] arr) {
        // Create a DP table with dimensions [n][k+1]
        int dp[][] = new int[n][k + 1];

        // Initialize DP table with -1 (unprocessed)
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return subsetSumUtilTabulation(k,arr);
    }

    private static boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {

        if(target == 0) return true;

        if(ind == arr.length) return false;
        if(dp[ind][target] != -1) {
            return dp[ind][target] == 1 ? true : false;
        }
        boolean notPick = subsetSumUtil(ind+1,target,arr,dp);
        boolean pick = false;
        if(arr[ind] <= target) {
            pick = subsetSumUtil(ind+1,target-arr[ind],arr,dp);
        }
        boolean found = pick || notPick;
        dp[ind][target] = (found == true ? 1 : 0);
        return found;
    }

    private static boolean subsetSumUtilTabulation(int k, int[] arr) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][k+1];

        // for the row , if the value of first element equals to any of target values then fill the dp as true
        for(int i=0;i<=k;i++){
            if(arr[0] == i) {
                dp[0][i] = true;
            }
        }
        // for target sum 0 , first col , it is all true
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }

        for(int index = 1;index<n;index++){
            for(int target = 1;target<=k;target++){
                boolean notTaken = dp[index-1][target];

                boolean taken = false;

                if(arr[index] <= target) {
                    taken = dp[index-1][target-arr[index]];
                }

                dp[index][target] = taken || notTaken;
            }
        }
        return dp[n-1][k];
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 6;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        if (subsetSumToK(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}
