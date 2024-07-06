package com.datastructureandalgorithm.graphs;
//given n nodes and m edges construct a graph : m lines given that will represent the m edges

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphRepresentation {
    public static void constructingAdjMatrix(){
        // Read number of vertices and edges
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your vertices : ");
        int n = scanner.nextInt();
        System.out.println("please enter your edges : ");
        int m = scanner.nextInt();
        int[][] graph = new int[n+1][n+1];

        for(int i=0 ; i<m; i++) {
            System.out.println("Please enter next first vertex value : ");
            int u = scanner.nextInt();
            System.out.println("Please enter second vertex value : ");
            int v = scanner.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        System.out.println("Your graph is ready : ");

        for(int i=0 ; i<=n ; i++) {
            for(int j=0 ; j<=n ; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void constructingAdjList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your vertices : ");
        int n = scanner.nextInt();
        System.out.println("please enter your edges : ");
        int m = scanner.nextInt();
        List<Integer>[] adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>(); // Initialize each list
        }
        for(int i=0 ; i<m; i++) {
            System.out.println("Please enter next first vertex value : ");
            int u = scanner.nextInt();
            System.out.println("Please enter second vertex value : ");
            int v = scanner.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        System.out.println("here is your adjacency list : ");
        for(int i=0;i<=n;i++) {
            System.out.print("vertex " + i+ " : -> ");
            for(int j=0;j<adj[i].size();j++){
                System.out.print(adj[i].get(j)+", ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        constructingAdjList();
    }
}
