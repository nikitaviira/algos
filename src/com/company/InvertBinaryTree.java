package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
  public static void printTree(TreeNode node, String prefix) {
    if (node == null) return;

    System.out.println(prefix + node.val);
    printTree(node.left , prefix + " ");
    printTree(node.right , prefix + " ");
  }

  public static void main(String[] args) {
    printTree(invertTree(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
      new TreeNode(7, new TreeNode(6), new TreeNode(9)))), "");
  }

  public static TreeNode invertTree(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) return root;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      var size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode temp = queue.poll();

        TreeNode left = temp.left;
        temp.left = temp.right;
        temp.right = left;

        if (temp.left != null) queue.add(temp.left = temp.right);
        if (temp.right != null) queue.add(temp.right);
      }
    }

    return root;
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
