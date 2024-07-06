package com.datastructureandalgorithm;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratePowerSets {
    static void generateSetsRecursive(String s, List<String> ans, int index , int n , String temp){
        if(index == n) {
            ans.add(temp);
            return;
        }
        generateSetsRecursive(s,ans,index+1,n,temp+s.charAt(index));
        generateSetsRecursive(s,ans,index+1,n,temp);
    }
    static void generateSetsRecursiveIntegers(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index){
        if(index == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        generateSetsRecursiveIntegers(nums,ans,temp,index+1);
        temp.remove(temp.size()-1);
        generateSetsRecursiveIntegers(nums,ans,temp,index+1);

    }


    static ArrayList<String> AllPossibleStrings(String s) {
        int n = s.length();
        ArrayList<String>ans=new ArrayList<>();
        for (int num = 0; num < (1 << n); num++) {
            String sub = "";
            for (int i = 0; i < n; i++) {
                //check if the ith bit is set or not
                if ((num & (1 << i))!=0) {
                    sub += s.charAt(i);
                }
            }
            if (sub.length() > 0) {
                ans.add(sub);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
//        String s = "abc";
//        String temp = "";
//        List<String> ans= new ArrayList<>();
       // generateSetsRecursive(s,ans,0,s.length(),temp);
       //ans= AllPossibleStrings(s);
        //System.out.println(ans);
        int[] nums=new int[]{1,2,3};
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        generateSetsRecursiveIntegers(nums,ans,temp,0);
        System.out.println(ans);

    }
}
