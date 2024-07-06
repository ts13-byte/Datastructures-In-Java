package com.datastructureandalgorithm.graphs;


import java.util.*;

public class GraphTraversal {
    public static ArrayList<Integer> DFS(int V , ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        dfsRec(vis,0,adj,ans);
        return ans;
    }

    private static void dfsRec(boolean[] vis, int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {

        vis[node] = true;
        ans.add(node);

        for(Integer it : adj.get(node)) {
            if(vis[it] == false){
                dfsRec(vis,it,adj,ans);
            }
        }
    }

    public static ArrayList<Integer> BFS(int V , ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int[] vis = new int[5];

        while(!q.isEmpty()){
            Integer vertex = q.poll();
            vis[vertex] = 1;
            ans.add(vertex);

            for(Integer it : adj.get(vertex)) {
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.add(it);
                }
            }
        }

        return ans;
    }

    // this is zero based ---> O(V+E)
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        ArrayList < Integer > ans = DFS(5,adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
}
