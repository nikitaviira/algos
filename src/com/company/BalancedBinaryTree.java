package com.company;

public class BalancedBinaryTree {
  public static void main(String[] args) {
    System.out.println(isBalanced(new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4)))));
  }

  public static boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    if (Math.abs(nodeHeight(root.left) - nodeHeight(root.right)) > 1) return false;
    else return isBalanced(root.left) && isBalanced(root.right);
  }

  public static int nodeHeight(TreeNode root) {
    if (root == null) return 0;
    var leftHeight = nodeHeight(root.left);
    var rightHeight = nodeHeight(root.right);
    return Math.max(leftHeight, rightHeight) + 1;
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
