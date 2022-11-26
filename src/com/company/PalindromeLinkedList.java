package com.company;

// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
//Example 1:
//Input: head = [1,2,2,1]
//Output: true

//Example 2:
//Input: head = [1,2]
//Output: false

public class PalindromeLinkedList {
  public static void main(String[] args) {
    System.out.println(isPalindrome(new ListNode(1)));
  }

  public static boolean isPalindrome(ListNode head) {
    int[] arr = new int[100_000];
    if (head.next == null) return true;
    int len = 0;
    while (head != null) {
      arr[len++] = head.val;
      head = head.next;
    }

    for (int i = 0; i < len / 2; i++) {
      if (arr[i] != arr[len - i - 1]) return false;
    }
    return true;
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
