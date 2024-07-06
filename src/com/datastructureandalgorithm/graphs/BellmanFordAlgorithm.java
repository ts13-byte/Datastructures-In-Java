package com.datastructureandalgorithm.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };



        int[] dist = bellman_ford(V, edges, S);
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println("");

    }

    private static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int src) {
        int[] dist = new int[V];

        for(int i=0;i<V;i++){
          dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;
        //relax all the edges n-1 times
        for(int i=0;i<V-1;i++){
            for(List<Integer> it : edges){
                int u = it.get(0);
                int v = it.get(1);
                int d = it.get(2);
                if(dist[u] != Integer.MAX_VALUE && dist[u] + d < dist[v]) {
                    dist[v] = dist[u] + d;
                }
            }
        }

        // to find if -ve cycle exists again do a traversal
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;
    }
}
