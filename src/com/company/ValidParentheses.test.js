const isValid = require('./ValidParentheses');

test('examples', () => {
    expect(isValid("()")).toBe(true);
    expect(isValid("()[]{}")).toBe(true);
    expect(isValid("(]")).toBe(false);
})

test('nested', () => {
    expect(isValid("[()()()]")).toBe(true);
    expect(isValid("[{()()()}]")).toBe(true);
    expect(isValid("[(((())))]")).toBe(true);
    expect(isValid("[{({)()(})}]")).toBe(false);
})