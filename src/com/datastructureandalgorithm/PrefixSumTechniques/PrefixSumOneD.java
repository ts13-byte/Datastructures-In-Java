package com.datastructureandalgorithm.PrefixSumTechniques;

public class PrefixSumOneD {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] prefix = computePrefixSum(arr);

        // Print the prefix sum array
        for (int num : prefix) {
            System.out.print(num + " ");
        }

        int ans = rangeQuery(2,4,prefix,arr);
        System.out.println(ans);
    }

    private static int rangeQuery(int i, int j, int[] prefix, int[] arr) {
        return prefix[j] - prefix[i] + arr[i];
    }


    private static int[] computePrefixSum(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];

        prefixSum[0] = arr[0];

        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
       return prefixSum;
    }
}
