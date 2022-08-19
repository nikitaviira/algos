package com.company;

// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
// following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
// is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
// Do not modify the linked list.
//
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the second node.
//
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the first node.
//
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycle {
  public static void main(String[] args) {
    ListNode head = new ListNode(3);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(0);
    ListNode node4 = new ListNode(-4);

    head.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node2;

    ListNode listNode = detectCycle(head);
    System.out.println();
  }

  public static ListNode detectCycle(ListNode head) {
    if (head == null) return null;

    ListNode current = head;
    boolean isCycle = false;

    Set<ListNode> set = new HashSet<>();
    while (current.next != null) {
      set.add(current);
      current = current.next;
      if (set.contains(current)) {
        isCycle = true;
        break;
      }
    }

    return !isCycle ? null : findFirst(head, current);
  }

  public static ListNode findFirst(ListNode head, ListNode nodeToFind) {
    ListNode current = head;
    while (!current.equals(nodeToFind)) {
      current = current.next;
    }
    return current;
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
