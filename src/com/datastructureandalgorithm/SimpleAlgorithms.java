package com.datastructureandalgorithm;

class IntWrapper {
    int value;

    public IntWrapper(int value) {
        this.value = value;
    }
}

public class SimpleAlgorithms {
    public static void swap(IntWrapper num1, IntWrapper num2){
        int temp=num1.value;
        num1.value= num2.value;
        num2.value=temp;
    }
    public static void swapInteger(Integer num1, Integer num2){
        int temp = num1.intValue();
        num1 = num2.intValue();
        num2 = temp;
    }
    public static boolean checkPalindrome(String s){
        int start=0;
        int end=s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    public static String reverse(String s){
        int start=0;
        int end=s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while(start<=end){
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        System.out.println(checkPalindrome("aba"));
        System.out.println(checkPalindrome("abcd"));
        System.out.println(reverse("1234567"));
        IntWrapper first=new IntWrapper(1);
        IntWrapper second=new IntWrapper(2);
        swap(first,second);
        System.out.println(first.value);
        Integer num1=3;
        Integer num2=4;
        swapInteger(num1,num2);
        System.out.println(num1);
    }
}
