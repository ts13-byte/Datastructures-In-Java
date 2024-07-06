package com.datastructureandalgorithm.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }

    private static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++) {
            if(vis[i] == 0){
                dfsTopoSort(i, vis, st, adj);
            }
        }

        int ans[] = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;

    }

    private static void dfsTopoSort(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;

        for(Integer it : adj.get(node)) {
            if(vis[it] == 0) {
                dfsTopoSort(it,vis,st,adj);
            }
        }

        st.add(node);
    }

    private static int[] bfsTopoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            for(Integer it : adj.get(i)) {
                inDegree[it] ++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<V;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        int[] topo = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int front = q.poll();
            topo[i++] = front;

            for(Integer it : adj.get(front)){
                inDegree[it] --;
                if(inDegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        return topo;
    }
}
