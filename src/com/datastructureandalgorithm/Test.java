package com.datastructureandalgorithm;

class Solution {
    void swap(Integer[] nums, int i, int j) {
        Integer temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(Integer[] nums, int start, int end){
        int i=start;
        int j=end;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void nextPermutation(Integer[] nums) {
        int n=nums.length;

        int index=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }

        }

        if(index==-1) {
            reverse(nums,0,n-1);
        }
        else{
            for(int i=n-1;i>index;i--){
                if(nums[i]> nums[index]){
                    swap(nums,i,index);
                    break;
                }
            }
            reverse(nums,index+1,n-1);
        }
    }
}
public class Test {
    public static void main(String[] args) {
        MergeIntervals solution=new MergeIntervals();
        Integer[] ques=new Integer[]{1,2,3};


        for(int i=0;i<3;i++){
            System.out.print(ques[i] +", ");
        }
    }
}
