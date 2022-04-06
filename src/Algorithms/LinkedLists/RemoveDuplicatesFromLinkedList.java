package Algorithms.LinkedLists;

import Algorithms.Algorithms;
import Algorithms.LinkedLists.SinglyLinkedList.Node;

import java.util.HashMap;

public class RemoveDuplicatesFromLinkedList extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Remove Duplicates From Linked List");
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.insertAtEnd(7);
        sll.insertAtEnd(14);
        sll.insertAtEnd(14);
        sll.insertAtEnd(14);
        sll.insertAtEnd(21);
        sll.insertAtEnd(14);
        sll.insertAtEnd(22);
        sll.insertAtEnd(7);
        System.out.print("Input: ");
        sll.printList();
        this.removeDuplicates(sll);
        System.out.print("Output: ");
        sll.printList();

    }

    public <T> void removeDuplicates(SinglyLinkedList<T> list) {
        if (list.isEmpty()) return;
        Node prev = null;
        Node curr = list.headNode;
        HashMap<Object,Object> visited = new HashMap<>();
        while(curr != null) {
            if(visited.containsKey(curr.data)) {
                prev.nextNode = curr.nextNode;
            } else {
                visited.put(curr.data, curr.data);
                prev =  curr;
            }
            curr = curr.nextNode;
        }
    }
}
