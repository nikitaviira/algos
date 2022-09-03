package com.company;

// Given an m x n matrix, return all elements of the matrix in spiral order.

//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]

//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
  public static void main(String[] args) {
    System.out.println(spiralOrder(new int[][] {
      {1},
      {2},
      {3},
      {4}
    }));
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    doSpin(matrix, 0, result);
    return result;
  }

  public static void doSpin(int[][] matrix, int depth, List<Integer> result) {
    int currentDepth = depth;
    int rowLen = matrix[0].length - depth * 2;
    int colLen = matrix.length - depth * 2;

    if (colLen == 1) {
      for (int x = depth; x < rowLen + depth; x++) {
        result.add(matrix[depth][x]);
      }
      return;
    }

    if (rowLen == 1) {
      for (int y = depth; y < matrix.length - depth; y++) {
        result.add(matrix[y][rowLen - 1 + depth]);
      }
      return;
    }

    // 1st row
    if (rowLen > 1) {
      for (int x = depth; x < rowLen + depth; x++) {
        result.add(matrix[depth][x]);
      }
    }

    // last column
    if (colLen > 2) {
      for (int y = 1 + depth; y < matrix.length - 1 - depth; y++) {
        result.add(matrix[y][rowLen - 1 + depth]);
      }
    }

    // last row backwards
    if (rowLen > 1) {
      for (int x = rowLen - 1 + depth; x >= depth; x--) {
        result.add(matrix[matrix.length - 1 - depth][x]);
      }
    }

    // 1st column backwards
    if (colLen > 2) {
      for (int y = matrix.length - 2 - depth; y >= 1 + depth; y--) {
        result.add(matrix[y][depth]);
      }
      if (matrix[0].length * matrix.length == result.size()) return;
      depth++;
    }

    if (depth > currentDepth) {
      doSpin(matrix, depth, result);
    }
  }
}
