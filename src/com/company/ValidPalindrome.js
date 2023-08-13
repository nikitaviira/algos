// Example 1:
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.

// Example 2:
// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.

// Example 3:
// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.

// https://leetcode.com/problems/valid-palindrome/

/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    let escapedStr = s.toLowerCase().replaceAll(/[^A-Za-z0-9]/g, '');
    let l = 0;
    let r = escapedStr.length - 1;

    while (l <= r) {
        if (escapedStr[l] !== escapedStr[r]) return false;
        l++;
        r--;
    }

    return true;
};

console.log(isPalindrome('    '));