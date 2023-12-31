package com.company;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{ 0,3,7,2,5,8,4,6,0,1 }));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> a = new HashSet<>();
        int longest = 0;
        int current = 0;

        for (int num : nums) {
            a.add(num);
        }

        int counter = 0;
        for (int num : nums) {
            while (a.contains(num + counter)) {
                a.remove(num + counter++);
                current++;
            }

            counter = 1;

            while (a.contains(num - counter)) {
                a.remove(num - counter++);
                current++;
            }

            longest = Math.max(longest, current);
            current = counter = 0;
        }

        return longest;
    }
}
