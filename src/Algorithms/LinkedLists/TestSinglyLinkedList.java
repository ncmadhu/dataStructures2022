package Algorithms.LinkedLists;

import Algorithms.Algorithms;

public class TestSinglyLinkedList extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Testing Singly Linked List Operations");
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        System.out.println("SLL is empty: " + sll.isEmpty());
        sll.printList();
        for (int i = 1; i<= 10; i++) {
            sll.insertAtHead(i);
            sll.printList();
        }
        sll = new SinglyLinkedList<>();
        for (int i = 1; i<= 10; i++) {
            sll.insertAtEnd(i);
            sll.printList();
        }
        sll.insertAtEnd(12);
        sll.printList();
        sll.insertAfter(11, 10);
        sll.printList();
        sll.insertAfter(11, 50);
        int find = 5;
        System.out.println("Found " + find + ": " + sll.searchNode(find));
        find = 50;
        System.out.println("Found " + find + ": " + sll.searchNode(find));
        sll.deleteAtHead();
        sll.printList();
        sll.deleteAtHead();
        sll.printList();
        sll.deleteNode(5);
        sll.printList();
    }
}
