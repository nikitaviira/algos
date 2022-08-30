package com.company;

//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
//
//Input: grid = [
//  ['1','1','1','1','0'],
//  ['1','1','0','1','0'],
//  ['1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
//Output: 1
//
//Input: grid = [
//  ['1','1','0','0','0'],
//  ['1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//Output: 3
// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {
  public static void main(String[] args) {
    int numIslands = numIslands(new char[][] {
      {'1', '1', '0', '1', '1'},
      {'1', '1', '0', '1', '1'},
      {'1', '0', '1', '0', '0'},
      {'1', '1', '1', '1', '1'}}
    );

    System.out.println(numIslands);
  }

  public static int numIslands(char[][] grid) {
    int result = 0;
    for (int y = 0; y < grid.length; y++) {
      for (int x = 0; x < grid[0].length; x++) {
        if (grid[y][x] == '1') {
          result++;
          removeIsland(y, x, grid);
        }
      }
    }
    return result;
  }

  public static void removeIsland(int y, int x, char[][] grid) {
    grid[y][x] = '0';
    if (y - 1 >= 0 && grid[y - 1][x] == '1') removeIsland(y - 1, x, grid);
    if (y + 1 <= grid.length - 1 && grid[y + 1][x] == '1') removeIsland(y + 1, x, grid);
    if (x - 1 >= 0 && grid[y][x - 1] == '1') removeIsland(y, x - 1, grid);
    if (x + 1 <= grid[0].length - 1 && grid[y][x + 1] == '1') removeIsland(y, x + 1, grid);
  }
}
