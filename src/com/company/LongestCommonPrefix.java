package com.company;

// Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".
//
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
//
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.

// https://leetcode.com/problems/longest-common-prefix/?envType=study-plan&id=level-2
public class LongestCommonPrefix {
  public static void main(String[] args) {
    System.out.println(longestCommonPrefix(new String[] {"flowers", "flower", "flower"}));
  }

  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    if (strs.length == 1) return strs[0];

    var longestPreFix = new StringBuilder();
    for (var j = 0; j < strs[0].length(); j++) {
      char currentLetter = strs[0].charAt(j);
      for (var i = 1; i < strs.length; i++) {
        if (j > strs[i].length() - 1 || strs[i].charAt(j) != currentLetter) {
          return longestPreFix.toString();
        }
      }
      longestPreFix.append(currentLetter);
    }

    return longestPreFix.toString();
  }
}
