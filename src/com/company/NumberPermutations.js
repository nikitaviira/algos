// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//
// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// Example 2:
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]

// Example 3:
// Input: nums = [1]
// Output: [[1]]

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    let answer = [];
    backtrack([], answer, nums)
    return answer;
};


function backtrack(curr, answer, nums) {
    if (curr.length === nums.length) {
        answer.push([...curr]);
        return;
    }

    for (let i = 0; i < nums.length; i++) {
        if (!curr.includes(nums[i])) {
            curr.push(nums[i]);
            backtrack(curr, answer, nums);
            curr.pop();
        }
    }
}

console.log(permute([1,2,3]))