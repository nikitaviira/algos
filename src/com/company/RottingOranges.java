package com.company;

import java.util.LinkedList;
import java.util.Queue;

// You are given an m x n grid where each cell can have one of three values:
//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
//
//Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
//
//Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
//Output: -1
//Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
//
//Input: grid = [[0,2]]
//Output: 0
//Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
// https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
  public static void main(String[] args) {
    int orangesRotting = orangesRotting(new int[][] {
      {0}}
    );

    System.out.println(orangesRotting);
  }

  public static int orangesRotting(int[][] grid) {
    Queue<int[]> rottenOranges = new LinkedList();
    int minutes = 0;

    // Find all rotten oranges
    for (int y = 0; y < grid.length; y++) {
      for (int x = 0; x < grid[0].length; x++) {
        if (grid[y][x] == 2) rottenOranges.add(new int[] {y, x});
      }
    }

    // Breadth-first search (queue, while not empty, node levels)
    while (!rottenOranges.isEmpty()) {
      int size = rottenOranges.size();
      for (int i = 0; i < size; i++) {
        int[] temp = rottenOranges.poll();
        if (temp[0] - 1 >= 0 && grid[temp[0] - 1][temp[1]] == 1) {
          grid[temp[0] - 1][temp[1]] = 2;
          rottenOranges.add(new int[]{temp[0] - 1, temp[1]});
        }
        if (temp[0] + 1 <= grid.length - 1 && grid[temp[0] + 1][temp[1]] == 1) {
          grid[temp[0] + 1][temp[1]] = 2;
          rottenOranges.add(new int[]{temp[0] + 1, temp[1]});
        }
        if (temp[1] - 1 >= 0 && grid[temp[0]][temp[1] - 1] == 1) {
          grid[temp[0]][temp[1] - 1] = 2;
          rottenOranges.add(new int[]{temp[0], temp[1] - 1});
        }
        if (temp[1] + 1 <= grid[0].length - 1 && grid[temp[0]][temp[1] + 1] == 1) {
          grid[temp[0]][temp[1] + 1] = 2;
          rottenOranges.add(new int[]{temp[0], temp[1] + 1});
        }
      }
      if (!rottenOranges.isEmpty()) minutes++;
    }

    // Check if any non-rotten oranges are left after full traversal of the queue
    for (int[] ints : grid) {
      for (int x = 0; x < grid[0].length; x++) {
        if (ints[x] == 1) return -1;
      }
    }

    return minutes;
  }
}
