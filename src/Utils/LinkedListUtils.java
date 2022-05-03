package Utils;

public class LinkedListUtils {

    public static <T> SinglyLinkedList insertNodesNTimes(int n) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            sll.insertAtEnd(i);
        }
        return sll;
    }

    public static <T> SinglyLinkedList generateListFromArray(int[] arr) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            sll.insertAtEnd(arr[i]);
        }
        return sll;
    }

    public static <T> DoublyLinkedList generateDoublyLinkedListFromArray(int[] arr) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            dll.insertAtTail(arr[i]);
        }
        return dll;
    }

    public static LinkedList generateLinkedListFromArray(int[] arr) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            list.insertAtTail(arr[i]);
        }
        return list;
    }
}
