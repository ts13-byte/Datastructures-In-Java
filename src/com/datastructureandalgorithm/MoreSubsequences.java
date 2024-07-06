package com.datastructureandalgorithm;

import java.util.ArrayList;
import java.util.*;

public class MoreSubsequences {
   static void helper(String s , Set<String> ans , int index, String temp){
       if(index==s.length()){
           ans.add(temp);
           return;
       }
       helper(s,ans,index+1,temp+s.charAt(index));
       helper(s,ans,index+1,temp);
   }
    public static String moreSubsequence(int n, int m, String a, String b) {
       Set<String> ans1 = new HashSet<>();
       Set<String> ans2 = new HashSet<>();
      helper(a,ans1,0,"");
      helper(b,ans2,0,"");
      if(ans1.size()>ans2.size()) return a;
      return b;
   }
    public static void main(String[] args) {
       String answer= moreSubsequence(1,3, "f","eeg");
        System.out.println(answer);
    }
}
