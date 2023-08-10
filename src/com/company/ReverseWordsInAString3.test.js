const reverseWords = require('./ReverseWordsInAString3');

test('examples', () => {
    expect(reverseWords("Let's take LeetCode contest")).toBe("s'teL ekat edoCteeL tsetnoc");
    expect(reverseWords("God Ding")).toBe("doG gniD");
})