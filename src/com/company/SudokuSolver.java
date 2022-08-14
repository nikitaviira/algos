package com.company;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
  public static void solveSudoku(String[][] board) {
    String[][] currentAttempt = new String[][]{};
    for (var i = 0; i < 100000; i++) {
      for (var row = 0; row <= 8; row++) {
        for (var col = 0; col <= 8; col++) {
          if (board[row][col].equals(".")) {
            int insertNum = insertNum(board, col, row);
            if (insertNum != 0) {
              board[row][col] = String.valueOf(insertNum);
            }
          }
        }
      }

      currentAttempt = board;
    }
  }

  // public static boolean boardIsFilled(String[][] board) {
  //   if ()
  // }

  public static int insertNum(String[][] board, int col, int row) {
    Set<Integer> nums = new HashSet<>();

    for (int x = 0; x <= 8; x++) {
      if (!board[row][x].equals(".")) {
        nums.add(Integer.valueOf(board[row][x]));
      }
    }

    for (int x = 0; x <= 8; x++) {
      if (!board[x][col].equals(".")) {
        nums.add(Integer.valueOf(board[x][col]));
      }
    }

    int startRow = row - row % 3;
    int startCol = col - col % 3;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (!board[i + startRow][j + startCol].equals(".")) {
          nums.add(Integer.valueOf(board[i + startRow][j + startCol]));
        }
      }
    }

    if (nums.size() != 8) {
      return 0;
    }

    for (int x = 1; x <= 9; x++) {
      if (!nums.contains(x)) {
        return x;
      }
    }

    return 0;
  }
}
