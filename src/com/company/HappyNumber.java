package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Write an algorithm to determine if a number n is happy.
//A happy number is a number defined by the following process:
//Starting with any positive integer, replace the number by the sum of the squares of its digits.
//Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//Those numbers for which this process ends in 1 are happy.
//Return true if n is a happy number, and false if not.
//
//Input: n = 19
//Output: true
//Explanation:
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
//
//Input: n = 2
//Output: false
// https://leetcode.com/problems/happy-number/
public class HappyNumber {
  public static void main(String[] args) {
    System.out.println(isHappy(13));
  }

  public static boolean isHappy(int n) {
    Set<Integer> alreadyHad = new HashSet<>(List.of(n));
    int currentNum = n;

    while (true) {
      int currentSum = 0;
      for (char c : String.valueOf(currentNum).toCharArray()) {
        int square = (int) Math.pow(Character.getNumericValue(c), 2);
        currentSum += square;
      }

      if (currentSum == 1) return true;
      if (!alreadyHad.add(currentSum) || currentSum == 0) return false;
      currentNum = currentSum;
    }
  }
}
