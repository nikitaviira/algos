package com.company;

// Given a string s, partition the string into one or more substrings such that the characters in each substring are unique.
// That is, no letter appears in a single substring more than once.
// Return the minimum number of substrings in such a partition.
//
//Note that each character should belong to exactly one substring in a partition.
//
//Example 1:
//Input: s = "abacaba"
//Output: 4
//Explanation:
//Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
//It can be shown that 4 is the minimum number of substrings needed.

//Example 2:
//Input: s = "ssssss"
//Output: 6
//Explanation:
//The only valid partition is ("s","s","s","s","s","s").

import java.util.HashMap;
import java.util.Map;

public class OptimalPartitionOfString {
    public static int partitionString(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Object> chars = new HashMap<>();
        var minimumNumberSubstrings = 0;

        for (int i = 0; i < s.length(); i++) {
            if (chars.containsKey(charArray[i])) {
                minimumNumberSubstrings++;
                chars.clear();
            }
            chars.put(charArray[i], new Object());
        }

        return minimumNumberSubstrings + (!chars.isEmpty() ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println(partitionString("baefacffccab"));
    }
}
