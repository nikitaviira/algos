package com.company;

// Given the root of a binary tree, return the level order traversal of its nodes' values.
// (i.e., from left to right, level by level).
//
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
//Example 2:
//
//Input: root = [1]
//Output: [[1]]
//Example 3:
//
//Input: root = []
//Output: []

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    System.out.println(levelOrder(new TreeNode(3,
      new TreeNode(9, new TreeNode(4), null),
      new TreeNode(20, new TreeNode(15), new TreeNode(7))
    )));
  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return List.of();
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>(List.of(root));

    while (!queue.isEmpty()) {
      List<Integer> tempList = new ArrayList<>();
      var size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode temp = queue.poll();
        tempList.add(temp.val);
        if (temp.left != null) queue.add(temp.left);
        if (temp.right != null) queue.add(temp.right);
      }
      result.add(tempList);
    }

    return result;
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
