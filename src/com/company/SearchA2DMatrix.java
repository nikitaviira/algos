package com.company;

// https://leetcode.com/problems/search-a-2d-matrix/
public class SearchA2DMatrix {
  public static void main(String[] args) {
    System.out.println(searchMatrix(new int[][] {
      {1,3,5,7,8,9,10,11,12,13,14,15,16,17,18,19,20},
      {25,30,40,50,60,61,72,75,76,77,78,79,80,81,82,83,84},
      {251,301,401,501,601,611,721,751,761,771,781,791,801,811,821,831,841},
      {1251,1301,1401,1501,1601,1611,1721,1751,1761,1771,1781,1791,1801,1811,1821,1831,1841},
      {2251,2301,2401,2501,2601,2611,2721,2751,2761,2771,2781,2791,2801,2811,2821,2831,2841},
      {3251,3301,3401,3501,3601,3611,3721,3751,3761,3771,3781,3791,3801,3811,3821,3831,3941},
      {6251,10301,10401,10501,10601,10611,10721,10751,10761,10771,10781,10791,10801,10811,10821,10831,10941}
    }, 10941));
    // 3682
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
    for (int i = target < matrix[middle][0] ? 0 : middle; i < (target < matrix[middle][0] ? middle : matrix.length); i++) {
      if (matrix[i][0] == target || matrix[i][matrix[0].length - 1] == target
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
