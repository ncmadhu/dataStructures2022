package Algorithms.LinkedLists;

import Algorithms.Algorithms;
import Algorithms.LinkedLists.SinglyLinkedList.Node;

// Keep Track of Prev Node
// At the end update the headNode

public class ReverseLinkedList extends Algorithms {

    @Override
    public void run() {
        System.out.println("Running Reverse Linked List");
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        for (int i = 1; i<= 10; i++) {
            sll.insertAtEnd(i);
        }
        System.out.print("Input: ");
        sll.printList();
        this.reverse(sll);
        System.out.print("Output: ");
        sll.printList();
        sll = new SinglyLinkedList<>();
        sll.insertAtEnd(1);
        System.out.print("Input: ");
        sll.printList();
        this.reverse(sll);
        System.out.print("Output: ");
        sll.printList();

    }

    public <T> void reverse(SinglyLinkedList<T> sll) {
        if (sll.isEmpty()) {
            return;
        }
        Node prevNode = null;
        Node currNode = sll.headNode;
        Node nextNode = null;
        while(currNode != null) {
            nextNode =  currNode.nextNode;
            currNode.nextNode = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        sll.headNode = prevNode;
    }
}
