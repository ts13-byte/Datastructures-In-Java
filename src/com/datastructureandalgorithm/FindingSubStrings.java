package com.datastructureandalgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindingSubStrings {
    public static void findSubStringsRecursively(String s, List<String> ans, int index){
        if(index == s.length()){
            return;
        }
        for(int i=index ; i<s.length(); i++){
            ans.add(s.substring(index,i+1));
        }
        findSubStringsRecursively(s,ans,index+1);
    }
    public static void main(String[] args) {
        String s = "abc";
        List<String> ans = new ArrayList<>();
        for(int i=0 ; i<s.length() ;i++){
            for(int j=i;j<s.length();j++){
               ans.add(s.substring(i,j+1));
            }
        }
        System.out.println(ans);
        List<String> answer = new ArrayList<>();
        String temp ="";
        int index=0;
        findSubStringsRecursively(s,answer,index);
        System.out.println("Recursively : " + answer);
    }
}
