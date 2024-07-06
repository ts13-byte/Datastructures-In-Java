package com.datastructureandalgorithm.graphs;

import java.util.*;

class Edge{
    int dist;
    int v;
    Edge(int dist,int v) {
        this.v = v;
        this.dist = dist;
    }
}



public class DjikstraUsingPQ {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 5},
                {0, 2, 8},
                {1, 2, 9},
                {1, 3, 2},
                {2, 3, 6}
        };
        int vertices = 4; // Number of vertices

        List<List<Edge>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Adding edges to the adjacency list (undirected graph)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adjacencyList.get(u).add(new Edge(weight,v));
            adjacencyList.get(v).add(new Edge(weight,u)); // For undirected graph
        }

        int[] ans = applyDjikstra(vertices,adjacencyList,0);
        List<Integer> path = printTheShortestPathFromSrcTODest(vertices,adjacencyList,0,3);

        for(Integer it : ans) {
            System.out.print(it+" ");
        }

        System.out.println(path);

    }

    private static int[] applyDjikstra(int V, List<List<Edge>> adjacencyList,int src) {

        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Edge> minHeap = new PriorityQueue<Edge>((x,y) -> x.dist - y.dist);
        minHeap.add(new Edge(0,0));

        while(!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int dis = edge.dist;
            int u = edge.v;

            for(Edge adjEdge : adjacencyList.get(u)) {
                int edgeWeight = adjEdge.dist;
                int v = adjEdge.v;

                if(dis+edgeWeight<dist[v]){
                  dist[v] = dis+edgeWeight;
                  minHeap.add(new Edge(dist[v],v));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
    //0-->3
    public static List<Integer> printTheShortestPathFromSrcTODest(int V, List<List<Edge>> adjacencyList,int src,int dest) {
        int[] parent = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = i;
        }
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Edge> minHeap = new PriorityQueue<Edge>((x,y) -> x.dist - y.dist);
        minHeap.add(new Edge(0,0));

        while(!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int dis = edge.dist;
            int u = edge.v;

            for(Edge adjEdge : adjacencyList.get(u)) {
                int edgeWeight = adjEdge.dist;
                int v = adjEdge.v;

                if(dis+edgeWeight<dist[v]){
                    parent[v] = u;
                    dist[v] = dis+edgeWeight;
                    minHeap.add(new Edge(dist[v],v));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        List<Integer> ans = new ArrayList<>();
        if(dist[dest] == -1) {
            ans.add(-1);
            return ans;
        }

        int node = dest;

        while(parent[node] != node) {
            ans.add(node);
            node = parent[node];
        }

        ans.add(src);
        Collections.reverse(ans);

        return ans;

    }
}
