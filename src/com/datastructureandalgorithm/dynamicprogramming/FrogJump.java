package com.datastructureandalgorithm.dynamicprogramming;

import java.util.Arrays;

public class FrogJump {
    public static int minimizeEnergy(int[] heights , int i , int n , int[] dp){
        if(i==n-1) return 0;
        if(dp[i] != -1) return dp[i];
        int op1 = minimizeEnergy(heights,i+1,n,dp) + Math.abs(heights[i+1]-heights[i]);
        int op2 = Integer.MAX_VALUE;
        if(i<n-2) {
            op2 = minimizeEnergy(heights, i + 2, n, dp) + Math.abs(heights[i + 2] - heights[i]);
        }

        return dp[i] = Math.min(op2,op1);
    }
    public static int minimizeEnergyUsingTabulation(int[] heights, int n){
        int[] tab = new int[n];
        tab[n-1] = 0;

        for(int k=n-2;k>=0;k--) {
            int op1 = tab[k+1] + Math.abs(heights[k+1] - heights[k]);
            int op2 = Integer.MAX_VALUE;
            if(k<n-2) {
                op2 = tab[k+2] + Math.abs(heights[k+2] - heights[k]);
            }

            tab[k] = Math.min(op1,op2);
        }

        return tab[0];
    }
    public static void main(String[] args) {
        int height[]={30,10,60,10,60,50};
        int n=height.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int ans = minimizeEnergy(height,0,n,dp);
        System.out.println(ans);
        int ans2 = minimizeEnergyUsingTabulation(height,n);
        System.out.println(ans2);
    }
}
