package com.datastructureandalgorithm;


import java.util.*;

public class LetterCombinations {
    public static void helper(String digits,List<String> ans, Map<Character,List<Character>> map,int index,String temp){
        List<Character> list = new ArrayList<>();
        if(index<digits.length()){
           list = map.get(digits.charAt(index));
        }
        if(index == digits.length()){
            ans.add(temp);
            return;
        }

        for(int i=0;i<list.size();i++){
            Character ch = list.get(i);
            helper(digits,ans,map,index+1,temp+ch);
        }
    }
    public static List<String> letterCombinations(String digits){
        List<String> ans = new ArrayList<>();
        Map<Character,List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r','s'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y','z'));
        helper(digits,ans,map,0,"");
        return ans;
    }
    public static void main(String[] args) {
        String digits = "";
        List<String> ans = letterCombinations(digits);
        System.out.println(ans);
    }
}
