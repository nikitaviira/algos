package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum {
  public static void main(String[] args) {
    int[] nums = new int[] {3,3};
    System.out.println(Arrays.toString(twoSum(nums, 6)));
  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i]))
        return new int[] { map.get(target - nums[i]), i };
      map.put(nums[i], i);
    }
    return new int[] {};
  }
}
