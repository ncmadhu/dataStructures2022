package Problems.LinkedLists;

import Common.Problem;
import Utils.DoublyLinkedList;

public class DoublyLinkedListIsPalindrome extends Problem {
    @Override
    public void run() {
        System.out.println("Running Doubly Linked List Is A Palindrome");
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.insertAtHead(2);
        dll.insertAtHead(0);
        dll.insertAtHead(0);
        dll.insertAtHead(2);
        System.out.print("Input: ");
        dll.printList();
        System.out.println("Is Palindrome: " + this.isPalindrome(dll));
        dll = new DoublyLinkedList<>();
        dll.insertAtHead(2);
        dll.insertAtHead(0);
        dll.insertAtHead(1);
        dll.insertAtHead(0);
        dll.insertAtHead(2);
        System.out.print("Input: ");
        dll.printList();
        System.out.println("Is Palindrome: " + this.isPalindrome(dll));
        dll = new DoublyLinkedList<>();
        dll.insertAtHead(3);
        dll.insertAtHead(2);
        dll.insertAtHead(1);
        dll.insertAtHead(0);
        dll.insertAtHead(2);
        System.out.print("Input: ");
        dll.printList();
        System.out.println("Is Palindrome: " + this.isPalindrome(dll));
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
