package com.datastructureandalgorithm.graphs;

import java.io.IOException;
import java.util.*;


class Tuple{
    int v;
    int dist;
    Tuple(int v , int dist){
        this.v = v;
        this.dist = dist;
    }
}
public class ShortestPathInDirectedGraphAcyclic {
    public static void main(String[] args) throws IOException {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int res[] = shortestPathInDirectedGraph(n, m, edge);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    private static int[] shortestPathInDirectedGraph(int n, int m, int[][] edge) {
        List<List<Tuple>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++) {
            adj.get(edge[i][0]).add(new Tuple(edge[i][1],edge[i][2]));
        }

        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++) {
            if(vis[i] == 0){
                dfsTopoSort(i, vis, st, adj);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        while(!st.empty()) {
            int node = st.pop();

            for(Tuple tuple : adj.get(node)) {
                int v = tuple.v;
                int d = tuple.dist;

                if(dist[node] + d < dist[v]) {
                    dist[v] = d + dist[node];
                }

            }
        }

        return dist;
    }

    private static void dfsTopoSort(int node, int[] vis, Stack<Integer> st, List<List<Tuple>> adj) {
        vis[node] = 1;

        for(Tuple tuple : adj.get(node)) {
            int v = tuple.v;
            if(vis[v] == 0) {
                dfsTopoSort(v,vis,st,adj);
            }
        }

        st.add(node);
    }
}
