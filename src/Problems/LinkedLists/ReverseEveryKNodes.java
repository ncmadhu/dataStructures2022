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
                {1,2,3,4,5,6,7,8}, {3}, {1,2,3,4,5,6}, {2}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            LinkedList<Integer> list = LinkedListUtils.generateLinkedListFromArray(input[i]);
            System.out.println("List : ");
            list.displayLinkedList();
            System.out.println("K : " + input[i+1][0]);
            list.head = this.reverseKNodes(list.head, input[i+1][0]);
            System.out.println("Output: ");
            list.displayLinkedList();
            list = LinkedListUtils.generateLinkedListFromArray(input[i]);
            list.head = this.reverseKNodesBetterSolution(list.head, input[i+1][0]);
            System.out.println("Output (Better) : ");
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
            if (count == k || curr.next == null) {
                if (revStartPrev == null) head = curr; //Head Node
                else revStartPrev.next = curr;
                temp = curr.next;
                curr.next = prev; // Reversing the current node
                revStart.next = temp; // Connecting reverse start to next node after kth node
                prev = revStartPrev = revStart; // Re-initializing reverse start prev and prev
                curr = revStart = temp; // Re-initializing reverse start and curr
                count = 0; // Reset the count
            } else {
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
        }
        return head;
    }

    private LinkedListNode reverseKNodesBetterSolution(LinkedListNode head, int k) {
        if (head == null || k <= 1) return head;
        LinkedListNode newHead = null;
        LinkedListNode prevTail = null;
        while (head != null) {
            LinkedListNode currHead = null; // we don't know head at this point since we are reversing
            LinkedListNode currTail = head; // we know the tail because current head will be the tail after reversed
            int n = k;
            // reverse k nodes
            while (n > 0 && head != null) {
                LinkedListNode temp = head.next;
                head.next = currHead;
                currHead = head;
                head = temp;
                n--;
            }
            if (newHead == null) newHead = currHead; // init the new head value
            if (prevTail != null) prevTail.next = currHead; // Point prev tail to curr head
            prevTail = currTail; // Reset the prevTail  to current tail
        }
        return newHead;
    }
}
