package com.datastructureandalgorithm.dynamicprogramming;

public class RodCuttingProblem {
    public static int cutRod(int[] prices , int index , int length) {

        if(index == 0) {
            return length * prices[0];
        }
        int notTake = cutRod(prices,index-1,length);

        int take = Integer.MIN_VALUE;
        int rod_length = index+1;

        if(rod_length<=length) {
            take = prices[index] + cutRod(prices,index,length-rod_length);
        }

        return Math.max(take,notTake);
    }
    public static void main(String[] args) {
        int[] prices = new int[]{2,5,7,8,10};
        int n = prices.length;
        int N = 5;
        cutRod(prices,n-1,N);
    }
}
