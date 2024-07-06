package com.datastructureandalgorithm.graphs;

import java.util.*;

class Pair{
    int currNode;
    int parent;
    Pair(int currNode , int parent){
        this.currNode = currNode;
        this.parent = parent;
    }
}
public class DetectCycleInAGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = isCycleBFS(4, adj);
        boolean ans1 = isCycleDFS(4,adj);
        if (ans1)
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static boolean isCycleDFS(int V , ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[4];
        for(int i=0;i<V;i++) {
            if(vis[i] == false){
                if(checkForCycleDFS(vis,adj,i,-1)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkForCycleDFS(boolean[] vis, ArrayList<ArrayList<Integer>> adj, int curr, int parent) {
        vis[curr] = true;
        for(Integer it : adj.get(curr)){
            if(vis[it] == false){
                if(checkForCycleDFS(vis,adj,it,curr)){
                    return true;
                }
            }
            else if(it != parent){
                return true;
            }
        }
        return false;
    }

    private static boolean isCycleBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[4];
        for(int i=0 ; i<V ; i++){
         if(vis[i] == false) {
             if(checkForCycleBFS(i,adj,vis)){
                 return true;
             }
         }
        }
        return false;
    }

    private static boolean checkForCycleBFS(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src,-1));
        vis[src] = true;
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int curr = pair.currNode;
            int parent = pair.parent;

            for(Integer it : adj.get(curr)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.offer(new Pair(it,curr));
                }
                else if(it != parent){
                    return true;
                }
            }
        }
        return false;
    }
}
