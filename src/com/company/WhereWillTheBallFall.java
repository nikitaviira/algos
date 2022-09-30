package com.company;

// You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.
//
//Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.
//
//A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.
//A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.
//We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom.
// A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.
//
//Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping
// the ball from the ith column at the top, or -1 if the ball gets stuck in the box.

import java.util.Arrays;
import java.util.stream.Collectors;

// https://leetcode.com/problems/where-will-the-ball-fall/
public class WhereWillTheBallFall {
  public static void main(String[] args) {
    int[] ball = findBall(new int[][] {
      {-1}
    });

    System.out.println(Arrays.stream(ball).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }

  public static int[] findBall(int[][] grid) {
    int[] result = new int[grid[0].length];
    for (int x = 0; x < grid[0].length; x++) {
      result[x] = position(0, x, grid);
    }
    return result;
  }

  public static int position(int y, int x, int[][] grid) {
    if (grid.length == y) return x;
    if (grid[y][x] == -1) {
      return x == 0 || grid[y][x - 1] == 1 ? -1 : position(y + 1, x - 1, grid);
    } else {
      return x == grid[0].length - 1 || grid[y][x + 1] == -1 ? -1 : position(y + 1, x + 1, grid);
    }
  }
}
