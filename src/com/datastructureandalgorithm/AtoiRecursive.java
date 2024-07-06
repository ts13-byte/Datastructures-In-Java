package com.datastructureandalgorithm;

public class AtoiRecursive {
    static  int myAtoi(String s) {
        int n=s.length();
        s=s.trim();
        int idx=0;
        int sign = 1;
        if((idx < s.length()) && (s.charAt(idx)=='+' || s.charAt(idx)=='-' )) {
            sign = s.charAt(idx)=='-' ? -1 : 1;
            idx++;
        }
        return  atoiRecursive(s,idx,sign,0);
    }

    static int atoiRecursive(String s, int idx , int sign, int res) {

        if( idx >= s.length() || !Character.isDigit(s.charAt(idx)) ) return sign*res;

        int digit = s.charAt(idx)-'0';

        if(res > (Integer.MAX_VALUE - digit)/10) {
            return  sign==1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }

        res = res*10+digit;

        return atoiRecursive(s,idx+1,sign,res);


    }
    public static void main(String[] args) {
        String s = "   -423";
        int answer= myAtoi(s);
        System.out.println(answer);
    }
}
