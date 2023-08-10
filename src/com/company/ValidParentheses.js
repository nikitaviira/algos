// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
//
// Example 1:
// Input: s = "()"
// Output: true

// Example 2:
// Input: s = "()[]{}"
// Output: true

// Example 3:
// Input: s = "(]"
// Output: false

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let brackets = new Map([['(', ')'], ['[', ']'], ['{', '}']]);
    let stack = [];
    for (let i = 0; i < s.length; i++) {
        if (['}',']',')'].includes(s[i])) {
            let lastBracket = stack.pop();
            if (brackets.get(lastBracket) !== s[i]) {
                return false;
            }
        } else {
            stack.push(s[i]);
        }
    }

    return stack.length === 0;
};

module.exports = isValid;