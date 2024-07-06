package com.datastructureandalgorithm;


import java.util.*;

public class BoundaryTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        List<Integer> ans = new ArrayList<>();
        ans = printBoundaryTraversal(root);
        System.out.println(ans);
    }

    private static List<Integer> printBoundaryTraversal(TreeNode root) {
     List<Integer> ans = new ArrayList<>();
     if(!isLeaf(root)) ans.add(root.val);
     leftBoundary(root,ans);
     leafNodes(root,ans);
     rightBoundary(root,ans);
     return ans;
    }

    private static void leafNodes(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        if(isLeaf(root)){
            ans.add(root.val);
            return;
        }
        leafNodes(root.left,ans);
        leafNodes(root.right,ans);
    }

    private static void rightBoundary(TreeNode root, List<Integer> ans) {
        TreeNode curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(!isLeaf(curr)) temp.add(curr.val);
            if(curr.right != null){
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        for(int i= temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
    }

    private static void leftBoundary(TreeNode root, List<Integer> ans) {
        TreeNode curr = root.left;
        while(curr!=null){
            if(!isLeaf(curr)) ans.add(curr.val);
            if(curr.left != null){
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private static boolean isLeaf(TreeNode root) {
        if(root.left == null &&  root.right==null) return true;
        return false;
    }
}
