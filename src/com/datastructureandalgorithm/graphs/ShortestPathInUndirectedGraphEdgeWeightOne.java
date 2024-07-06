package com.datastructureandalgorithm.graphs;

import java.io.IOException;
import java.util.*;

public class ShortestPathInUndirectedGraphEdgeWeightOne {
    public static void main(String[] args) throws IOException {
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};

       
        int res[] = shortestPath(edge,n,m,0);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

    private static int[] shortestPath(int[][] edge, int n, int m, int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        int[] vis = new int[n];
        vis[src] = 1;

        while(!q.isEmpty()) {
            int node = q.poll();
            for(Integer it : adj.get(node)) {
                if(vis[it] == 0) {
                    if(dist[node] + 1 < dist[it]) {
                        dist[it] = dist[node] + 1;
                        q.add(it);
                    }
                }
            }
        }

        return dist;
    }
}
