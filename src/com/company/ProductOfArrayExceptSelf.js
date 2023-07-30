// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.
//
// Example 1:
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

// Example 2:
// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

// https://leetcode.com/problems/product-of-array-except-self

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    if (nums.length <= 1) {
        return nums;
    }

    let prefixProduct = new Array(nums.length);
    let suffixProduct = new Array(nums.length);

    prefixProduct[0] = nums[0];
    suffixProduct[nums.length - 1] = nums[nums.length - 1];

    for (let i = 1; i < nums.length; i++) {
        prefixProduct[i] = nums[i] * prefixProduct[i - 1];
    }

    for (let i = nums.length - 2; i >= 0; i--) {
        suffixProduct[i] = nums[i] * suffixProduct[i + 1];
    }

    let answer = new Array(nums.length);
    answer.push(suffixProduct[1]);

    for (let i = 1; i < nums.length; i++) {
        answer.push(i === nums.length - 1 ? prefixProduct[i - 1] : suffixProduct[i + 1] * prefixProduct[i - 1]);
    }

    return answer;
};

console.log(productExceptSelf([2,2,2]))