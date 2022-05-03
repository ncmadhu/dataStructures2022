package ReAttempt.LinkedLists;

import Common.Problem;
import Utils.LinkedListUtils;
import Utils.SinglyLinkedList;

public class ReverseLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Reverse Linked List");
        int[] input = new int[]{10, 5, 4, 1};
        this.execute(input);
    }

    private void execute(int[] input) {
        for(int i = 0; i < input.length; i++) {
            SinglyLinkedList<Integer> sll = LinkedListUtils.insertNodesNTimes(input[i]);
            System.out.println("Input: ");
            sll.printList();
            this.reverse(sll);
            System.out.println("Output: ");
            sll.printList();
            //this.reAttempt(sll);
            //System.out.println("Output (Re Attempt): ");
            //sll.printList();
        }
    }

    private void reAttempt(SinglyLinkedList<Integer> sll) {

    }

    private void reverse(SinglyLinkedList<Integer> sll) {
        if (sll.isEmpty()) return;
        SinglyLinkedList<Integer>.Node curr, prev, temp;
        prev = null;
        curr = sll.headNode;
        while (curr != null) {
            temp = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = temp;
        }
        sll.headNode = prev;
    }
}
