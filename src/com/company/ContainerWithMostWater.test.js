const maxArea = require('./ContainerWithMostWater')

test('examples', () => {
    expect(maxArea([1,8,6,2,5,4,8,3,7])).toBe(49);
    expect(maxArea([1,1])).toBe(1);
    expect(maxArea([1,8,6,9,4,7])).toBe(28);
});