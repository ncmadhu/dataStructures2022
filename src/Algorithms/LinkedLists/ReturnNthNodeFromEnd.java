package Algorithms.LinkedLists;

import Algorithms.Algorithms;
import Algorithms.LinkedLists.SinglyLinkedList.Node;

//Move First pointer n nodes from start
//Move First pointer and Second pointer from start at the same time
//When First pointer reaches end, Second pointer will be at the N nodes from end
public class ReturnNthNodeFromEnd extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Return Nth Node From End Of Linked List");
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        for (int i = 1; i<= 10; i++) {
            sll.insertAtEnd(i);
        }
        System.out.print("Input: ");
        sll.printList();
        int n = 3;
        System.out.println(n + " th Element From End: " + this.nthElementFromEnd(sll, n));
    }

    public <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
        Node aheadNode = list.headNode;
        Node behindNode = list.headNode;
        int count = 0;
        while (count < n && aheadNode != null) {
            aheadNode = aheadNode.nextNode;
            count++;
        }
        while (aheadNode != null) {
            aheadNode = aheadNode.nextNode;
            behindNode = behindNode.nextNode;
        }
        return behindNode.data;
    }
}
