package com.datastructureandalgorithm;

import java.util.Arrays;

public class CountSubarraysWithSumK {

    public static boolean helper(int[] a, int index, int k, Boolean[][] memo) {
        if (k == 0) {
            return true;
        }
        if (k<0 || index == a.length) {
            return false;
        }
        if (memo[index][k] != null) {
            return memo[index][k];
        }

        boolean ans1 = helper(a, index + 1, k - a[index], memo);
        boolean ans2 = helper(a, index + 1, k, memo);

        memo[index][k] = ans1 || ans2;
        return memo[index][k];
    }

    public static void main(String[] args) {
        int[] a = new int[]{22, 17, 19, 46, 48, 27, 22, 39, 20, 13, 18, 50, 36, 45, 4, 12, 23, 34, 24, 15, 42, 12, 4, 19, 48, 45, 13, 8, 38, 10, 24, 42, 30, 29, 17, 36, 41, 43, 39, 7, 41, 43, 15, 49, 47, 6, 41, 30, 21, 1, 7, 2, 44, 49, 30, 24, 35, 5, 7, 41, 17, 27, 32, 9, 45, 40, 27, 24, 38, 39, 19, 33, 30, 42, 34, 16, 40, 9, 5, 31, 28, 7, 24, 37, 22, 46, 25, 23, 21, 30, 28, 24, 48, 13};
        int k = 84;
        int n = 94;
        Boolean[][] memo = new Boolean[n][k + 1];
        boolean ans = helper(a, 0, k, memo);
        if (ans) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
