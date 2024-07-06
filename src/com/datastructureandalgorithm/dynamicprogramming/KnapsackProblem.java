package com.datastructureandalgorithm.dynamicprogramming;

public class KnapsackProblem {
    public static int findMaxPoints(int[] values , int[] weights , int index , int cap , int n) {

        if(index == n - 1) {
            if(weights[n-1] <= cap) {
                return values[n-1];
            }
            return 0;
        }

        int notTaken = findMaxPoints(values,weights,index+1,cap,n);

        int taken = Integer.MIN_VALUE;

        if(weights[index] <= cap) {
            taken = values[index] + findMaxPoints(values , weights , index+1, cap-weights[index],n);
        }

        return Math.max(taken,notTaken);
    }

    public static int findMaxPointsTabulation(int[] values , int[] weights , int wt , int n) {
        int[][] dp = new int[n][wt+1];

        for(int i=weights[0];i<=wt;i++) {
            dp[0][i] = values[0];
        }

        for(int i=1;i<n;i++){
            for(int cap=1;cap<=wt;cap++) {
                int notTaken = dp[i-1][cap];

                int taken = Integer.MIN_VALUE;

                if(weights[i] <= cap){
                    taken = values[i] + dp[i-1][cap-weights[i]];
                }

                dp[i][cap] = Math.max(taken,notTaken);
            }
        }
        return dp[n-1][wt];
    }

    public static int findMaxPointsTabulationSpaceOptimization(int[] values , int[] weights , int wt , int n) {
        int[] prev = new int[wt+1];

        for(int i=weights[0];i<=wt;i++) {
            prev[i] = values[0];
        }

        for(int i=1;i<n;i++){
            for(int cap=1;cap<=wt;cap++) {
                int notTaken = prev[cap];

                int taken = Integer.MIN_VALUE;

                if(weights[i] <= cap){
                    taken = values[i] + prev[cap-weights[i]];
                }

                prev[cap] = Math.max(taken,notTaken);
            }
        }
        return prev[wt];
    }
    public static void main(String[] args) {
        int wt[] = {1, 2, 4, 5};
        int val[] = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;

        System.out.println(findMaxPoints(val,wt,0,W,n));
        System.out.println(findMaxPointsTabulation(val,wt,W,n));
        System.out.println(findMaxPointsTabulationSpaceOptimization(val,wt,W,n));
    }
}
