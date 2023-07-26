// You are given an integer array nums. You are initially positioned at the array's first index,
// and each element in the array represents your maximum jump length at that position.
// Return true if you can reach the last index, or false otherwise.
//
// Example 1:
//
// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Example 2:
//
// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

// https://leetcode.com/problems/jump-game

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    if (nums.length === 1) {
        return true;
    }

    let steps = nums[0] - 1;
    if (steps < 0) {
        return false;
    }

    for (let i = 1; i < nums.length; i++) {
        if (nums.length - 1 === i) {
            return true;
        }

        if (steps === 0 && nums[i] === 0) {
            return false;
        }

        if (nums[i] > steps) {
            steps = nums[i];
        }

        steps--;
    }

    return true;
};

console.log(canJump([0,0,2]))