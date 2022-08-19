package com.company;

// You are given the heads of two sorted linked lists list1 and list2.
//Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
//Return the head of the merged linked list.

//Example 1:
//Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]

//Example 2:
//Input: list1 = [], list2 = []
//Output: []

//Example 3:
//Input: list1 = [], list2 = [0]
//Output: [0]

// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
  public static void printTree(ListNode node) {
    if (node == null) return;
    System.out.println(node.val);
    printTree(node.next);
  }

  public static void main(String[] args) {
    ListNode node = mergeTwoLists(
      new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(5)))),
      new ListNode(6, new ListNode(8, new ListNode(10)))
    );
    printTree(node);
  }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null && list2 == null) {
      return null;
    } else if (list1 == null) {
      return list2;
    } else if (list2 == null) return list1;
    return recursion(null, list1, list2);
  }

  public static ListNode recursion(ListNode head, ListNode list1, ListNode list2) {
    if (list1 == null && list2 == null) {
      return head;
    } else {
      return (list1 != null && list2 != null && list1.val <= list2.val) || list2 == null && list1 != null
        ? recursion(insertEnd(head, list1.val), list1.next, list2)
        : recursion(insertEnd(head, list2.val), list1, list2.next);
    }
  }

  public static ListNode insertEnd(ListNode head, int data) {
    if (head == null) {
      return new ListNode(data);
    } else {
      head.next = insertEnd(head.next, data);
    }
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
