package com.company;

// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

//A valid BST is defined as follows:
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.

// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {
  public static void main(String[] args) {
    System.out.println(isValidBST(new TreeNode(5,
      new TreeNode(4),
      new TreeNode(6, new TreeNode(3), new TreeNode(7))
    )));
  }

  public static boolean isValidBST(TreeNode root) {
    return isBST(root, null, null);
  }

  public static boolean isBST(TreeNode root, TreeNode l, TreeNode r) {
    if (root == null)
      return true;

    if (l != null && root.val <= l.val)
      return false;

    if (r != null && root.val >= r.val)
      return false;

    return isBST(root.left, l, root) && isBST(root.right, root, r);
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
