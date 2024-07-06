package com.datastructureandalgorithm.PrefixSumTechniques;

public class PrefixSumFor2DArrays {
    public static int[][] computePrefixSum(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] prefix = new int[rows][cols];

        // Initialize the first element
        prefix[0][0] = arr[0][0];

        // Initialize the first row
        for (int j = 1; j < cols; j++) {
            prefix[0][j] = prefix[0][j - 1] + arr[0][j];
        }

        // Initialize the first column
        for (int i = 1; i < rows; i++) {
            prefix[i][0] = prefix[i - 1][0] + arr[i][0];
        }

        // Compute the rest of the prefix sum array
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                prefix[i][j] = arr[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        return prefix;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] prefix = computePrefixSum(arr);

        for(int i=0;i<prefix.length;i++){
            for(int j=0;j<prefix[0].length;j++){
                System.out.print(prefix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
