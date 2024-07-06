package com.datastructureandalgorithm;

import java.util.*;
class MyGraph{
    int N;
    List<List<Integer>> adj;

    MyGraph(int N){
        this.N = N;
        adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int source , int destination){
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    public void printAdjlist(){
        for(int i=0;i<adj.size();i++){
            System.out.println("For vertex : " + i);
            for(int j : adj.get(i)){
                System.out.print(" "+j);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> getAdj() {
        return adj;
    }

    public void setAdj(List<List<Integer>> adj) {
        this.adj = adj;
    }
}


public class MColoringProblem {
    public static boolean isValid(List<List<Integer>> adj , int node , int color, int[] colors){
        for(Integer it : adj.get(node)){
            if(colors[it] == color){
                return false;
            }
        }
        return true;
    }
   public static boolean graphColoring(List<List<Integer>> adj , int node , int N, int M, int[] colors ){
        if(node==N){
            return true;
        }

       for(int i=1;i<=M;i++){
           if(isValid(adj,node,i,colors)){
           colors[node] = i;
           if(graphColoring(adj,node+1,N,M,colors)==true) {return true;}
           colors[node]=0;
           }
       }
       return false;
   }
    public static void main(String[] args) {
        // constructing a graph
        //adj list representation of an undirected graph

        int[][] graph = {{0,1},{1,2},{2,3},{3,0},{0,2}};
        MyGraph myGraph = new MyGraph(4);
        for(int i=0;i<graph.length;i++){
            myGraph.addEdge(graph[i][0],graph[i][1]);
        }
        myGraph.printAdjlist();
        List<List<Integer>> adj = myGraph.getAdj();
        int M = 3;
        int N = 4;
        int[] color = new int[N];
        boolean ans = graphColoring(adj,0,N,M,color);
        System.out.println("Possible to color: " + ans);
    }
}

