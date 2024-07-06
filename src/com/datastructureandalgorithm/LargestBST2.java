package com.datastructureandalgorithm;

class NodeValue{
    int size;
    int largest;
    int smallest;
    NodeValue(int size , int largest , int smallest){
        this.size = size;
        this.largest = largest;
        this.smallest = smallest;
    }
}
public class LargestBST2 {
//    public static NodeValue helper(TreeNode root){
//        if(root == null){
//            return new NodeValue(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
//        }
//
//        if(root.left == null && root.right == null){
//            return new NodeValue(1,root.val,root.val);
//        }
//
//        NodeValue left = helper(root.left);
//        NodeValue right = helper(root.right);
//
//        if(root.val > left.largest && root.val < right.smallest){
//            return new NodeValue(1+left.size+right.size,Math.min(root.val,left.smallest ),Math.max(root.val,right.largest));
//        }
//
//        return new NodeValue(Math.max(left.size,right.size),Integer.MIN_VALUE,Integer.MAX_VALUE);
//    }

    public static NodeValue helper(TreeNode root){
        if(root == null){
            return new NodeValue(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }

        if(root.left == null && root.right == null){
            return new NodeValue(1,root.val,root.val);
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        if(root.val > left.largest && root.val < right.smallest){
            return new NodeValue(1+left.size+right.size,Math.min(root.val,left.smallest ),Math.max(root.val,right.largest));
        }

        return new NodeValue(Math.max(left.size,right.size),Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static int largestBST(TreeNode root) {
        // Write your code here.
        return helper(root).size;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

       NodeValue ans = helper(root);

        System.out.println(ans.size);
    }
}
