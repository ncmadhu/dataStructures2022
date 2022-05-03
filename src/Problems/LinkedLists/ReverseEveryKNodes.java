package Problems.LinkedLists;

import Common.Problem;
import Utils.LinkedList;
import Utils.LinkedListNode;
import Utils.LinkedListUtils;

public class ReverseEveryKNodes extends Problem {
    @Override
    public void run() {
        System.out.println("Running Reverse Every K Nodes In Linked List");
        int[][] input = new int[][]{{1,2,3,4,5}, {2}, {1,2,3,4,5,6}, {3}, {1,2,3,4,5}, {1}, {1,2,3,4,5}, {0},
                {1,2,3,4,5,6,7,8}, {3}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            LinkedList list = LinkedListUtils.generateLinkedListFromArray(input[i]);
            System.out.println("List : ");
            list.displayLinkedList();
            System.out.println("K : " + input[i+1][0]);
            list.head = this.reverseKNodes(list.head, input[i+1][0]);
            list.displayLinkedList();

        }
    }

    private int getSize(LinkedListNode node) {
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    private LinkedListNode reverseKNodes(LinkedListNode head, int k) {
        if (head == null || k <= 1) return head;
        LinkedListNode curr, prev, revStart, revStartPrev, temp;
        revStart = curr = head;
        revStartPrev = prev = null;
        int count = 0;
        while (curr != null) {
            count++;
            if (count == k) {
                count = 0;
                if (revStartPrev == null) head = curr; //Head Node
                else revStartPrev.next = curr;
                revStart.next = curr.next; // Connecting reverse start to next node after kth node
                revStartPrev = revStart; // Re-initializing reverse start prev
                revStart = curr.next; // Re-initializing reverse start
                curr.next = prev; // Reversing the current node
                prev = revStartPrev; // Adjusting prev to point to reverse start since K nodes reached
                curr = revStart; // Adjusting curr to point to node after kth node
            } else {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
        }
        return head;
    }
}
