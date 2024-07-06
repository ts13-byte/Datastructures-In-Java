package com.datastructureandalgorithm;

import java.util.*;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class TimeTaken {

    public static BinaryTreeNode<Integer> parents(Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parent, BinaryTreeNode<Integer> root, int target) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        BinaryTreeNode<Integer> res = new BinaryTreeNode<>(-1);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> node = q.poll();

            if(root.data == target) res = root;

            if (node.left != null) {
                parent.put(node.left, node);
                q.offer(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }

    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
        Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> map = new HashMap<>();

        BinaryTreeNode<Integer> target = parents(map,root,start);

        Map<BinaryTreeNode<Integer>, Boolean> vis = new HashMap<>();
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();

        q.offer(target);
        vis.put(target, true);


        int maxi = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            int fl = 0;

            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> node = q.poll();

                if (node.left != null && !vis.containsKey(node.left)) {
                    fl = 1;
                    q.offer(node.left);
                    vis.put(node.left, true);
                }

                if (node.right != null && !vis.containsKey(node.right)) {
                    fl = 1;
                    q.offer(node.right);
                    vis.put(node.right, true);
                }

                if (map.containsKey(node) && !vis.containsKey(map.get(node))) {
                    fl = 1;
                    q.offer(map.get(node));
                    vis.put(map.get(node), true);
                }
            }

            if(fl == 1) maxi++;
        }

        return maxi;
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right=new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.right.right = new BinaryTreeNode<>(5);

        int time = timeToBurnTree(root,2);
        System.out.println("total time taken : " + time);

    }
}
