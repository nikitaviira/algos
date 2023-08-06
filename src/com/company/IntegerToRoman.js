// https://leetcode.com/problems/integer-to-roman

/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    return 'M'.repeat(num / 1000) +
        toRoman(Math.trunc((num % 1000) / 100), ['C', 'CD', 'D', 'CM']) +
        toRoman(Math.trunc(((num % 1000) % 100) / 10), ['X', 'XL', 'L', 'XC']) +
        toRoman(num % 10, ['I', 'IV', 'V', 'IX']);
};

function toRoman(num, romanNums) {
    if (num === 4) {
        return romanNums[1]
    } else if (num === 9) {
        return romanNums[3]
    }
    return num >= 5 ? romanNums[2] + romanNums[0].repeat(num - 5) : romanNums[0].repeat(num);
}

console.log(intToRoman(1994))