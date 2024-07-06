package com.datastructureandalgorithm;

import java.util.*;

public class RootToLeafPath {
    static boolean getPath(TreeNode root, List<Integer> ans, int target){
       if(root == null) return false;

       ans.add(root.val);

       if(root.val == target){
           return true;
       }

       if(getPath(root.left,ans,target) || getPath(root.right,ans,target)){
           return true;
       }

       ans.remove(ans.size()-1);

       return false;

    }
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);
        getPath(root,ans,7);
        System.out.println(ans);
    }


}

