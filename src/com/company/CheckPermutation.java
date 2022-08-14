package com.company;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/permutation-in-string/
// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//
//In other words, return true if one of s1's permutations is the substring of s2.
//
//
//
//Example 1:
//
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
//Example 2:
//
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
public class CheckPermutation {
  public static void main(String[] args) {
    System.out.println(checkInclusion("ab", "eidboaoo"));
  }

  public static boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> subStr = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      subStr.merge(s1.charAt(i), 1, Integer::sum);
    }

    int pointer = 0;
    Map<Character, Integer> current = new HashMap<>();
    for (int i = 0; i < s2.length(); i++) {
      current.merge(s2.charAt(i), 1, Integer::sum);
      if (i >= s1.length() - 1) {
        if (current.equals(subStr)) return true;

        Integer val = current.get(s2.charAt(pointer));
        if (val == 1) current.remove(s2.charAt(pointer++));
        else current.put(s2.charAt(pointer++), val - 1);
      }
    }

    return false;
  }
}
