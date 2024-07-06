package com.datastructureandalgorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LISUsingBS {
    static int findLowerBound(List<Integer> temp , int target) {
        int low = 0;
        int high = temp.size()-1;
        int ans = temp.size();
        while(low <= high) {
            int mid = (low+high)/2;
            if(temp.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    // Function to find the length of the longest increasing subsequence
    static int longestIncreasingSubsequence(int[] arr, int n) {
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        int length = 1;

        for(int i=1;i<n;i++){
            if(arr[i] > temp.get(temp.size()-1)) {
                temp.add(arr[i]);
                length++;
            } else {
                int ind = findLowerBound(temp,arr[i]);
                temp.set(ind,arr[i]);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " +
                longestIncreasingSubsequence(arr, n));
    }
}