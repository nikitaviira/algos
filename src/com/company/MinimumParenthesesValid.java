package com.company;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumParenthesesValid {
  public static void main(String[] args) {
    System.out.println(minAddToMakeValid("()))())("));
  }

  public static int minAddToMakeValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    int result = 0;

    for (char c : s.toCharArray()) {
      if (c == '(') stack.push(c);
      if (c == ')') {
        if (stack.isEmpty()) result++;
        else stack.pop();
      }
    }

    return result + stack.size();
  }
}
