package com.company;

// Given the head of a singly linked list, return the middle node of the linked list.
//If there are two middle nodes, return the second middle node.
//
//Input: head = [1,2,3,4,5]
//Output: [3,4,5]
//Explanation: The middle node of the list is node 3.
//
//Input: head = [1,2,3,4,5,6]
//Output: [4,5,6]
//Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

// https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfLinkedList {
  public static void printTree(ListNode node) {
    if (node == null) return;
    System.out.println(node.val);
    printTree(node.next);
  }

  public static void main(String[] args) {
    printTree(middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));
  }

  public static ListNode middleNode(ListNode head) {
    if (head == null) return null;

    ListNode node = head;
    int middle = findMiddle(head);
    while (middle != 1) {
      node = node.next;
      middle--;
    }
    return node;
  }

  public static int findMiddle(ListNode head) {
    int depth = 1;
    ListNode node = head;
    while (node.next != null) {
      node = node.next;
      depth++;
    }
    return (depth / 2) + 1;
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
