package Problems.LinkedLists;

import Common.Problem;
import Utils.SinglyLinkedList;
import Utils.SinglyLinkedList.Node;

// Fast Pointer and Slow Pointer
// If Loop exists Fast and Slow Pointer will meet at some point
public class DetectLoopInLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Detect Loop In Linked List");
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        for (int i = 1; i<= 9; i++) {
            sll.insertAtEnd(i);
        }
        System.out.print("Input: ");
        sll.printList();
        System.out.println("Loop Exists: " + this.detectLoop(sll));
        sll.formLoop();
        System.out.println("Loop Exists: " + this.detectLoop(sll));
    }

    public <T> boolean detectLoop(SinglyLinkedList<T> sll) {
        if (sll.isEmpty()) return false;
        Node slowNode = sll.headNode;
        Node fastNode = sll.headNode;
        while (slowNode != null && fastNode != null && fastNode.nextNode != null) {
            slowNode = slowNode.nextNode;
            fastNode = fastNode.nextNode.nextNode;
            if (slowNode == fastNode) {
                System.out.println("SlowNode data: " + slowNode.data);
                System.out.println("FastNode data: " + fastNode.data);
                return true;
            }
        }
        return false;
    }

}
