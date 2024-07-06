package com.datastructureandalgorithm;

import java.util.*;
class Tuple {
    TreeNode node;
    int row;
    int col;

    Tuple(TreeNode node , int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Pair{
    TreeNode node;
    int hd;

    Pair(TreeNode node,int val){
       this.hd = val;
       this.node = node;
    }
}

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List < List < Integer >> list = new ArrayList< >();
        list = findVertical(root);
        System.out.println(list);

        List<Integer> topView = findTopView(root);
        System.out.println(topView);

        List<Integer> bottomView = findBottomView(root);
        System.out.println(bottomView);

    }

    private static List<Integer> findTopView(TreeNode root){
    List<Integer> list = new ArrayList<>();
    if(root == null) return list;
    Queue<Pair> q = new LinkedList<>();
    q.offer(new Pair(root,0));
    TreeMap<Integer,Integer> map = new TreeMap<>();
    while (!q.isEmpty()){
        Pair pair = q.poll();
        TreeNode node = pair.node;
        int hd = pair.hd;

        if(map.get(hd) == null){
            map.put(hd,node.val);
        }

        if(node.left != null){
            q.offer(new Pair(node.left,hd-1));
        }
        if(node.right != null){
            q.offer(new Pair(node.right,hd+1));
        }
    }
    for(Integer val : map.values()){
        list.add(val);
    }
    return list;
    }

    private static List<Integer> findBottomView(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        TreeMap<Integer,Integer> map = new TreeMap<>();

        while (!q.isEmpty()){
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int hd = pair.hd;


            map.put(hd,node.val);


            if(node.left != null){
                q.offer(new Pair(node.left,hd-1));
            }
            if(node.right != null){
                q.offer(new Pair(node.right,hd+1));
            }
        }
        for(Integer val : map.values()){
            list.add(val);
        }
        return list;
    }



    private static List<List<Integer>> findVertical(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }

            map.get(x).get(y).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left,x-1,y+1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right,x+1,y+1));
            }
        }

        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
            list.add(new ArrayList < > ());
            for (PriorityQueue < Integer > nodes: ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}
