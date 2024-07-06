package com.datastructureandalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GenerateStrings{
   private int n;
   GenerateStrings(int size){
       this.n=size;
   }
   public void  helper(char s[], List<String> ans, int n, int k){
        if(n==k) {
            ans.add(new String(s));
            return;
        }
        if(s[n-1] == '1'){
            s[n]='0';
            helper(s,ans,n+1,k);
        }
        if(s[n-1] == '0'){
            s[n]='0';
            helper(s,ans,n+1,k);
            s[n]='1';
            helper(s,ans,n+1,k);
        }
    }
    public List<String> generateBinaryStrings(){
        List<String> ans = new ArrayList<>();
        if(n==0) return ans;
        char s[] = new char[n];
        s[0]='0';
        helper(s,ans,1,n);
        s[0]='1';
        helper(s,ans,1,n);
        return ans;
    }
}
public class GenerateBinaryStrings {
    public static void main(String[] args) {
        GenerateStrings generateStrings = new GenerateStrings(5);
        List<String> result = generateStrings.generateBinaryStrings();
        System.out.println(result);
    }
}
