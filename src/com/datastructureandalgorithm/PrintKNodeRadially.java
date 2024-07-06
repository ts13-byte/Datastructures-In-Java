package com.datastructureandalgorithm;

import java.util.*;

public class PrintKNodeRadially {
    public static void findParents(Map<TreeNode,TreeNode> map , TreeNode root){


        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){

            TreeNode node = q.poll();

            if(node.left!=null) {
                map.put(node.left , node);
                q.offer(node.left);
            }

            if(node.right != null){
                map.put(node.right, node);
                q.offer(node.right);
            }

        }

    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        findParents(map,root);
        Map<TreeNode,Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);

        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            if(level++ == k) {
                break;
            }

            for(int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                if(map.containsKey(node) && !vis.containsKey(map.get(node))){
                    q.offer(map.get(node));
                    vis.put(map.get(node), true);
                }

                if(node.left != null && !vis.containsKey(node.left)) {
                    q.offer(node.left);
                    vis.put(node.left,true);
                }

                if(node.right != null && !vis.containsKey(node.right)){
                    q.offer(node.right);
                    vis.put(node.right,true);
                }

            }

        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            ans.add(node.val);
        }

        return ans;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        int k = 2;
        TreeNode target = root.left;
        List<Integer> result = distanceK(root, target, k);
        System.out.println(result);

    }
}
