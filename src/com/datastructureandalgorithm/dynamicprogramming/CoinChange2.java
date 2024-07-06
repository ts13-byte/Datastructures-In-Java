package com.datastructureandalgorithm.dynamicprogramming;

import java.util.Arrays;

public class CoinChange2 {

    static long countWaysToMakeChange(int[] arr, int n, int T) {
        // Create a 2D array to store results of subproblems
        long dp[][] = new long[n][T + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (long row[] : dp)
            Arrays.fill(row, -1);

        // Call the countWaysToMakeChangeUtil function to calculate the number of ways
        return countWaysToMakeChangeUtil(arr, n - 1, T, dp);
    }

    private static long countWaysToMakeChangeUtil(int[] arr, int index, int target, long[][] dp) {

        if(index == 0) {
            if(target % arr[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }


        long notTaken = countWaysToMakeChangeUtil(arr,index-1,target,dp);

        long taken = 0;

        if(arr[index] <= target) {
            taken = countWaysToMakeChangeUtil(arr,index,target-arr[index],dp);
        }

        return taken + notTaken;
    }


    private static long countWaysToMakeChangeTabulationUtil(int[] arr,int n, int target) {

        long[][] dp = new long[n][target+1];

        for(int i=0;i<=target;i++) {
            if(i%arr[0] == 0) {
                dp[0][i] = 1;
            }
            else {
                dp[0][i] = 0;
            }
        }

       for(int index = 1;index<n;index++) {
           for(int t = 0;t<=target;t++){
               long notTaken = dp[index-1][t];

               long taken = 0;

               if(arr[index] <= t) {
                   taken = dp[index][t-arr[index]];
               }

               dp[index][t] = taken + notTaken;
           }
       }

       return dp[n-1][target];
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3,5,9,7};
        int target = 12;
        int n = arr.length;

        // Call the countWaysToMakeChange function and print the result
        System.out.println("The total number of ways is " + countWaysToMakeChange(arr, n, target));
        System.out.println("The total number of ways is " + countWaysToMakeChangeTabulationUtil(arr, n, target));
    }
}
