package ReAttempt.LinkedLists;

import Common.Problem;
import Utils.LinkedListUtils;
import Utils.ListNode;
import Utils.SinglyLinkedList;

public class ReturnNthNodeFromEnd extends Problem {
    @Override
    public void run() {
        System.out.println("Running Remove Nth Node From End Of List");
        int[][] input = new int[][]{{1}, {1}, {1, 2, 3, 4, 5}, {1}, {1, 2, 3, 4, 5}, {4}, {1, 2, 3, 4, 5}, {5}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            SinglyLinkedList<Integer> sll = LinkedListUtils.generateListFromArray(input[i]);
            System.out.print("Input: ");
            sll.printList();
            System.out.println("Nth (" + input[i+1][0] + ") Node From End: " + this.nthNodeFromEnd(sll, input[i+1][0]));
        }
    }
    private <T> Object nthNodeFromEnd(SinglyLinkedList<T> sll, int n) {
        if (sll.isEmpty()) return -1;
        if (sll.size < n) return sll.headNode.data;
        SinglyLinkedList<T>.Node curr = sll.headNode;
        int count = 0;
        while (curr != null && count < n) {
            curr = curr.nextNode;
            count++;
        }
        SinglyLinkedList<T>.Node nthNode = sll.headNode;
        while (curr != null) {
            curr = curr.nextNode;
            nthNode = nthNode.nextNode;
        }
        return nthNode.data;
    }
}
