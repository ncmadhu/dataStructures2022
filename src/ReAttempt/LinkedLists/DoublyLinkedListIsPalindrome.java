package ReAttempt.LinkedLists;

import Common.Problem;
import Utils.DoublyLinkedList;
import Utils.LinkedListUtils;

public class DoublyLinkedListIsPalindrome extends Problem {
    @Override
    public void run() {
        System.out.println("Running Doubly Linked List Is A Palindrome");
        int[][] input = new int[][]{{2, 0, 0, 2}, {2, 0, 0, 0, 2}, {1, 2, 3, 1, 2}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            DoublyLinkedList<Integer> dll = LinkedListUtils.generateDoublyLinkedListFromArray(input[i]);
            System.out.print("Input: ");
            dll.printList();
            System.out.println("Is Palindrome: " + this.isPalindrome(dll));
            System.out.println("Is Palindrome (Re Attempt): " + this.reAttempt(dll));
        }
    }

    private <T> boolean reAttempt(DoublyLinkedList<T> dll) {
        if (dll.isEmpty()) return false;
        DoublyLinkedList<T>.Node front = dll.getHeadNode();
        DoublyLinkedList<T>.Node back = dll.getTailNode();
        while (front != back) {
            if (front.data != back.data) return false;
            front = front.nextNode;
            if (front == back) return true;
            back = back.prevNode;
        }
        return true;
    }

    public <T> boolean isPalindrome(DoublyLinkedList<T> dll) {
        if (dll.isEmpty()) return false;
        DoublyLinkedList<T>.Node front = dll.getHeadNode();
        DoublyLinkedList<T>.Node back = dll.getTailNode();
        while (front != back) {
            if (front.data != back.data) return false;
            front = front.nextNode;
            if (front == back) return true; // Handling even number of elements
            back = back.prevNode;
        }
        return true;
    }
}
