// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

// Example 1:
//
// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
// Example 2:
//
// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation:
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]
// https://leetcode.com/problems/rotate-array

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    k = k > nums.length ? k % nums.length : k;
    if (nums.length === k) {
        return;
    }

    let l = 0;
    let r = nums.length - 1;
    reverseArrayRange(nums, l, r);

    l = 0;
    r = k - 1;
    reverseArrayRange(nums, l, r);

    l = k;
    r = nums.length - 1;
    reverseArrayRange(nums, l, r);
};

function reverseArrayRange(nums, left, right) {
    while (left < right) {
        const r = nums[right];
        nums[right--] = nums[left];
        nums[left++] = r;
    }
}

rotate([1,2,3,4,5,6,7], 3)