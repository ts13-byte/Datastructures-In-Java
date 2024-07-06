package com.datastructureandalgorithm;

import java.util.*;

public class SerializeAndDeserializeTree {
    public static String serialize(TreeNode root){
        if(root == null) return "";

        String ans = "";
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node == null) {
                ans = ans + '#'+',';
                continue;
            }

           ans = ans + node.val + ',';

            q.offer(node.left);
            q.offer(node.right);
        }

        return ans.substring(0,ans.length()-1);
    }

    public static TreeNode deserialize(String s){

        if(s.isEmpty()) return null;

        Queue<TreeNode> q = new LinkedList<>();

        String[] values = s.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);

       for(int i=1;i< values.length;i++){
           TreeNode node = q.poll();

           if(!values[i].equals("#")){
               node.left = new TreeNode(Integer.parseInt(values[i]));
               q.offer(node.left);
           }

           i++;

           if(!values[i].equals("#")){
               node.right = new TreeNode(Integer.parseInt(values[i]));
               q.offer(node.right);
           }

       }

        return root;

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String ans = serialize(root);



    }

}
