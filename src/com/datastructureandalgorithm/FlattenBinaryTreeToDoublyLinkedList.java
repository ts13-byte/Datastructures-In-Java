package com.datastructureandalgorithm;

public class FlattenBinaryTreeToDoublyLinkedList {
    public static TreeNode head,tail;
    public static void ConvertBinaryTree2DLL(TreeNode root){
        if(root == null) return;

        ConvertBinaryTree2DLL(root.left);

        if(head == null){
           head = root;
        }

        root.left = tail;

        if(tail != null){
            tail.right = root;
        }

        tail = root;

        ConvertBinaryTree2DLL(root.right);

    }

    public static void print(TreeNode head){


            while (head != null) {
                System.out.print(head.val + " ");
                head = head.right;
            }

    }

    public static void ConvertBinaryTree2DLLUtil(TreeNode root) {
        head = null;
        tail = null;
        ConvertBinaryTree2DLL(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        ConvertBinaryTree2DLLUtil(root);

        print(head);

    }
}
