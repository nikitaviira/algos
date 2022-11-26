package com.company;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticTriplets {
  public static void main(String[] args) {
    int[] nums = new int[] { 0,1,4,6,7,10,12,15,16,17,20,23 };
    System.out.println(arithmeticTriplets(nums, 3));
  }

  public static int arithmeticTriplets(int[] nums, int diff) {
    int counter = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i] - diff) && map.containsKey(nums[i] - diff * 2)) {
        counter++;
      }
      map.put(nums[i], i);
    }

    return counter;
  }
}
