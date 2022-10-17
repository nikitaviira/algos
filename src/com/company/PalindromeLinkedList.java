package com.company;

// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
//Example 1:
//Input: head = [1,2,2,1]
//Output: true

//Example 2:
//Input: head = [1,2]
//Output: false

import java.util.LinkedList;
public class PalindromeLinkedList {
  public static void main(String[] args) {
    System.out.println(isPalindrome(new ListNode(1, new ListNode(2))));
  }

  public static boolean isPalindrome(ListNode head) {
    var resultStr = new StringBuilder(String.valueOf(head.val));
    var curr = head;

    while (curr.next != null) {
      resultStr.append(curr.next.val);
      curr = curr.next;
    }

    var reversed = new StringBuilder(resultStr).reverse();
    return resultStr.compareTo(reversed) == 0;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
