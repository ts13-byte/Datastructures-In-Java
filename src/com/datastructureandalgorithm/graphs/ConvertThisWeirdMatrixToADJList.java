package com.datastructureandalgorithm.graphs;

import java.util.*;

public class ConvertThisWeirdMatrixToADJList {
    // Function to convert adjacency list to adjacency list in Java
    public static List<List<Integer>> convertAdjacencyList(int[][] adjacencyList) {
        List<List<Integer>> graph = new ArrayList<>();

        // Add empty lists to the graph for each vertex
        for (int i = 0; i < adjacencyList.length; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the graph with adjacency information
        for (int i = 0; i < adjacencyList.length; i++) {
            for (int j = 0; j < adjacencyList[i].length; j++) {
                graph.get(i).add(adjacencyList[i][j]);
            }
        }

        return graph;
    }

    // Function to reverse the edges in the adjacency list
    public static List<List<Integer>> reverseEdges(List<List<Integer>> graph) {
        List<List<Integer>> reversedGraph = new ArrayList<>();

        // Add empty lists to the reversed graph for each vertex
        for (int i = 0; i < graph.size(); i++) {
            reversedGraph.add(new ArrayList<>());
        }

        // Iterate through the original graph and reverse the edges
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int neighbor = graph.get(i).get(j);
                reversedGraph.get(neighbor).add(i); // Reverse the edge
            }
        }

        return reversedGraph;
    }

    // Sample usage
    public static void main(String[] args) {
        int[][] adjacencyList = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        List<List<Integer>> graph = convertAdjacencyList(adjacencyList);
        List<List<Integer>> reversedGraph = reverseEdges(graph);

        // Printing the original adjacency list
        System.out.println("Original Graph:");
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Vertex " + i + " -> " + graph.get(i));
        }

        // Printing the reversed adjacency list
        System.out.println("\nReversed Graph:");
        for (int i = 0; i < reversedGraph.size(); i++) {
            System.out.println("Vertex " + i + " -> " + reversedGraph.get(i));
        }
    }
}
