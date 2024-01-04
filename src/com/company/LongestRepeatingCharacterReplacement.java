package com.company;

import java.util.HashMap;
import java.util.Map;

// You are given a string s and an integer k. You can choose any character of the string and change it to any
// other uppercase English character. You can perform this operation at most k times.
//Return the length of the longest substring containing the same letter you can get after performing the above operations.
//
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.
//
//Input: s = "AABABBA", k = 1
//Output: 4
//Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//The substring "BBBB" has the longest repeating letters, which is 4.
public class LongestRepeatingCharacterReplacement {
  public static void main(String[] args) {
    // 4
    System.out.println(characterReplacement("AAAA", 0));
  }

  public static int characterReplacement(String s, int k) {
    if (s.isEmpty()) return 0;

    Map<Character, Integer> freqMap = new HashMap<>();
    int left = 0;
    int right = 0;
    int maxLen = 0;
    int maxFreq = 0;

    while (right < s.length()) {
      freqMap.merge(s.charAt(right), 1, Integer::sum);
      // This is used to find the current biggest value in freqMap. For loop can be used instead.
      maxFreq = Math.max(freqMap.get(s.charAt(right)), maxFreq);
      // Formula: (window size - max freq char > number of substitutions)
      if (right - left + 1 - maxFreq > k) {
        if (right - left > maxLen) maxLen = right - left;
        freqMap.merge(s.charAt(left), -1, Integer::sum);
        left++;
      }

      if (right + 1 >= s.length()) break;
      right++;
    }

    return Math.max(maxLen, right - left + 1);
  }
}
