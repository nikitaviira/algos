// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.
//
// Example 1:
//
// Input: nums = [3,2,3]
// Output: 3
// Example 2:
//
// Input: nums = [2,2,1,1,1,2,2]
// Output: 2
// https://leetcode.com/problems/majority-element/

/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    const k = nums.length / 2;
    const map = new Map();

    for (let i = 0; i < nums.length; i++) {
        map[nums[i]] = (map[nums[i]] ?? 0) + 1;
        if (map[nums[i]] >= k) {
            return nums[i];
        }
    }
};

console.log(majorityElement([2,2,1,1,1,2,2]))

