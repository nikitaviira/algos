package com.company;

// Given the head of a linked list, remove the nth node from the end of the list and return its head.
//Example 1:
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]

//Example 2:
//Input: head = [1], n = 1
//Output: []

//Example 3:
//Input: head = [1,2], n = 1
//Output: [1]
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthFromEnd {
  public static void printTree(ListNode node) {
    if (node == null) return;
    System.out.println(node.val);
    printTree(node.next);
  }

  public static void main(String[] args) {
    printTree(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 4));
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) return head;

    ListNode firstPointer = head;
    ListNode secondPointer = head;

    for (int i = 0; i < n; i++) {
      firstPointer = firstPointer.next;
    }

    if (firstPointer == null) {
      return head.next;
    }

    while (firstPointer.next != null) {
      firstPointer = firstPointer.next;
      secondPointer = secondPointer.next;
    }

    secondPointer.next = secondPointer.next.next;

    return head;
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
