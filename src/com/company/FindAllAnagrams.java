package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {
  // Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
  //
  //An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
  //
  //
  //
  //Example 1:
  //
  //Input: s = "cbaebabacd", p = "abc"
  //Output: [0,6]
  //Explanation:
  //The substring with start index = 0 is "cba", which is an anagram of "abc".
  //The substring with start index = 6 is "bac", which is an anagram of "abc".
  //
  // Example 2:
  //
  //Input: s = "abab", p = "ab"
  //Output: [0,1,2]
  //Explanation:
  //The substring with start index = 0 is "ab", which is an anagram of "ab".
  //The substring with start index = 1 is "ba", which is an anagram of "ab".
  //The substring with start index = 2 is "ab", which is an anagram of "ab".

  public static void main(String[] args) {
    // "ababababab"
    //"aab"
    // [0,2,3,4,5]
    System.out.println(findAnagrams("abebaeba", "bae"));
  }

  public static List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    Map<Character, Integer> subStr = new HashMap<>();

    // Create a map which counts every letter in the smaller substring
    for (int i = 0; i < p.length(); i++) {
      subStr.merge(p.charAt(i), 1, Integer::sum);
    }

    // pointer, which we gonna move one by one
    int pointer = 0;
    Map<Character, Integer> current = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      // add current letter to temporary map
      current.merge(s.charAt(i), 1, Integer::sum);
      // if substring is 3 letters long, on the index = 2 we can start checking for anagram
      if (i >= p.length() - 1) {
        // if temporary map is the same as the substring map, add to result
        if (current.equals(subStr)) result.add(pointer);

        Integer val = current.get(s.charAt(pointer));
        // if the current value of the letter at pointer is 1, we can remove it and move pointer by one
        if (val == 1) current.remove(s.charAt(pointer++));
        // else we just get the value and decrement it by one, while also moving the pointer by one
        else current.put(s.charAt(pointer++), val - 1);
      }
    }

    return result;
  }
}
