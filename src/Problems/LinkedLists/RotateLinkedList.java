package Problems.LinkedLists;

import Common.Problem;
import Utils.LinkedList;
import Utils.LinkedListNode;
import Utils.LinkedListUtils;

public class RotateLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Rotate Linked List");
        int[][] input = new int[][]{{4, 9, 16, 25, 30, 18, 10, 25, 30, 18, 10} , {5}, {25, 30, 18, 10}, {3},
                {4, 9, 16, 25, 30, 18, 10, 25, 30, 18, 10}, {-5}, {22, 11, 25, 30, 18, 10, 25, 30, 18, 10}, {-2},
                {100, 200, 0, 25, 50}, {5}, {0, 25, 50}, {-1}, {1,2,3,4,5}, {2},
                {1,2,3,4,5}, {-2},{1,2,3,4,5}, {1}, {1,2,3,4,5}, {0}, {0,1,2}, {4}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            LinkedList list = LinkedListUtils.generateLinkedListFromArray(input[i]);
            System.out.println("List : ");
            list.displayLinkedList();
            System.out.println("n : " + input[i+1][0]);
            list.head = this.rotateList(list.head, input[i+1][0]);
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

    private LinkedListNode rotateList(LinkedListNode head, int n) {
        int size;
        size = this.getSize(head);
        n = n % size;
        // Positive n it is from end, negative n it is from start
        // Convert negative n to positive by adding to size
        // 1 2 3 4 5 with n = 2 is 4 5 1 2 3
        // 1 2 3 4 5 with n = -2 is 3 4 5 1 2 is same as ( 5 - 2 = 3 which is n = 3)
        if (n < 0) n = size + n;
        if (n == 0 || head == null) return head;
        LinkedListNode node = head;
        // number of moves from start
        n = size - n - 1; // - 1 to stop one node before to set the previous node value to mark end of list
        while (n > 0) {
            node = node.next;
            n--;
        }
        // Set the new head node
        LinkedListNode newHead = node.next;
        // Mark the end of list
        node.next = null;
        node = newHead;
        while (node.next != null) {
            node = node.next;
        }
        // Connect previous end of list to old start of list
        node.next = head;
        return newHead;
    }
}
