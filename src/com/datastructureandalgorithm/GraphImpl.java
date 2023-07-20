package com.datastructureandalgorithm;

import java.util.*;


class Graph{
   private int numVertices;
   private Map<Integer, List<Integer>> adj;


    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adj=new HashMap<>();
        for(int i=0;i<numVertices;i++){
            adj.put(i,new ArrayList<>());
        }
    }
    public void addEdge(int u, int v){
        if(u<numVertices && v<numVertices) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

    }
    public void dfs(int startVertex){
        boolean vis[]=new boolean[numVertices];
        dfsHelper(startVertex,vis);
    }
    public void dfsHelper(int node, boolean[] vis){
        vis[node]=true;
        System.out.println(node+" ");
        List<Integer> neighbours=adj.get(node);
        for(int neighbour:neighbours){
            if(!vis[neighbour]){
                dfsHelper(neighbour,vis);
            }
        }
    }
    public void printAdjList(){
        for(int i=0;i<numVertices;i++){
            System.out.print(i+ "->");
            List<Integer> adjList=adj.get(i);
            adjList.forEach(node-> System.out.print(node+ " "));
            System.out.println();
        }
    }
    public void bfs(int node){
        boolean[] vis=new boolean[numVertices];
        Queue<Integer> queue=new LinkedList<>();

        vis[node]=true;
        queue.add(node);
        while(!queue.isEmpty()){
            int vertex= queue.poll();
            System.out.println(vertex+ " ");

            for(int neighbour:adj.get(vertex)){
                if(!vis[neighbour]){
                    vis[neighbour]=true;
                    queue.add(neighbour);
                }
            }

        }
    }
    public void addVertex(){
        this.numVertices++;
        adj.put(numVertices-1,new ArrayList<>());
    }
}
public class GraphImpl {

    public static void main(String[] args) {
        Graph graph=new Graph(5);

    graph.addEdge(0, 1);
    graph.addEdge(0, 4);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.printAdjList();

    graph.dfs(0);
    graph.bfs(0);
    }
}
