package com.datastructureandalgorithm.dynamicprogramming;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        PrintLongestCommonSubsequence p = new PrintLongestCommonSubsequence();
        String s1= "abcde";
        String s2= "bdgek";
        System.out.println("longest common substring is : " + p.longestCommonSubsequence(s1,s2));
    }
    public String longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int length = dp[n][m];
        int i  = n;
        int j = m;
        String s = "";
        int index = length-1;
        for(int k = 0; k < length; k++) {
            s += '$';
        }
        StringBuilder ss = new StringBuilder(s);
        while(i>0 && j>0) {
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                ss.setCharAt(index,text1.charAt(i-1));
                index--;
                i--;
                j--;
            }else {
                if(dp[i][j-1] > dp[i-1][j]){
                    j--;
                } else {
                    i--;
                }
            }
        }
        return ss.toString();
    }
}
