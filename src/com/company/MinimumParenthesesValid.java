package com.company;

public class MinimumParenthesesValid {
  public static void main(String[] args) {
    System.out.println(minAddToMakeValid("()))())("));
  }

  public static int minAddToMakeValid(String s) {
    int left = 0, right = 0;

    for (char c : s.toCharArray()) {
      if (c == '(') left++;
      if (c == ')') {
        if (left == 0) right++;
        else left--;
      }
    }

    return right + left;
  }
}
