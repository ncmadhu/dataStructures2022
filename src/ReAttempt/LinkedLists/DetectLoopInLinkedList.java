package ReAttempt.LinkedLists;

import Common.Problem;
import Utils.LinkedListUtils;
import Utils.SinglyLinkedList;
import Utils.SinglyLinkedList.Node;

// Fast Pointer and Slow Pointer
// If Loop exists Fast and Slow Pointer will meet at some point
public class DetectLoopInLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Detect Loop In Linked List");
        int[][] input = new int[][]{{10, 5} , {4, 1}, {4,4}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            SinglyLinkedList<Integer> sll = LinkedListUtils.insertNodesNTimes(input[i][0]);
            System.out.println("Input: ");
            sll.printList();
            System.out.println("Loop Exists: " + this.detectLoop(sll));
            sll.formLoopToNthNode(input[i][1]);
            System.out.println("Loop Exists: " + this.detectLoop(sll));
            System.out.println("Loop Exists (Re Attempt): " + this.reAttempt(sll));
            System.out.println("Loop Start: " + this.detectLoopStart(sll));
        }
    }

    public <T> boolean reAttempt(SinglyLinkedList<T> sll) {
        Node slow = sll.headNode;
        Node fast = sll.headNode;
        while (slow != null && fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
            if (slow.data == fast.data) return true;
        }
        return false;
    }

    public <T> int detectLoopStart(SinglyLinkedList<T> sll) {
        if (sll.isEmpty()) return -1;
        Node slow = sll.headNode;
        Node fast = sll.headNode;
        while (slow != null && fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
            if (slow == fast) break;
        }
        // Count the number of nodes in loop
        int count = 1;
        while (slow.nextNode != fast) {
            slow = slow.nextNode;
            count++;
        }
        // Move fast pointer n nodes from the head
        slow = sll.headNode;
        fast = sll.headNode;
        while (count > 0) {
            fast = fast.nextNode;
            count--;
        }
        while (slow != fast) {
            slow = slow.nextNode;
            fast = fast.nextNode;
        }
        while (fast.nextNode != slow) {
            fast = fast.nextNode;
        }
        return (int) fast.nextNode.data;
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
