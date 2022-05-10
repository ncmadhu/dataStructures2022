package ReAttempt.LinkedLists;

import Common.Problem;
import Utils.ListNode;

public class RemoveNthNodeFromEnd extends Problem {
    @Override
    public void run() {
        System.out.println("Running Remove Nth Node From End Of List");
        int[][] input = new int[][]{{1}, {1}, {1, 2, 3, 4, 5}, {1}, {1, 2, 3, 4, 5}, {4}, {1, 2, 3, 4, 5}, {5}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            ListNode head, nthDeleted;
            head = ListNode.generateList(input[i]);
            System.out.print("Input: ");
            ListNode.printList(head);
            System.out.println("Nth Node From End: " + input[i+1][0]);
            nthDeleted = removeNthFromEndAlt(head,input[i+1][0]);
            System.out.print("Output: ");
            ListNode.printList(nthDeleted);
            head = ListNode.generateList(input[i]);
            nthDeleted = reAttempt(head,input[i+1][0]);
            System.out.print("Output (Re Attempt): ");
            ListNode.printList(nthDeleted);
        }
    }

    private ListNode reAttempt(ListNode head, int n) {
        if (head == null) return head;
        ListNode curr, prev, temp;
        int count, size;
        count = size = 0;
        curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        if (size < n) return head;
        int nodeDeleted = size - n;
        curr = head;
        prev = null;
        while (count < nodeDeleted && curr != null) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        if (prev == null) head = curr.next;
        else prev.next = curr.next;
        return head;
    }

    private ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        int size = 0;
        ListNode prev, curr;
        curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        int count = size;
        prev = null;
        curr = head;
        while (curr != null) {
            if (count == n) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    //Head node condition
                    head = curr.next;
                }
                break;
            } else {
                prev = curr;
                curr = curr.next;
                count--;
            }
        }
        return head;
    }

    public ListNode removeNthFromEndAlt(ListNode head, int n) {
        if (head == null) return head;
        ListNode ahead, behind, prev;
        int count = 0;
        ahead = head;
        while (count < n && ahead != null) {
            ahead = ahead.next;
            count++;
        }
        behind = head;
        prev = null;
        while (ahead != null) {
            prev = behind;
            behind = behind.next;
            ahead = ahead.next;
        }
        if (prev == null) {
            //Head node condition
            head = behind.next;
        } else {
            prev.next = behind.next;
        }
        return head;
    }
}
