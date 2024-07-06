package com.datastructureandalgorithm.dynamicprogramming;

import java.util.Arrays;

public class MinimumNumberOfCoins {
    static int minimumElements(int[] arr, int T) {
        int n = arr.length;

        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n][T + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Calculate the minimum number of elements to achieve the target sum
        int ans = minimumElementsUtil(arr, n - 1, T, dp);

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    private static int minimumElementsUtil(int[] arr, int index, int target, int[][] dp) {
        if(index==0) {
            if ((target % arr[0]) == 0) {
                return target/arr[0];
            } else {
                return (int) Math.pow(10, 9);
            }
        }

            int notTaken = minimumElementsUtil(arr,index-1,target,dp);

            int taken = (int) Math.pow(10, 9);;

            if(arr[index] <= target) {
                taken = 1 + minimumElementsUtil(arr,index,target-arr[index],dp);
            }

        return Math.min(notTaken,taken);
    }

    private static int minimumElementsTabulationUtil(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target+1];

        for(int i=0;i<=target;i++) {
            if( (i%arr[0]) == 0) {
                dp[0][i] = i/arr[0];
            } else {
                dp[0][i] = (int) Math.pow(10, 9);
            }
        }

        for(int i=1;i<n;i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                int notTaken = dp[i - 1][j];

                int taken = (int) Math.pow(10, 9);

                if (arr[i] <= j) {
                    taken = 1 + dp[i][j - arr[i]]; // Corrected this line
                }

                dp[i][j] = Math.min(taken, notTaken);
            }
        }

        return dp[n-1][target];
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int T = 7;

        // Call the minimumElements function and print the result
        System.out.println("The minimum number of coins required to form the target sum is " + minimumElements(arr, T));
        System.out.println("The minimum number of coins required to form the target sum is " + minimumElementsTabulationUtil(arr, T));
    }
}
