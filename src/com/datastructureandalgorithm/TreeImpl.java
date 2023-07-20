package com.datastructureandalgorithm;

import com.sun.source.tree.Tree;

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left=null;
        this.right=null;
    }
}
public class TreeImpl {
    private TreeNode root;

    public TreeImpl() {
        this.root = null;
    }
    public void insert(int val){
       if(root==null){
           root=new TreeNode(val);
       }
       else{
           insertRecursive(root,val);
       }
    }
    public void insertRecursive(TreeNode current, int val){
        if(current.left==null){
            current.left=new TreeNode(val);
            return;
        }else if(current.right==null){
            current.right=new TreeNode(val);
            return;
        }else{
            insertRecursive(current.left,val);
        }
    }

    public void inorder(){
        inorderRecursive(root);
    }
    public void inorderRecursive(TreeNode node){
        if(node==null) return;
        inorderRecursive(node.left);
        System.out.println(node.val+ " ");
        inorderRecursive(node.right);
    }

    public void levelOrder(){
        if(root==null) return;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level=1;

        while(!queue.isEmpty()){
            int size= queue.size();
            System.out.print("TreeNodes at level "+level+" are: ");
            while(size!=0) {
                TreeNode node = queue.poll();
                System.out.print(node.val+ " ");

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeImpl tree=new TreeImpl();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.inorder();
        tree.levelOrder();

    }
}
