var RandomizedSet = function() {
    this.map = new Map();
    this.elements = [];
};

/**
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.insert = function(val) {
    if (this.map.has(val)) {
        return false;
    }

    this.map.set(val, this.map.size);
    this.elements.push(val);
    return true;
};

/**
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.remove = function(val) {
    if (!this.map.has(val)) {
        return false;
    }

    let indexToRemove = this.map.get(val);
    let lastElement = this.elements[this.elements.length - 1];
    this.map.set(lastElement, indexToRemove);
    this.map.delete(val);

    this.elements[this.elements.length - 1] = this.elements[indexToRemove];
    this.elements[indexToRemove] = lastElement;
    this.elements.pop();

    return true;
};

/**
 * @return {number}
 */
RandomizedSet.prototype.getRandom = function() {
    return this.elements[Math.floor(Math.random() * this.elements.length)]
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = new RandomizedSet()
 * var param_1 = obj.insert(val)
 * var param_2 = obj.remove(val)
 * var param_3 = obj.getRandom()
 */

var obj = new RandomizedSet()
obj.insert(1);
obj.remove(2);
obj.insert(2);
console.log(obj.getRandom());
obj.remove(1);
obj.insert(2);
console.log(obj.getRandom());