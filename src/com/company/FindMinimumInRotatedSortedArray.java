package com.company;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[] { 4,5,6,7,0,1,2 }));
    }

    // Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
    //
    // [4,5,6,7,0,1,2] if it was rotated 4 times.
    // [0,1,2,4,5,6,7] if it was rotated 7 times.
    // Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
    //
    // Given the sorted rotated array nums of unique elements, return the minimum element of this array.
    // You must write an algorithm that runs in O(log n) time.
    //
    // Example 1:
    // Input: nums = [3,4,5,1,2]
    // Output: 1
    // Explanation: The original array was [1,2,3,4,5] rotated 3 times.
    public static int findMin(int[] nums) {
        var l = 0;
        var r = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[l] <= nums[mid]) {
                if (min > nums[l]) {
                    min = nums[l];
                }
                l = mid + 1;
            } else  {
                if (min > nums[mid]) {
                    min = nums[mid];
                }
                r = mid - 1;
            }
        }

        return min;
    }
}
