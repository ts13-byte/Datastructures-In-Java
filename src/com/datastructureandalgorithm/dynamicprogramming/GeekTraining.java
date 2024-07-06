package com.datastructureandalgorithm.dynamicprogramming;

import java.util.Arrays;

public class GeekTraining {
    public static void main(String[] args) {
        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};
        int n = points.length;
        int dp[][] = new int[n][4];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Start the recursive calculation from the last day (n - 1) with the last activity (3)
        System.out.println(getMaxPoints(n - 1, 3, points, dp));
    }

//    public static int getMaxPointsTabulation(int[][] points) {
//        int n = points.length;
//        int[][] dp = new int[n][4];
//
//        for(int i=0;i<3;i++) {
//            dp[0][i] = Math.max
//        }
//    }


    private static int getMaxPoints(int day , int last, int[][] points, int[][] dp) {

        if(day == 0) {
            int maxi = 0;
            for(int i=0;i<3;i++){
                maxi = Math.max(points[day][i],maxi);
            }
            return maxi;
        }
        if(dp[day][last] != -1) {
            return dp[day][last];
        }
        int maxi = 0;
        for(int i=0;i<3;i++){
            if(i!=last) {
                int totalPoints = points[day][i] + getMaxPoints(day-1,i,points,dp);
                maxi = Math.max(maxi,totalPoints);
            }
        }

        return dp[day][last] = maxi;
    }
}
