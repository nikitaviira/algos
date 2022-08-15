package com.company;

import java.util.HashMap;

public class IsomorphicString {
  public static void main(String[] args) {
    System.out.println(isIsomorphic("egg", "dad"));
  }

  public static boolean isIsomorphic(String s, String t) {
    HashMap<Character, Character> dict = new HashMap();

    for (int i = 0 ; i < s.length() ; i++) {
      char s_char = s.charAt(i);
      char t_char = t.charAt(i);

      if (dict.containsKey(s_char)) {
        if (t_char == dict.get(s_char)) {
          continue;
        } else {
          return false;
        }
      } else if (dict.containsValue(t_char)) {
        return false;
      } else {
        dict.put(s_char, t_char);
      }
    }
    return true;
  }
}
