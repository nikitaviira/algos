package com.company;

// Given an array of integers nums which is sorted in ascending order, and an integer target, write a function
// to search target in nums. If target exists, then return its index. Otherwise, return -1.
//You must write an algorithm with O(log n) runtime complexity.
//
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
//
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1

//https://leetcode.com/problems/binary-search/
public class BinarySearch {
  public static void main(String[] args) {
    System.out.println(search(new int[] {-1, 0, 3, 5, 9, 12}, 0));
  }

  public static int search(int[] nums, int target) {
    int middle = (nums.length - 1) / 2;
    if (target == nums[middle]) return middle;
    for (int i = target < nums[middle] ? 0 : middle; i < (target < nums[middle] ? middle : nums.length); i++) {
      if (nums[i] == target) return i;
    }
    return -1;
  }
}
