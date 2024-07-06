package com.datastructureandalgorithm;

import java.util.*;

class pair {
    int row;
    int col;
    int dist;
    pair(int row, int col ,int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
public class Matrix01 {
    int[] dx = new int[]{-1,0,1,0};
    int[] dy = new int[]{0,-1,0,1};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;


        int[][] vis = new int[n][m];
        Queue<pair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0) {
                    vis[i][j] = 1;
                    q.offer(new pair(i,j,0));
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            pair p = q.poll();
            int x = p.row;
            int y = p.col;
            int d = p.dist;
            mat[x][y] = d;

            for(int i=0;i<4;i++){
                int newX = x+dx[i];
                int newY = y+dy[i];

                if(newX >=0 && newX<n && newY>=0 && newY<m && vis[newX][newY] == 0){
                    q.offer(new pair(newX,newY,d+1));
                    vis[newX][newY] = 1;
                }
            }
        }

        return mat;

    }



    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];

        for(int i=0;i<n;i++){
            if(board[i][0] == 'O' && vis[i][0] == 0) {
                dfsTraversal(i, 0, vis, board);
            }

            if(board[i][m-1] == 'O' && vis[i][m-1]==0){
                dfsTraversal(i,m-1,vis,board);
            }
        }

        for(int i=0;i<m;i++){
            if(board[0][i] == 'O' && vis[0][i] == 0) {
                dfsTraversal(0, i, vis, board);
            }

            if(board[n-1][i] == 'O' && vis[n-1][i] == 0){
                dfsTraversal(n-1,i,vis,board);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfsTraversal(int row, int col, int[][] vis, char[][] board) {
        int n = board.length;
        int m = board[0].length;

        vis[row][col] = 1;

        for(int i=0;i<4;i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if(newRow >=0 && newRow<n && newCol>=0 && newCol<m && vis[newRow][newCol] == 0
                    && board[newRow][newCol] == 'O') {
                dfsTraversal(newRow,newCol,vis,board);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            if(grid[i][0] == 1) {
                traversalOfBoundaryCells(i, 0, grid);
            }

            if(grid[i][m-1] == 1){
                traversalOfBoundaryCells(i,m-1,grid);
            }
        }

        for(int i=0;i<m;i++){
            if(grid[0][i] == 1) {
                traversalOfBoundaryCells(0, i, grid);
            }

            if(grid[n-1][i] == 1){
                traversalOfBoundaryCells(n-1,i,grid);
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;

    }

    private void traversalOfBoundaryCells(int row, int col, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        grid[row][col] = 2;

        for(int i=0;i<4;i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if(newRow >=0 && newRow<n && newCol>=0 && newCol<m
                    && grid[newRow][newCol] == 1) {
                traversalOfBoundaryCells(newRow,newCol,grid);
            }
        }
    }

    class WordRung{
        String word;
        int len;

        WordRung(String word , int len){
            this.word = word;
            this.len = len;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<WordRung> q = new LinkedList<>();
        Set<String> st = new HashSet<>();
        for (String s : wordList) {
            st.add(s);
        }
        st.remove(beginWord);
        q.offer(new WordRung(beginWord, 1));

        int ans = 0;

        while (!q.isEmpty()) {
            WordRung wordRung = q.poll();
            String word = wordRung.word;
            int steps = wordRung.len;
            if (endWord.equals(word)) return steps;
            for (int i = 0; i < word.length(); i++) {
                for(char ch='a';ch<='z';ch++) {
                    char[] wordCharArr = word.toCharArray();
                    wordCharArr[i] = ch;
                    String replacedWord = new String(wordCharArr);
                    if(st.contains(replacedWord)) {
                        q.offer(new WordRung(replacedWord,steps+1));
                        st.remove(replacedWord);
                    }
                }
            }
        }
        return 0;
    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        for (String s : wordList) {
            st.add(s);
        }
        Queue<List<String>> q = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        q.offer(list);
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;
        List<List<String>> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            List<String> front = q.poll();
            //erase all the words that have been used on the previous levels
            if(front.size() > level) {
                level++;
                for(String it : usedOnLevel) {
                    st.remove(it);
                }
            }

            String word = front.get(front.size()-1);
            if(word.equals(endWord)){
                if(ans.size() == 0){
                    ans.add(front);
                }
                else if(ans.get(0).size() == front.size()){
                    ans.add(front);
                }
            }

            for (int i = 0; i < word.length(); i++) {
                for(char ch='a';ch<='z';ch++) {
                    char[] wordCharArr = word.toCharArray();
                    wordCharArr[i] = ch;
                    String replacedWord = new String(wordCharArr);
                    if(st.contains(replacedWord)) {
                        List<String> temp = new ArrayList<>(front);
                        temp.add(replacedWord);
                        q.offer(temp);
                        usedOnLevel.add(replacedWord);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
