package com.company;

public class SearchInRotatedSortedArray {
    // There is an integer array nums sorted in ascending order (with distinct values).
    //
    // Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
    // such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
    // For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
    //
    // Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
    //
    // You must write an algorithm with O(log n) runtime complexity.

    // Input: nums = [4,5,6,7,0,1,2], target = 0
    // Output: 4

    public static void main(String[] args) {
        System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int search(int[] nums, int target) {
        var l = 0;
        var r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else  {
                if (target <= nums[r] && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
