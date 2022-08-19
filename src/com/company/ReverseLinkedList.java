package com.company;

// Given the head of a singly linked list, reverse the list, and return the reversed list.

//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]

//Input: head = [1,2]
//Output: [2,1]

//Input: head = []
//Output: []

// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
  public static void printTree(ListNode node) {
    if (node == null) return;
    System.out.println(node.val);
    printTree(node.next);
  }

  public static void main(String[] args) {
    printTree(reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
  }

  public static ListNode reverseList(ListNode head) {
    ListNode previous = null;

    if (head == null) {
      return null;
    }

    while (head != null) {
      ListNode temp = head.next;
      head.next = previous;
      previous = head;
      head = temp;
    }
    return previous;
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
