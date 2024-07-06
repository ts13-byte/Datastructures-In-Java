package com.datastructureandalgorithm;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithZeroSum {
    public static int LengthOfLongestSubarrayWith0Sum(Integer[] nums, int n){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int prefix=0;
        int maxi=0;
        for(int i=0;i<n;i++){
            prefix+=nums[i];
            if(map.containsKey(prefix)){
                int firstIndex=map.get(prefix);
                maxi=Math.max(maxi,(i-firstIndex));
            }
            if(!map.containsKey(prefix)){
                map.put(prefix,i);
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        Integer[] nums=new Integer[]{9, -3, 3, -1, 6, -5};

        int n=nums.length;
       int maxLen= LengthOfLongestSubarrayWith0Sum(nums,n);
        System.out.println("max length found is : "+maxLen);
    }
}
