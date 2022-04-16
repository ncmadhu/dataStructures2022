package Problems.LinkedLists;

import Common.Problem;
import Utils.ListNode;

public class MiddleOfTheLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Middle Of The Linked List");
        ListNode head, middle;
        head = ListNode.generateList(new int[]{1,2,3,4,5});
        System.out.print("Input: ");
        ListNode.printList(head);
        middle = middleNode(head);
        System.out.print("Output: ");
        ListNode.printList(middle);
        head = ListNode.generateList(new int[]{1,2,3,4,5,6});
        System.out.print("Input: ");
        ListNode.printList(head);
        middle = middleNode(head);
        System.out.print("Output: ");
        ListNode.printList(middle);
        head = ListNode.generateList(new int[]{1,2,3,4,5,6,7});
        System.out.print("Input: ");
        ListNode.printList(head);
        middle = middleNode(head);
        System.out.print("Output: ");
        ListNode.printList(middle);
        head = ListNode.generateList(new int[]{1,2,3,4,5,6,7,8});
        System.out.print("Input: ");
        ListNode.printList(head);
        middle = middleNode(head);
        System.out.print("Output: ");
        ListNode.printList(middle);
    }

    public ListNode middleNode(ListNode head) {
        ListNode oneMove = head, doubleMove = head;
        while (doubleMove.next != null) {
            oneMove = oneMove.next;
            if (doubleMove.next.next != null) {
                doubleMove = doubleMove.next.next;
            } else {
                break;
            }
        }
        return oneMove;
    }
}
