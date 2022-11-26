package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/3sum/
public class ThreeSum {
  public static void main(String[] args) {
    System.out.println(threeSum(new int[] {-1, 0, -1, -1, 2, 3, 4, 5, 5, 5, 4, 0}));
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> result = new HashSet<>();
    Arrays.sort(nums);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) map.put(nums[i], i);

    for (int i = 0; i != nums.length - 2; ) {
      for (int j = i + 1; j < nums.length; ) {
        int target = nums[i] * -1;
        if (target - nums[j] < nums[j]) break;

        if (map.containsKey(target - nums[j]) && map.get(target - nums[j]) > j) {
          result.add(List.of(nums[i], target - nums[j], nums[j]));
        }

        j++;
        while (j < nums.length && nums[j] == nums[j - 1]) j++;
      }
      i++;
      while (i < nums.length - 2 && nums[i] == nums[i - 1]) i++;
    }

    return new ArrayList<>(result);
  }
}
