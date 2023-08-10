// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
// Example 1:
// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"

// Example 2:
// Input: s = "God Ding"
// Output: "doG gniD"

/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let currentWord = '';
    let answer = '';

    for (let i = s.length - 1; i >= 0; i--) {
        if (s[i] !== ' ') {
            currentWord += s[i];
            if (i > 0) continue;
        }
        if (currentWord.length > 0) {
            answer = currentWord + (answer.length > 0 ? ' ' + answer : answer);
            currentWord = '';
        }
    }

    return answer;
};

module.exports = reverseWords;