package com.company;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Main {

  public static void main(String[] args) {
    // "[123,[456,[789]]]"
    NestedIterator nestedIterator = new NestedIterator(List.of(
      new NestedInt<>(123),
      new NestedInt<>(List.of(new NestedInt<>(456), List.of(new NestedInt<>(789))))
    ));
    List<Integer> res = new ArrayList<>();
    while (nestedIterator.hasNext()) {
      res.add(nestedIterator.next());
    }
    System.out.println(res.stream().map(Object::toString).collect(joining(", ")));
  }
}
