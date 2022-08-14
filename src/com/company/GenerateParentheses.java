package com.company;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList();
    backtrack(ans, new StringBuilder(), 0, 0, n);
    return ans;
  }

  public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
    // If the number of left parenthesis and right parenthesis is equal,
    // add the solution to list and leave the recursion
    if (cur.length() == max * 2) {
      ans.add(cur.toString());
      return;
    }

    // if number of open brackets is less than the max amount of pairs,
    // add left parenthesis and call recursion with it. Remove it from the current string.
    // Afterwards we go to the right bracket.
    if (open < max) {
      cur.append("(");
      backtrack(ans, cur, open+1, close, max);
      cur.deleteCharAt(cur.length() - 1);
    }

    // if number of close brackets is less than number of open brackets,
    // add right parenthesis and call recursion
    if (close < open) {
      cur.append(")");
      backtrack(ans, cur, open, close+1, max);
      cur.deleteCharAt(cur.length() - 1);
    }
  }
}
