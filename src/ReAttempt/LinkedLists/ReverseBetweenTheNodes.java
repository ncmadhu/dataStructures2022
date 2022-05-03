package ReAttempt.LinkedLists;

import Common.Problem;
import Utils.LinkedListUtils;
import Utils.ListNode;
import Utils.SinglyLinkedList;

public class ReverseBetweenTheNodes extends Problem {
    @Override
    public void run() {
        System.out.println("Running Reverse The Nodes Between");
        int[][] input = new int[][]{{5,10},{1,5},{5,8},{5,11}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for(int i = 0; i < input.length; i++) {
            SinglyLinkedList<Integer> sll = LinkedListUtils.insertNodesNTimes(10);
            System.out.println("Input: ");
            sll.printList();
            System.out.println("Start: " + input[i][0] + " End: " + input[i][1]);
            this.reverseBetweenTheNodes(sll, input[i][0], input[i][1]);
            System.out.println("Output: ");
            sll.printList();
            this.reAttempt(sll, input[i][0], input[i][1]);
            System.out.println("Output (Re Attempt): ");
            sll.printList();
        }
    }

    private void reAttempt(SinglyLinkedList<Integer> sll, int start, int end) {
        if (sll.isEmpty()) return;
        if (start <= 0) start = 1;
        int count = 0;
        SinglyLinkedList<Integer>.Node curr = sll.headNode;
        SinglyLinkedList<Integer>.Node prev = null;
        while (curr != null && count < start) {
            prev = curr;
            curr = curr.nextNode;
            count += 1;
        }
        SinglyLinkedList<Integer>.Node revStartPrev = prev;
        SinglyLinkedList<Integer>.Node revStart = curr;
        SinglyLinkedList<Integer>.Node temp;
        while (curr != null && count < end - 1) {
            temp = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = temp;
            count += 1;
        }
        if (revStartPrev == null) sll.headNode = prev;
        else revStartPrev.nextNode = prev;
        revStart.nextNode = curr;
    }

    private void reverseBetweenTheNodes(SinglyLinkedList<Integer> sll, int start, int end) {
        if (sll.isEmpty()) return;
        if (start <= 0) start = 1;
        int count = 0;
        SinglyLinkedList<Integer>.Node curr, prev, revStartPrev, revStart, temp;
        prev = null;
        curr = sll.headNode;
        while (curr != null) {
            count += 1;
            if (count > start) break;
            prev = curr;
            curr = curr.nextNode;
        }
        revStartPrev = prev;
        revStart = curr;
        while (curr != null) {
            temp = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = temp;
            count += 1;
            if (count == end) break;
        }
        if (revStartPrev == null) sll.headNode = prev; //Head Node condition
        else revStartPrev.nextNode = prev;
        revStart.nextNode = curr;
    }
}
