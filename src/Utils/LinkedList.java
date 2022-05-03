package Utils;

import java.util.*;

public class LinkedList {
    public LinkedListNode head;

    public LinkedList() {
        this.head = null;
    }
    // insertAtHead method will insert an integer element at head of a linked list.
    public void insertAtHead(int data) {
        if (this.head == null) {
            this.head = new LinkedListNode(data);
        } else {
            LinkedListNode newNode = new LinkedListNode(data);
            newNode.next = this.head;
            this.head = newNode;
        }
    }
    // insertAtTail method will insert an integer element at tail of a linked list.
    public void insertAtTail(int data) {
        if (this.head == null) {
            this.head = new LinkedListNode(data);
        } else {
            LinkedListNode newNode = new LinkedListNode(data);
            LinkedListNode temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    /* createLinkedList method will create the linked list using the given
      integer array with the help of InsertAthead method. */
    public void createLinkedList(List<Integer> lst) {
        for (int i = lst.size() - 1; i >= 0; i--) {
            insertAtHead(lst.get(i));
        }
    }
    // displayLinkedList method will display the elements of linked list.
    public void displayLinkedList() {
        LinkedListNode temp = this.head;
        StringBuilder res = new StringBuilder("[");
        while (temp != null) {
            res.insert(res.length(), temp.data);
            temp = temp.next;
            if (temp != null) {
                res.insert(res.length(), ", ");
            }
        }
        res.insert(res.length(), "]");
        System.out.println(res.toString());
    }
}
