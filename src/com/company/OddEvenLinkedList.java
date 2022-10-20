package com.company;

public class OddEvenLinkedList {
  public static String printTree(ListNode node, String result) {
    if (node == null) return result;
    result += node.val + (node.next != null ? " -> " : "");
    return printTree(node.next, result);
  }

  public static void main(String[] args) {
    System.out.println(printTree(oddEvenList(
      new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))), ""));
  }

  public static ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode oddHead = null;
    ListNode oddTail = null;
    ListNode evenHead = null;
    ListNode evenTail = null;
    ListNode iter = head;
    boolean isOdd = true;

    while (iter != null) {
      if (isOdd) {
        if (oddHead == null) {
          oddHead = iter; oddTail = iter;
        }
        else {
          oddTail.next = iter;
          oddTail = oddTail.next;
        }
      } else {
        if (evenHead == null) {
          evenHead = iter; evenTail = iter;
        }
        else {
          evenTail.next = iter;
          evenTail = evenTail.next;
        }
      }
      iter = iter.next;
      isOdd = !isOdd;
    }

    evenTail.next = null;
    oddTail.next = evenHead;
    return oddHead;
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
