package com.datastructureandalgorithm.graphs;

import java.util.ArrayList;
import java.util.Arrays;



/*
A graph that can be coloured with exactly 2 colors where no two adjacent nodes are of same color.
any type of graph be it cyclic , acyclic or linear if it does not have the odd length cycle then it is
bipartite , we are going to use dfs algorithm for the same:
 */
public class BipartiteGraph {
    public static void main(String[] args) {
        ArrayList <ArrayList< Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = isBipartite(4, adj);
        if(ans)
            System.out.println("1");
        else System.out.println("0");
    }

    private static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Arrays.fill(vis,-1);
        for(int i=0;i<V;i++){
            if(vis[i] == -1){
                if(colorUsingDFS(i,0,vis,adj) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean colorUsingDFS(int node, int color, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = color;

        for(Integer it : adj.get(node)){
                if(vis[it] == -1) {
                    if(colorUsingDFS(it, 1 - color,vis,adj) == false) {
                        return false;
                    }
                } else if (vis[it] == color) {
                    return false;
                }

        }
        return true;
    }

}

