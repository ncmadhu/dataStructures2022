package Algorithms.HashTables;

import Algorithms.Algorithms;
import Algorithms.LinkedLists.SinglyLinkedList;
import Algorithms.LinkedLists.SinglyLinkedList.Node;

import java.util.HashMap;
import java.util.HashSet;

public class UnionAndIntersectionFromLinkedList extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Union And Intersection of Linked List (Hash Table)");
        SinglyLinkedList<Integer> sll1, sll2;

        sll1 = new SinglyLinkedList<>();
        sll1.insertAtEnd(7);
        sll1.insertAtEnd(14);
        sll1.insertAtEnd(21);
        sll1.insertAtEnd(22);

        sll2 = new SinglyLinkedList<>();
        sll2.insertAtEnd(7);
        sll2.insertAtEnd(15);
        sll2.insertAtEnd(16);
        sll2.insertAtEnd(22);

        System.out.print("Input SLL 1: ");
        sll1.printList();
        System.out.print("Input SLL 2: ");
        sll2.printList();
        this.unionWithHashing(sll1,sll2);
        System.out.print("After Union: ");
        sll1.printList();

        sll1 = new SinglyLinkedList<>();
        sll1.insertAtEnd(7);
        sll1.insertAtEnd(14);
        sll1.insertAtEnd(21);
        sll1.insertAtEnd(22);

        sll2 = new SinglyLinkedList<>();
        sll2.insertAtEnd(15);
        sll2.insertAtEnd(22);
        sll2.insertAtEnd(16);

        System.out.print("Input SLL 1: ");
        sll1.printList();
        System.out.print("Input SLL 2: ");
        sll2.printList();
        SinglyLinkedList<Integer> intersection = this.intersectionWithHashing(sll1,sll2);
        System.out.print("After Intersection: ");
        intersection.printList();
    }

    //performs union of two lists
    public <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        Node currNode = list1.headNode;
        // Traverse to the end of the first list
        HashSet<Object> visited = new HashSet<>();
        while (currNode.nextNode != null) {
            visited.add(currNode.data);
            currNode = currNode.nextNode;
        }
        // Add last element to visited
        visited.add(currNode.data);
        Node prevNode = currNode;
        currNode = list2.headNode;
        while (currNode != null) {
            if (visited.contains(currNode.data)) {
                prevNode.nextNode = currNode.nextNode;
            } else {
                visited.add(currNode.data);
                prevNode = currNode;
            }
            currNode = currNode.nextNode;
        }

        return list1;
    }

    //performs intersection between list
    public <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        // Write -- Your -- Code
        Node currNode = list1.headNode;
        // Traverse to the end of the first list
        HashSet<Object> visited = new HashSet<>();
        while (currNode.nextNode != null) {
            visited.add(currNode.data);
            currNode = currNode.nextNode;
        }
        // Add last element to visited
        visited.add(currNode.data);
        currNode = list2.headNode;
        while (currNode != null) {
            if (visited.contains(currNode.data)) {
               break;
            }
            currNode = currNode.nextNode;
        }
        while (currNode != null) {
            result.insertAtEnd((T) currNode.data);
            currNode = currNode.nextNode;
        }
        return result;
    }
}
