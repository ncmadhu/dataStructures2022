package Problems.HashTables;

import Common.Problem;
import Utils.SinglyLinkedList.Node;
import Utils.SinglyLinkedList;

import java.util.HashMap;

public class RemoveDuplicateFromLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Remove Duplicate From Linked List (Hash Table)");
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
        this.removeDuplicatesWithHashing(sll);
        System.out.print("After Duplicate Removed: ");
        sll.printList();
    }

    public <V> void removeDuplicatesWithHashing(SinglyLinkedList<V> list) {
        // Write -- Your -- Code
        HashMap<Integer, Integer> duplicates = new HashMap<>();
        Node currNode = list.headNode;
        Node prevNode = null;
        while (currNode != null) {
            if (duplicates.containsKey(currNode.data)) {
                prevNode.nextNode = currNode.nextNode;
            } else {
                duplicates.put((Integer) currNode.data, 0);
                prevNode = currNode;
            }
            currNode = currNode.nextNode;
        }
    }
}
