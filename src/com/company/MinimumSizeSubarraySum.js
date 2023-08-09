/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(target, nums) {
    let currentSum = 0;
    let left = 0;
    let right = 0;
    let minLen = 0;

    while (right <= nums.length) {
        if (currentSum >= target) {
            let distance = right - left;
            if (minLen === 0 || distance < minLen) {
                minLen = distance;
            }
            currentSum -= nums[left++];
        } else {
            currentSum += nums[right++];
        }
    }

    return minLen;
};

module.exports = minSubArrayLen;