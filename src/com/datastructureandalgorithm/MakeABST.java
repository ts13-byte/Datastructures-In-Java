package com.datastructureandalgorithm;

class BinarySearchTreeNode{
    int val;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;

    BinarySearchTreeNode(int val){
        this.val = val;
        left=right=null;
    }
}
public class MakeABST {
    public static BinarySearchTreeNode root = null;


    public static BinarySearchTreeNode insertRec(BinarySearchTreeNode root, int key){
        if(root == null){
            root = new BinarySearchTreeNode(key);
            return root;
        }

        if(key <= root.val){
            root.left = insertRec(root.left,key);
        }

        if(key > root.val){
            root.right = insertRec(root.right,key);
        }

        return root;
    }

    public static boolean search(BinarySearchTreeNode root ,int key){
        if(root == null) return false;
        if(root.val == key) return true;

        if( key < root.val){
            return search(root.left,key);
        }
        if(key > root.val){
            return search(root.right,key);
        }
        return false;
    }
    public static void insert(int key){
         root = insertRec(root,key);
    }
    public static void printInorder(BinarySearchTreeNode root){
        if(root == null) return;
        printInorder(root.left);
        System.out.print(root.val+" ");
        printInorder(root.right);
    }
    public static void main(String[] args) {

        insert(8);
        insert(3);
        insert(10);
        insert(1);
        insert(14);
        insert(6);
        insert(7);
        insert(7);
        insert(9);
        insert(12);
        printInorder(root);
        System.out.println( search(root ,4 ));


    }
}
