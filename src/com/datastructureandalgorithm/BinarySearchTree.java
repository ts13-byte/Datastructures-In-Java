package com.datastructureandalgorithm;

import java.util.LinkedList;
import java.util.Queue;

class Tree{
    int val;
    Tree left;
    Tree right;

    public Tree(int val) {
        this.val = val;
        this.left=null;
        this.right=null;
    }
}
public class BinarySearchTree {
    private Tree root;

    public BinarySearchTree(){
        this.root=null;
    }

    public void insertNewNode(int val){
        root=insertNewNodeInBST(root,val);
    }


    public Tree insertNewNodeInBST(Tree current, int val){
        if(current==null){
            return new Tree(val);
        }
        if(val<= current.val){
            current.left=insertNewNodeInBST(current.left,val);
        }else if(val> current.val){
            current.right=insertNewNodeInBST(current.right,val);
        }
        return current;
    }
    public void inorder(){

        inorderRecursive(root);
        System.out.println();
    }
    public void inorderRecursive(Tree node){
        if(node==null) return;
        inorderRecursive(node.left);
        System.out.print(node.val+ " ");
        inorderRecursive(node.right);
    }
    public boolean searchInBST(int val){
        return searchRecursive(root,val);
    }
    public boolean searchRecursive(Tree current, int val){
        if(current==null) return false;

        if(val==current.val){
            return true;
        }
        else if(val< current.val){
            return searchRecursive(current.left,val);
        }
        else{
            return searchRecursive(current.right,val);
        }
    }

    public void delete(int val){
        root=deleteRecursive(root,val);
    }
    public Tree deleteRecursive(Tree current, int val){
        if(current==null){
            return null;
        }
        if(val<current.val){
            current.left=deleteRecursive(current.left,val);
        }else if(val> current.val){
            current.right=deleteRecursive(current.right,val);
        }else{
            if(current.left==null && current.right==null){
                return null;
            }
            else if(current.left==null){
                return current.right;
            }
            else if(current.right==null){
                return current.left;
            }
            else{
                int minValue=findMinValue(current.right);
                current.val=minValue;
                current.right=deleteRecursive(current.right,minValue);
            }

        }
        return current;
    }
    public int findMinValue(Tree current){
        int minValue=current.val;
        while(current.left!=null){
            minValue=current.left.val;
            current=current.left;
        }
        return minValue;
    }
    public void levelOrder() {
        if (root == null) return;

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.print("TreeNodes at level " + level + " are: ");
            while (size != 0) {
                Tree node = queue.poll();
                System.out.print(node.val + " ");

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
        BinarySearchTree bst = new BinarySearchTree();

        bst.insertNewNode(5);
        bst.insertNewNode(3);
        bst.insertNewNode(7);
        bst.insertNewNode(2);
        bst.insertNewNode(4);
        bst.insertNewNode(6);
        bst.insertNewNode(8);
        System.out.println("In-order traversal is:");
        bst.inorder();
        System.out.println();

        System.out.println("Is 6 in the BST? " + bst.searchInBST(6));
        System.out.println("Is 9 in the BST? " + bst.searchInBST(9));
        System.out.println();

        bst.levelOrder();
        System.out.println();

        bst.delete(7);
        System.out.println();

        System.out.println("In-order traversal is:");
        bst.inorder();
        System.out.println();

        bst.levelOrder();
        System.out.println();

    }
}
