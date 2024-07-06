package com.datastructureandalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals based on the start time.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Create a list to store merged intervals.
        List<int[]> merged = new ArrayList<>();

        // Iterate through the sorted intervals and merge overlapping intervals.
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) { // Overlapping intervals.
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else { // Non-overlapping interval encountered.
                merged.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Add the last merged interval.
        merged.add(currentInterval);

        // Convert the list to a 2D array and return.
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {{1,3},{2,6},{8,10},{9,11},{15,18}};
        int[][] result = merge(intervals);

        // Print the merged intervals.
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
