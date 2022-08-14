package com.company;

import java.util.ArrayList;
import java.util.List;

class MiniParser {
    public static void main(String[] args) {
        //    NestedIterator nestedIterator = new NestedInt(List.of(
        //      new NestedInt<>(123),
        //      new NestedInt<>(List.of(new NestedInt<>(456), List.of(new NestedInt<>(789))))
        //    ));
        var s = "[123,[456,[789]]]";
    }

    public NestedInteger deserialize(String s) {
        int current = 0;
        var chars = s.toCharArray();
        return recc(chars, current);
    }

    public NestedInteger recc(char[] chars, int current) {
        if (chars[current] == '[') {
            current++;
            NestedInteger parent = new NestedInt();
            return recc(chars, current);
        }
        else {
            StringBuilder strNumber = new StringBuilder();
            while (current <= chars.length - 1 && Character.isDigit(chars[current]) || chars[current] == '-') {
                strNumber.append(chars[current]);
                current++;
            }
            return new NestedInt(Integer.parseInt(strNumber.toString()));
        }
    }

    public static class NestedInt implements NestedInteger {
        public Object value;

        public NestedInt() {}

        public NestedInt(int value) {
            this.value = value;
        }

        @Override
        public boolean isInteger() {
            return value instanceof Integer;
        }

        @Override
        public Integer getInteger() {
            return (Integer) value;
        }

        @Override
        public void setInteger(int value) {
            this.value = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            if (this.value == null) {
                this.value = new ArrayList<NestedInteger>();
            }
            this.value = this.getList().add(ni);
        }

        @Override
        public List<NestedInteger> getList() {
            return (List<NestedInteger>) value;
        }
    }


    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
