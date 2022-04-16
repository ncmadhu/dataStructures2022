package Problems.LinkedLists;

import Common.Problem;
import Utils.DoublyLinkedList;

public class TestDoublyLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Testing Doubly Linked List Operations");
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.printList();
        dll.insertAtHead(2);
        System.out.println("Head Node is: " + dll.getHeadNode().data.toString());
        System.out.println("Tail Node is: " + dll.getTailNode().data.toString());
        dll.insertAtHead(1);
        System.out.println("Head Node is: " + dll.getHeadNode().data.toString());
        System.out.println("Tail Node is: " + dll.getTailNode().data.toString());
        for (int i = 3; i <= 11; i++) {
            dll.insertAtTail(i);
            dll.printList();
        }
        dll.insertAtHead(50);
        System.out.println("Head Node is: " + dll.getHeadNode().data.toString());
        dll.printList();
        dll.deleteAtHead();
        System.out.println("Head Node is: " + dll.getHeadNode().data.toString());
        dll.printList();
        System.out.println("Tail Node is: " + dll.getTailNode().data.toString());
        dll.deleteAtTail();
        System.out.println("Tail Node is: " + dll.getTailNode().data.toString());
        dll.printList();
    }
}
