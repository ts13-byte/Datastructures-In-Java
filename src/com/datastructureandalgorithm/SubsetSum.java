package com.datastructureandalgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
   public static void  findSubsetSum(int[] arr, int sum, List<Integer> ans, int index){
        if(index == arr.length){
            ans.add(sum);
            return;
        }
        findSubsetSum(arr,sum+arr[index],ans,index+1);
        findSubsetSum(arr,sum,ans,index+1);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,1};
        List<Integer> ans = new ArrayList<>();
        findSubsetSum(arr,0,ans,0);
        Collections.sort(ans);
        System.out.println(ans);
    }
}
