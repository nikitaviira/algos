package com.company;

// Given a string s, find the length of the longest substring without repeating characters.
//
//
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubWithoutRepeatingChars {
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("dvdf"));
  }

  public static int lengthOfLongestSubstring(String s) {
    if (s.length() <= 1) return s.length();

    Set<Character> set = new HashSet<>();
    int max = 0;
    int leftPointer = 0;
    int right = 0;

    while (right < s.length()) {
      if (!set.contains(s.charAt(right))) {
        set.add(s.charAt(right++));
        max = Math.max(set.size(), max);
      }
      else set.remove(s.charAt(leftPointer++));
    }

    return Math.max(set.size(), max);
  }
}
