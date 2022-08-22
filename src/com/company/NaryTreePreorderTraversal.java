package com.company;

// Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
//Nary-Tree input serialization is represented in their level order traversal.
// Each group of children is separated by the null value (See examples)
//
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [1,3,5,6,2,4]

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/n-ary-tree-preorder-traversal/
public class NaryTreePreorderTraversal {
  public static void main(String[] args) {
    // result = [1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10]
    Node root = new Node(1, List.of(
      new Node(2),
      new Node(3, List.of(new Node(6), new Node(7, List.of(new Node(11, List.of(new Node(14))))))),
      new Node(4, List.of(new Node(8, List.of(new Node(12))))),
      new Node(5, List.of(new Node(9, List.of(new Node(13))), new Node(10)))
    ));
    System.out.println(preorder(root));
  }

  public static List<Integer> preorder(Node root) {
    if (root == null) return List.of();
    List<Integer> result = new ArrayList<>();
    result.add(root.val);
    return root.children != null ? recursion(root.children, result) : result;
  }

  public static List<Integer> recursion(List<Node> children, List<Integer> result) {
    for (Node child : children) {
      result.add(child.val);
      if (child.children != null) result.addAll(recursion(child.children, new ArrayList<>()));
    }
    return result;
  }

  public static class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }
}
