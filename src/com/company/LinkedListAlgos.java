package com.company;

import java.util.HashSet;

public class LinkedListAlgos {
  public static void main(String[] args) {
    //SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    //list.insertAtEnd(15);
    //list.insertAtEnd(22);
    //list.insertAtEnd(8);
    //list.insertAtEnd(7);
    //list.insertAtEnd(14);
    //list.insertAtEnd(21);
//
    ////printTree(intersection(list).headNode);
    //System.out.println(nthElementFromEnd(list, -2));

    DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
    doublyLinkedList.insertAtEnd(5);
    doublyLinkedList.insertAtEnd(4);
    doublyLinkedList.insertAtEnd(4);
    doublyLinkedList.insertAtEnd(4);
    doublyLinkedList.insertAtEnd(5);

    System.out.println(isPalindrome(doublyLinkedList));
  }

  public static void printTree(SinglyLinkedList.Node node) {
    if (node == null) return;
    System.out.print(node.data + " -> " + (node.nextNode == null ? "null" : ""));
    printTree(node.nextNode);
  }

  public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
    HashSet<SinglyLinkedList<T>.Node> nodes = new HashSet<>();
    SinglyLinkedList<T>.Node temp = list.headNode;

    while (temp != null) {
      if (!nodes.add(temp)) return true;
      temp = temp.nextNode;
    }

    return false;
  }

  public static <T> Object findMiddle(SinglyLinkedList<T> list) {
    if (list.isEmpty()) return null;

    SinglyLinkedList<T>.Node mid = list.headNode;
    SinglyLinkedList<T>.Node current = list.headNode;

    while (mid != null && current != null && current.nextNode != null) {
      current = current.nextNode.nextNode;
      if (current != null) mid = mid.nextNode;
    }

    return mid.data;
  }

  public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
    HashSet<T> values = new HashSet<>();
    values.add(list.headNode.data);

    SinglyLinkedList<T>.Node slow = list.headNode;
    SinglyLinkedList<T>.Node fast = list.headNode.nextNode;

    while (fast != null && slow != null) {
      if (!values.add(fast.data)) slow.nextNode = fast.nextNode;
      else slow = slow.nextNode;

      fast = fast.nextNode;
    }
  }

  public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
    SinglyLinkedList<T> result = new SinglyLinkedList<>();
    SinglyLinkedList<T>.Node temp = list1.getHeadNode();

    while (temp.nextNode != null) {
      temp = temp.nextNode;
    }

    temp.nextNode = list2.getHeadNode();
    result.removeDuplicatesWithHashing();

    return result;
  }

  public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
    SinglyLinkedList<T> result = new SinglyLinkedList<>();
    SinglyLinkedList<T>.Node temp = list1.getHeadNode();

    while (temp != null) {
      if (list2.searchNode(temp.data)) result.insertAtEnd(temp.data);
      temp = temp.nextNode;
    }

    return result;
  }

  public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
    SinglyLinkedList<T>.Node slow = list.getHeadNode();
    SinglyLinkedList<T>.Node fast = list.getHeadNode();

    for (int i = 0; i < n - 1; i++) {
      if (fast == null) return null;
      fast = fast.nextNode;
    }

    if (fast == null) return null;

    if (fast.nextNode == null) {
      return list.getHeadNode().data;
    }

    while (fast.nextNode != null) {
      slow = slow.nextNode;
      fast = fast.nextNode;
    }

    return slow.data;
  }

  public static class SinglyLinkedList<T> {
    //Node inner class for SLL
    public class Node {
      public T data;
      public Node nextNode;

    }

    //head node of the linked list
    private Node headNode;
    private int size;

    public Node getHeadNode() {
      return headNode;
    }

    public void setHeadNode(Node headNode) {
      this.headNode = headNode;
    }

    public int getSize() {
      return size;
    }

    public void setSize(int size) {
      this.size = size;
    }

    //constructor
    public SinglyLinkedList() {
      headNode = null;
      size = 0;
    }

    public boolean isEmpty() {

      if (headNode == null) return true;
      return false;
    }

    //Inserts new data at the start of the linked list
    public void insertAtHead(T data) {
      //Creating a new node and assigning it the new data value
      Node newNode = new Node();
      newNode.data = data;
      //Linking head to the newNode's nextNode
      newNode.nextNode = headNode;
      headNode = newNode;
      size++;
    }

    //Inserts new data at the end of the linked list
    public void insertAtEnd(T data) {
      //if the list is empty then call insertATHead()
      if (isEmpty()) {
        insertAtHead(data);
        return;
      }
      //Creating a new Node with value data
      Node newNode = new Node();
      newNode.data = data;
      newNode.nextNode = null;

      Node last = headNode;
      //iterate to the last element
      while (last.nextNode != null) {
        last = last.nextNode;
      }
      //make newNode the next element of the last node
      last.nextNode = newNode;
      size++;
    }

    //inserts data after the given prev data node
    public void insertAfter(T data, T previous) {

      //Creating a new Node with value data
      Node newNode = new Node();
      newNode.data = data;
      //Start from head node
      Node currentNode = this.headNode;
      //traverse the list until node having data equal to previous is found
      while (currentNode != null && currentNode.data != previous) {
        currentNode = currentNode.nextNode;
      }
      //if such a node was found
      //then point our newNode to currentNode's nextElement
      if (currentNode != null) {
        newNode.nextNode = currentNode.nextNode;
        currentNode.nextNode = newNode;
        size++;
      }
    }

    public void printList() {
      if (isEmpty()) {
        System.out.println("List is Empty!");
        return;
      }

      Node temp = headNode;
      System.out.print("List : ");

      while (temp.nextNode != null) {
        System.out.print(temp.data.toString() + " -> ");
        temp = temp.nextNode;
      }

      System.out.println(temp.data.toString() + " -> null");
    }

    //Searches a value in the given list.
    public boolean searchNode(T data) {
      //Start from first element
      Node currentNode = this.headNode;

      //Traverse the list till you reach end
      while (currentNode != null) {
        if (currentNode.data.equals(data))
          return true; //value found

        currentNode = currentNode.nextNode;
      }
      return false; //value not found
    }

    public void deleteAtHead() {
      if (isEmpty())
        return;
      headNode = headNode.nextNode;
      size--;
    }

    public void deleteAtEnd() {
      if (isEmpty())
        return;
      Node prevNode = this.headNode;
      Node currentNode = prevNode.nextNode;
      while (currentNode.nextNode != null) {
        prevNode = currentNode;
        currentNode = currentNode.nextNode;
      }
      prevNode.nextNode = null;
      size--;
    }

    public void deleteByValue(T data) {
      //if empty then simply return
      if (isEmpty())
        return;
      //Start from head node
      Node currentNode = this.headNode;
      Node prevNode = null; //previous node starts from null

      if (currentNode.data.equals(data)) {
        //data is at head so delete from head
        deleteAtHead();
        return;
      }
      //traverse the list searching for the data to delete
      while (currentNode != null) {
        //node to delete is found
        if (data.equals(currentNode.data)) {
          prevNode.nextNode = currentNode.nextNode;
          size--;
          return;
        }
        prevNode = currentNode;
        currentNode = currentNode.nextNode;
      }
    }
    public void removeDuplicatesWithHashing() {
      Node current = this.headNode;
      Node prevNode = this.headNode;
      //will store all the elements that we observe once
      HashSet<T> visitedNodes = new HashSet<T>();

      if (!isEmpty() && current.nextNode != null) {
        while (current != null) {
          //check if already visited then delete this node
          if (visitedNodes.contains(current.data)) {
            //deleting the node by undating the pointer of previous node
            prevNode.nextNode = current.nextNode;
            current = current.nextNode;
          } else {
            //if node was not already visited then add it to the visited set
            visitedNodes.add(current.data);
            //moving on to next element in the list
            prevNode = current;
            current = current.nextNode;
          }
        }
      }
    }
  }

  public static <T> boolean isPalindrome(DoublyLinkedList<T> list) {
    if (list.isEmpty() || list.getSize() == 1) return true;

    DoublyLinkedList<T>.Node headTemp = list.getHeadNode();
    DoublyLinkedList<T>.Node tailTemp = list.getTailNode();

    while (!headTemp.equals(tailTemp)) {
      if (headTemp.data.equals(tailTemp.data)) {
        headTemp = headTemp.nextNode;
        if (headTemp.equals(tailTemp)) break;

        tailTemp = tailTemp.prevNode;
      } else {
        return false;
      }
    }

    return true;
  }

  public static class DoublyLinkedList<T> {

    //Node inner class for DLL
    public class Node {
      public T data;
      public Node nextNode;
      public Node prevNode;
    }

    public Node headNode;
    public Node tailNode;
    public int size;

    public DoublyLinkedList() {
      this.headNode = null;
      this.tailNode = null;
    }

    public boolean isEmpty() {
      if (headNode == null && tailNode == null)
        return true;
      return false;
    }

    public Node getHeadNode() {
      return headNode;
    }

    public Node getTailNode() {
      return tailNode;
    }

    public int getSize() {
      return size;
    }

    public void insertAtHead(T data) {
      Node newNode = new Node();
      newNode.data = data;
      newNode.nextNode = this.headNode; //Linking newNode to head's nextNode
      newNode.prevNode = null;
      if (headNode != null)
        headNode.prevNode = newNode;
      else
        tailNode = newNode;
      this.headNode = newNode;
      size++;
    }

    public void insertAtEnd(T data) {
      if (isEmpty()) {
        insertAtHead(data);
        return;
      }
      Node newNode = new Node();
      newNode.data = data;
      newNode.nextNode = null;
      newNode.prevNode = tailNode;
      tailNode.nextNode = newNode;
      tailNode = newNode;
      size++;
    }

    public void printList() {
      if (isEmpty()) {
        System.out.println("List is Empty!");
        return;
      }

      Node temp = headNode;
      System.out.print("List : null <- ");

      while (temp.nextNode != null) {
        System.out.print(temp.data.toString() + " <-> ");
        temp = temp.nextNode;
      }

      System.out.println(temp.data.toString() + " -> null");
    }

    public void printListReverse() {
      if (isEmpty()) {
        System.out.println("List is Empty!");
        return;
      }

      Node temp = tailNode;
      System.out.print("List : null <- ");

      while (temp.prevNode != null) {
        System.out.print(temp.data.toString() + " <-> ");
        temp = temp.prevNode;
      }

      System.out.println(temp.data.toString() + " -> null");
    }

    public void deleteByValue(T data) {
      //if empty then simply return
      if (isEmpty())
        return;

      //Start from head node
      Node currentNode = this.headNode;

      if (currentNode.data.equals(data)) {
        //data is at head so delete from head
        deleteAtHead();
        return;
      }
      //traverse the list searching for the data to delete
      while (currentNode != null) {
        //node to delete is found
        if (data.equals(currentNode.data)) {
          currentNode.prevNode.nextNode = currentNode.nextNode;
          if (currentNode.nextNode != null)
            currentNode.nextNode.prevNode = currentNode.prevNode;
          size--;
        }
        currentNode = currentNode.nextNode;
      }
    }

    public void deleteAtHead() {
      if (isEmpty())
        return;

      headNode = headNode.nextNode;
      if (headNode == null)
        tailNode = null;
      else
        headNode.prevNode = null;
      size--;
    }

    public void deleteAtTail() {
      if (isEmpty())
        return;
      tailNode = tailNode.prevNode;
      if (tailNode == null)
        headNode = null;
      else
        tailNode.nextNode = null;
      size--;
    }

  }

}
