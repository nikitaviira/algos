package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static Map<Character, Set<Character>> combos = Map.of(
            '1', Set.of(),
            '2', Set.of('a', 'b', 'c'),
            '3', Set.of('d', 'e', 'f'),
            '4', Set.of('g', 'h', 'i'),
            '5', Set.of('j', 'k', 'l'),
            '6', Set.of('m', 'n', 'o'),
            '7', Set.of('p', 'q', 'r', 's'),
            '8', Set.of('t', 'u', 'v'),
            '9', Set.of('w', 'x', 'y', 'z')
    );

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }

        List<String> ans = new ArrayList<>();
        backtrack(digits, ans, "");
        return ans;
    }

    public static void backtrack(String digits, List<String> ans, String cur) {
        if (digits.isEmpty()) {
            ans.add(cur);
        } else {
            for (char letter : combos.get(digits.charAt(0))) {
                backtrack(digits.substring(1), ans, cur + letter);
            }
        }
    }
}
