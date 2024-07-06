package com.datastructureandalgorithm;

import java.util.*;

public class CombinationSum2 {
    public static void helper(int[] candidates, Set<List<Integer>> set, List<Integer> temp, int index, int target){
    if(index==candidates.length){
        if(target==0){
            if(!set.contains(temp)){
            set.add(new ArrayList<>(temp));
            }
        }
        return;
    }
    if(candidates[index]<=target){
        temp.add(candidates[index]);
        helper(candidates,set,temp,index+1,target-candidates[index]);
        temp.remove(temp.size()-1);

    }
    helper(candidates,set,temp,index+1,target);

}
public static List<List<Integer>> combinationSum(int[] candidates, int target) {
       Set<List<Integer>> set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        int index = 0;
        helper(candidates,set,temp,index,target);
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>> answer = combinationSum(candidates,target);
        System.out.println(answer);
    }
}
