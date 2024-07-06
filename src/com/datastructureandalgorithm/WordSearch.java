package com.datastructureandalgorithm;

public class WordSearch {



    public static void main(String[] args) {
        int rows = 3;
        int cols = 4;

        // Create a 2D array without explicitly initializing elements
        int[][] array = new int[rows][cols];

        // Print the 2D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}
