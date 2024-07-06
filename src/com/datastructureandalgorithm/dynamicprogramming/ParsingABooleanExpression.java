package com.datastructureandalgorithm.dynamicprogramming;

// simple traversal using recursion
public class ParsingABooleanExpression {
    //"!(&(f,t))"
    public static boolean helper(int[] arr , String expression ){
        // skip all the '(' brackets
        if(expression.charAt(arr[0]) == 'f') {
            arr[0]++;
            return false;
        } else if(expression.charAt(arr[0]) == '!') {
            // get the resultant value of the next operation and negate the value of that
            arr[0] += 2;
            boolean res = helper(arr,expression);
            arr[0] ++;
            return !res;
        } else if(expression.charAt(arr[0]) == '|') {
            boolean res = false;
            arr[0] += 2;
            while(expression.charAt(arr[0]) != ')') {
                if(expression.charAt(arr[0]) == ','){
                    arr[0]++;
                } else{
                    boolean temp = helper(arr,expression);
                    res = res | temp;
                }
            }
            arr[0]++;
            return res;
        } else if(expression.charAt(arr[0]) == '&') {
            // calculate result of all the comma separated values inside parentheses
            // after parentheses has ended come out of that nested parentheses
            boolean res = true;
            arr[0] += 2;
            while(expression.charAt(arr[0]) != ')') {
                if(expression.charAt(arr[0]) == ','){
                    arr[0]++;
                } else{
                    boolean temp = helper(arr,expression);
                    res = res & temp;
                }
            }
            arr[0]++;
            return res;
        }
        // if the single character is true move to the next index and return true
        arr[0]++;
        return true;
    }
    public static boolean parseBoolExpr(String expression) {
        int[] arr = new int[1];
        arr[0] = 0;
        return helper(arr,expression);
    }
    public static void main(String[] args) {
        parseBoolExpr("!(&(f,t))");
    }
}
