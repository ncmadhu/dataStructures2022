package Problems.LinkedLists;

import Common.Problem;
import Utils.LinkedList;
import Utils.LinkedListNode;
import Utils.LinkedListUtils;

public class AddIntegers extends Problem {
    @Override
    public void run() {
        System.out.println("Running Reverse Every K Nodes In Linked List");
        int[][] input = new int[][]{{1,0,9,9}, {7,3,2}, {7,3,2}, {7,3,2}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            LinkedList list1 = LinkedListUtils.generateLinkedListFromArray(input[i]);
            System.out.println("Num 1 : ");
            list1.displayLinkedList();
            LinkedList list2 = LinkedListUtils.generateLinkedListFromArray(input[i + 1]);
            System.out.println("Num 2 : ");
            list2.displayLinkedList();
            LinkedList result = new LinkedList();
            result.head = this.addIntegers(list1.head, list2.head);
            System.out.println("Sum: ");
            result.displayLinkedList();
            result.head = this.addIntegersBS(list1.head, list2.head);
            System.out.println("Sum (BS): ");
            result.displayLinkedList();
        }
    }

    private LinkedListNode addIntegers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode resultHead = null;
        LinkedListNode prev = null;
        int carry = 0;
        while (head1 != null && head2 != null) {
            int sum = head1.data + head2.data + carry;
            LinkedListNode node = new LinkedListNode(sum % 10);
            carry = sum / 10;
            head1 = head1.next;
            head2 = head2.next;
            if (prev == null) resultHead = node;
            else prev.next = node;
            prev = node;
        }
        while (head1 != null) {
            int sum = head1.data + carry;
            LinkedListNode node = new LinkedListNode(sum % 10);
            carry = sum / 10;
            prev.next = node;
            prev = node;
            head1 = head1.next;
        }
        while (head2 != null) {
            int sum = head2.data + carry;
            LinkedListNode node = new LinkedListNode(sum % 10);
            carry = sum / 10;
            prev.next = node;
            prev = node;
            head2 = head2.next;
        }
        if (carry == 1) {
            LinkedListNode node = new LinkedListNode(1);
            prev.next = node;
        }
        return resultHead;
    }

    private LinkedListNode addIntegersBS(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode resultHead = null;
        LinkedListNode prev = null;
        int carry = 0;
        while (head1 != null || head2 != null || carry > 0) {
            int sum = carry;
            if (head1 != null) sum = sum + head1.data;
            if (head2 != null) sum = sum + head2.data;
            LinkedListNode node = new LinkedListNode(sum % 10);
            carry = sum / 10;
            if (prev == null) resultHead = node;
            else prev.next = node;
            prev = node;

            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }
        return resultHead;
    }
}
