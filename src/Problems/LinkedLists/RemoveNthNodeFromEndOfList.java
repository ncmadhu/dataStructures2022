package Problems.LinkedLists;

import Common.Problem;
import Utils.ListNode;

public class RemoveNthNodeFromEndOfList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Remove Nth Node From End Of List");
        int nth;
        ListNode head, nthDeleted;
        nth = 1;
        head = ListNode.generateList(new int[]{1});
        System.out.print("Input: ");
        ListNode.printList(head);
        nthDeleted = removeNthFromEnd(head, nth);
        System.out.print("Output: ");
        ListNode.printList(nthDeleted);
        nth = 1;
        head = ListNode.generateList(new int[]{1,2,3,4,5});
        System.out.print("Input: ");
        ListNode.printList(head);
        nthDeleted = removeNthFromEnd(head, nth);
        System.out.print("Output: ");
        ListNode.printList(nthDeleted);
        nth = 1;
        head = ListNode.generateList(new int[]{1,2,3,4,5,6});
        System.out.print("Input: ");
        ListNode.printList(head);
        nthDeleted = removeNthFromEnd(head, nth);
        System.out.print("Output: ");
        ListNode.printList(nthDeleted);
        nth = 1;
        head = ListNode.generateList(new int[]{1,2,3,4,5,6,7});
        System.out.print("Input: ");
        ListNode.printList(head);
        nthDeleted = removeNthFromEnd(head, nth);
        System.out.print("Output: ");
        ListNode.printList(nthDeleted);
        nth = 1;
        head = ListNode.generateList(new int[]{1,2,3,4,5,6,7,8});
        System.out.print("Input: ");
        ListNode.printList(head);
        nth = 1;
        nthDeleted = removeNthFromEnd(head, nth);
        System.out.print("Output: ");
        ListNode.printList(nthDeleted);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        int slowCount = 0, fastCount = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            slowCount++;
            fast = fast.next.next;
            fastCount++;
        }
        System.out.println(slowCount + fastCount);
        return head;
    }


}
