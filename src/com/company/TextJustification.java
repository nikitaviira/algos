package com.company;

import java.util.*;

// Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
//You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
// Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
//Extra spaces between words should be distributed as evenly as possible.
// If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//For the last line of text, it should be left-justified, and no extra space is inserted between words.
//
//Note:
//
//A word is defined as a character sequence consisting of non-space characters only.
//Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
//The input array words contains at least one word.
//
//
//Example 1:
//
//Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
//Output:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
//Example 2:
//
//Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
//Output:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
//Note that the second line is also left-justified because it contains only one word.
//Example 3:
//
//Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
//Output:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]

public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int width = 0;

        for (String word : words) {
            if (currentLine.size() + width + word.length() > maxWidth) {
                for (int i = 0; i < maxWidth - width; i++) {
                    int index = i % (currentLine.size() <= 1 ? 1 : currentLine.size() - 1);
                    currentLine.set(index, currentLine.get(index) + " ");
                }

                answer.add(String.join("", currentLine));
                currentLine = new ArrayList<>();
                width = 0;
            }
            width += word.length();
            currentLine.add(word);
        }

        answer.add(String.join(" ", currentLine) + " ".repeat(maxWidth - width));
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(fullJustify(new String[] {"What","must","be","acknowledgment","shall","be"}, 16));
    }
}
