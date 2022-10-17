package com.company;

// https://leetcode.com/problems/search-a-2d-matrix/
public class SearchA2DMatrix {
  public static void main(String[] args) {
    System.out.println(searchMatrix(new int[][] {
      {1, 3, 5, 7},
      {10, 11, 16, 20}
    }, 11));
  }

  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 1) return searchHorizontal(matrix[0], target);
    int[] row = searchVertical(matrix, target);
    if (row == null) return false;
    return searchHorizontal(row, target);
  }

  public static int[] searchVertical(int[][] matrix, int target) {
    int middle = (matrix.length - 1) / 2;
    if (target == matrix[middle][0]) return matrix[middle];
    for (int i = target < matrix[middle][0] ? 0 : middle; i < (target < matrix[middle][0] ? middle : matrix.length);
         i++) {
      if (matrix[i][0] == target
        || matrix[i][matrix[0].length - 1] == target
        || (matrix[i][0] < target && matrix[i][matrix[0].length - 1] > target)) {
        return matrix[i];
      }
    }
    return null;
  }

  public static boolean searchHorizontal(int[] nums, int target) {
    int middle = (nums.length - 1) / 2;
    if (target == nums[middle] || target == nums[nums.length - 1]) return true;
    for (int i = target < nums[middle] ? 0 : middle; i < (target < nums[middle] ? middle : nums.length); i++) {
      if (nums[i] == target) return true;
    }
    return false;
  }
}
