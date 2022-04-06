package Algorithms.LinkedLists;

import Algorithms.Algorithms;
import Algorithms.LinkedLists.SinglyLinkedList.Node;

import java.util.HashSet;

public class UnionAndIntersectionOfLists extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Find Union And Intersection Of Linked List");
        SinglyLinkedList<Integer> sll1 = new SinglyLinkedList<>();
        for (int i = 1; i<= 10; i++) {
            sll1.insertAtEnd(i);
        }
        SinglyLinkedList<Integer> sll2 = new SinglyLinkedList<>();
        for (int i = 7; i<= 15; i++) {
            sll2.insertAtEnd(i);
        }
        System.out.print("List 1: ");
        sll1.printList();
        System.out.print("List 2: ");
        sll2.printList();
        SinglyLinkedList<Integer> intersection = this.intersection(sll1,sll2);
        System.out.print("Intersection: ");
        intersection.printList();
        SinglyLinkedList<Integer> unionized = this.union(sll1,sll2);
        System.out.print("Union: ");
        unionized.printList();

    }

    public <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1,SinglyLinkedList<T> list2) {
        if (list1.isEmpty() && list2.isEmpty()) return null;
        if (list1.isEmpty()) return list2;
        if (list2.isEmpty()) return list1;
        //move to the end of the list 1 while tracking visited nodes
        Node curr = list1.headNode;
        Node prev = null;
        HashSet<Object> visitedNodes = new HashSet<>();
        while (curr != null) {
            visitedNodes.add(curr.data);
            prev = curr;
            curr = curr.nextNode;
        }
        curr = list2.headNode;
        while ( curr != null) {
            if (visitedNodes.contains(curr.data)) {
                curr = curr.nextNode;
            } else {
                visitedNodes.add(curr.data);
                prev.nextNode = curr;
                prev = curr;
                curr = curr.nextNode;
            }
        }
        return list1;
    }

    public <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        if (list1.isEmpty() || list2.isEmpty()) return null;
        SinglyLinkedList<T> intersection = new SinglyLinkedList<>();
        Node curr = list1.headNode;
        HashSet<Object> visitedNodes = new HashSet<>();
        while (curr != null) {
            visitedNodes.add(curr.data);
            curr = curr.nextNode;
        }
        curr = list2.headNode;
        while (curr != null) {
            if (visitedNodes.contains(curr.data)) {
                intersection.insertAtEnd((T)curr.data);
            }
            curr = curr.nextNode;
        }
        return intersection;
    }
}
