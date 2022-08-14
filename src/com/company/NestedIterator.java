package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class NestedIterator implements Iterator<Integer> {
  private final List<Integer> result = new ArrayList<>();
  int current = 0;

  public NestedIterator(List<NestedInteger> nestedList) {
    LinkedList<Iterator<NestedInteger>> stack = new LinkedList<>();
    stack.add(nestedList.iterator());

    while (!stack.isEmpty()) {
      Iterator<NestedInteger> iterator = stack.pop();

      while (iterator.hasNext()) {
        NestedInteger next = iterator.next();
        if (next.isInteger()) {
          result.add(next.getInteger());
        } else {
          stack.push(iterator);
          iterator = next.getList().iterator();
        }
      }
    }
  }

  @Override
  public Integer next() {
    return result.get(current++);
  }

  @Override
  public boolean hasNext() {
    return current + 1 <= result.size();
  }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

class NestedInt<T> implements NestedInteger {
  public T value;

  public NestedInt(T value) {
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
  public List<NestedInteger> getList() {
    return (List<NestedInteger>) value;
  }
}


interface NestedInteger {
  boolean isInteger();
  Integer getInteger();
  List<NestedInteger> getList();
}
