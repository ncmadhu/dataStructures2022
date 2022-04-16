package Problems.LinkedLists;

import Common.Problem;
import Utils.SinglyLinkedList;
import Utils.SinglyLinkedList.Node;

// Fast and Slow pointer
// Fast will be at the end when Slow is at the middle

public class FindTheMiddleOfLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find The Middle Of Linked List");
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        for (int i = 1; i<= 9; i++) {
            sll.insertAtEnd(i);
        }
        System.out.print("Input: ");
        sll.printList();
        Node middle =  (Node)this.findMiddle(sll);
        System.out.println("Middle Of Linked List: " + middle.data.toString());
        sll.insertAtEnd(10);
        System.out.print("Input: ");
        sll.printList();
        middle =  (Node)this.findMiddle(sll);
        System.out.println("Middle Of Linked List: " + middle.data.toString());
    }

    public <T> Object findMiddle(SinglyLinkedList<T> list) {
        if (list.isEmpty()) return null;
        Node slowNode = list.headNode;
        Node fastNode = list.headNode;

        while(slowNode != null && fastNode != null && fastNode.nextNode != null) {
            fastNode = fastNode.nextNode.nextNode;
            if (fastNode == null) {
                break;
            }
            slowNode = slowNode.nextNode;

        }
        return slowNode;
    }
}
