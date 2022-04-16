package Problems.LinkedLists;

import Common.Problem;
import Utils.ListNode;

public class DeleteMiddleOfLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Delete Middle Of Linked List");
        ListNode head, middleDeleted;
        head = ListNode.generateList(new int[]{1});
        System.out.print("Input: ");
        ListNode.printList(head);
        middleDeleted = deleteMiddle(head);
        System.out.print("Output: ");
        ListNode.printList(middleDeleted);
        head = ListNode.generateList(new int[]{1,2,3,4,5});
        System.out.print("Input: ");
        ListNode.printList(head);
        middleDeleted = deleteMiddle(head);
        System.out.print("Output: ");
        ListNode.printList(middleDeleted);
        head = ListNode.generateList(new int[]{1,2,3,4,5,6});
        System.out.print("Input: ");
        ListNode.printList(head);
        middleDeleted = deleteMiddle(head);
        System.out.print("Output: ");
        ListNode.printList(middleDeleted);
        head = ListNode.generateList(new int[]{1,2,3,4,5,6,7});
        System.out.print("Input: ");
        ListNode.printList(head);
        middleDeleted = deleteMiddle(head);
        System.out.print("Output: ");
        ListNode.printList(middleDeleted);
        head = ListNode.generateList(new int[]{1,2,3,4,5,6,7,8});
        System.out.print("Input: ");
        ListNode.printList(head);
        middleDeleted = deleteMiddle(head);
        System.out.print("Output: ");
        ListNode.printList(middleDeleted);
    }

    public ListNode deleteMiddle(ListNode head) {

        ListNode oneMove = head, prev = null, doubleMove = head;
        while(doubleMove != null && doubleMove.next != null) {
            prev = oneMove;
            oneMove = oneMove.next;
            doubleMove = doubleMove.next.next;
        }
        if (prev != null) {
            prev.next = oneMove.next;
            return head;
        } else {
            return prev;
        }
    }
}
