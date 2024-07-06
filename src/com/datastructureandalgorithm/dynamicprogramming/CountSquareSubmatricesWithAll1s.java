package com.datastructureandalgorithm.dynamicprogramming;

public class CountSquareSubmatricesWithAll1s {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(countSquares(matrix));
    }

    private static int countSquares(int[][] matrix) {return 0;}
}
