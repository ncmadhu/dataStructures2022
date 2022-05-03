package ReAttempt.LinkedLists;

import Common.Problem;
import Utils.LinkedListUtils;
import Utils.ListNode;
import Utils.SinglyLinkedList;

public class MiddleOfTheLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Middle Of The Linked List");
        int[] input = new int[]{10, 5, 1};
        this.execute(input);
    }

    private void execute(int[] input) {
        for (int i = 0; i < input.length; i++) {
            SinglyLinkedList<Integer> sll = LinkedListUtils.insertNodesNTimes(input[i]);
            System.out.println("Input: ");
            sll.printList();
            SinglyLinkedList<Integer>.Node middleNode = getMiddleNode(sll);
            System.out.println("Middle Node: " + middleNode.data);
        }
    }

    public <T> SinglyLinkedList<T>.Node getMiddleNode(SinglyLinkedList<T> sll) {
        if (sll.isEmpty()) return null;
        SinglyLinkedList<T>.Node slow, fast;
        slow = sll.headNode;
        fast = sll.headNode;
        while (fast != null && fast.nextNode != null) {
            fast = fast.nextNode.nextNode;
            if (fast == null) break;
            slow = slow.nextNode;
        }
        return slow;
    }
}
