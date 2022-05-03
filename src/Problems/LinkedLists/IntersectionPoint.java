package Problems.LinkedLists;

import Common.Problem;
import Utils.LinkedList;
import Utils.LinkedListNode;
import Utils.LinkedListUtils;
import Utils.SinglyLinkedList;

public class IntersectionPoint extends Problem {
    @Override
    public void run() {
        System.out.println("Running Detect Intersection Point Linked List");
        int[][] input = new int[][]{{4, 9, 16, 25, 30, 18, 10, 25, 30, 18, 10} , {25, 30, 18, 10},
                {4, 9, 16, 25, 30, 18, 10, 25, 30, 18, 10}, {22, 11, 25, 30, 18, 10, 25, 30, 18, 10},
                {100, 200, 0, 25, 50},{0, 25, 50}, {30, 32, 40}, {85, 90, 76}, {30, 32, 40}, {30, 32, 40}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            LinkedList list1 = LinkedListUtils.generateLinkedListFromArray(input[i]);
            System.out.println("List 1: ");
            list1.displayLinkedList();
            LinkedList list2 = LinkedListUtils.generateLinkedListFromArray(input[i+1]);
            System.out.println("List 2: ");
            list2.displayLinkedList();
            LinkedListNode node = this.intersect(list1.head, list2.head);
            if (node != null) {
                System.out.println("Intersection Point: " + node.data);
            } else {
                System.out.println("Intersection Point: " + null);
            }

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

    private LinkedListNode intersect(LinkedListNode head1, LinkedListNode head2) {
        int size1, size2;
        size1 = this.getSize(head1);
        size2 = this.getSize(head2);
        int diff = Math.abs(size1 - size2);
        if (size2 > size1) {
            LinkedListNode temp = head1;
            head1 = head2;
            head2 = temp;
        }
        while (diff > 0) {
            head1 = head1.next;
            diff--;
        }
        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
}
