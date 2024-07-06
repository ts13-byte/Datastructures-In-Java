package com.datastructureandalgorithm;

import java.util.*;

public class WordBreak {
    public static boolean helper(String s , List<String> wordDict , int index, int[] memo){
        if(index==s.length()){
            return true;
        }

        if(memo[index] != -1) {
            return memo[index] == 1 ? true : false;
        }

        for(int i=index;i<s.length();i++){
            if(wordDict.contains(s.substring(index,i+1))){
                if(helper(s,wordDict,i+1,memo)){
                    memo[index] = 1;
                    return true;
                }
            }
        }
        memo[index] = 0;
        return false;
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] memo = new int[n];
        for(int i=0 ; i<n; i++){
            memo[i]=-1;
        }
        return helper(s,wordDict,0,memo);
    }
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordBreak(s,wordDict);
    }
}
