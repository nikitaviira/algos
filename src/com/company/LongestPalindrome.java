package com.company;

// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that
// can be built with those letters.
// Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
//
//Input: s = "abccccdd"
//Output: 7
//Explanation: One longest palindrome that can be built is "dccbbbccd", whose length is 7.
//Example 2:
//
//Input: s = "a"
//Output: 1
//Explanation: The longest palindrome that can be built is "a", whose length is 1.

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-palindrome/
public class LongestPalindrome {
  public static void main(String[] args) {
    System.out.println(longestPalindrome("bb"));
  }

  public static int longestPalindrome(String s) {
    Map<Character, Integer> count = new HashMap<>();
    for (char c : s.toCharArray()) {
      count.merge(c, 1, Integer::sum);
    }

    int sum = 0;
    boolean hasUneven = false;
    for (int entry : count.values()) {
      if (entry % 2 == 0 && !hasUneven) hasUneven = true;
      sum += entry % 2 == 0 ? entry : entry - 1;
    }

    return sum + (hasUneven ? 1 : 0);
  }
}
