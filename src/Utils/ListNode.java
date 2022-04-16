package Utils;

public class ListNode {
    int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode generateList(int[] nums) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        for(int num : nums) {
            ListNode next = new ListNode();
            curr.next = next;
            next.val = num;
            curr = next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
            if (curr != null) {
                System.out.print(',');
            }
        }
        System.out.print('\n');
    }
}
