package com.company;

public class RotateList {
    public static void main(String[] args) {
        printTree(rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 10));
    }

    public static void printTree(ListNode node) {
        if (node == null) return;
        System.out.println(node.val);
        printTree(node.next);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = 0;
        ListNode counter = head;
        while (counter != null) {
            n++;
            counter = counter.next;
        }

        k = k > n ? k % n : k;
        if (k == n || k == 0) {
            return head;
        }

        ListNode faster = head;
        ListNode slower = head;
        for (int i = 0; i < k; i++) {
            faster = faster.next;
        }

        while (faster.next != null) {
            faster = faster.next;
            slower = slower.next;
        }

        ListNode kthNodeFromEnd = slower.next;
        slower.next = null;
        faster.next = head;

        return kthNodeFromEnd;
    }

     public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
