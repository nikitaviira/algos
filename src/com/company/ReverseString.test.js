const reverseString = require('./ReverseString');

test('examples', () => {
    const testArr1 = ["h","e","l","l","o"];
    const testArr2 = ["H","a","n","n","a","h"];

    reverseString(testArr1);
    reverseString(testArr2);

    expect(testArr1).toStrictEqual(["o","l","l","e","h"]);
    expect(testArr2).toStrictEqual(["h","a","n","n","a","H"]);
})

test('2 letters', () => {
    const testArr = ["h","e"];
    reverseString(testArr);
    expect(testArr).toStrictEqual(["e", "h"]);
})

test('empty', () => {
    const testArr = [];
    reverseString(testArr);
    expect(testArr).toStrictEqual([]);
})