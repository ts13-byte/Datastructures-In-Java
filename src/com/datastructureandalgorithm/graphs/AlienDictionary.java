package com.datastructureandalgorithm.graphs;

import java.sql.Array;
import java.util.ArrayList;
import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        String ans = findOrder(dict, N, K);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }

    private static String findOrder(String[] dict, int N, int k) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<k;i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(),s2.length());
            for(int ptr = 0 ; ptr<len ; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topoSort = findTopoSort(adj,k);
        String ans = "";
        for(Integer it : topoSort) {
            ans += (char)(it + (int)'a');
        }

        return ans;
    }

    private static List<Integer> findTopoSort(List<List<Integer>> adj, int V) {
        List<Integer> topo = new ArrayList<>();
        int[] indegree = new int[V];

        for(int i=0;i<V;i++){
            for(Integer it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        return topo;
    }
}
