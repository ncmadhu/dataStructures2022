package ReAttempt.LinkedLists;

import Common.Problem;
import Utils.LinkedListUtils;
import Utils.SinglyLinkedList;
import Utils.SinglyLinkedList.Node;

import java.util.HashMap;
import java.util.HashSet;

public class RemoveDuplicatesFromLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Remove Duplicates From Linked List");
        int[][] input = new int[][]{{7, 14, 14, 14, 21, 22, 14}, {14, 14}, {12, 12, 1, 12}, {1,2,3,4,1}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            SinglyLinkedList<Integer> sll = LinkedListUtils.generateListFromArray(input[i]);
            System.out.print("Input: ");
            sll.printList();
            this.removeDuplicates(sll);
            System.out.print("Output: ");
            sll.printList();
            sll = LinkedListUtils.generateListFromArray(input[i]);
            this.reAttempt(sll);
            System.out.print("Output (Re Attempt): ");
            sll.printList();
        }
    }

    private void reAttempt(SinglyLinkedList<Integer> sll) {
        if (sll.isEmpty()) return;
        HashSet<Integer> visited = new HashSet<>();
        SinglyLinkedList<Integer>.Node curr = sll.headNode;
        SinglyLinkedList<Integer>.Node prev = null;
        while (curr != null) {
            if (visited.contains(curr.data)) {
                prev.nextNode = curr.nextNode;
            } else {
                visited.add(curr.data);
                prev = curr;
            }
            curr = curr.nextNode;
        }
    }

    public <T> void removeDuplicates(SinglyLinkedList<T> list) {
        if (list.isEmpty()) return;
        Node prev = null;
        Node curr = list.headNode;
        HashMap<Object,Object> visited = new HashMap<>();
        while(curr != null) {
            if(visited.containsKey(curr.data)) {
                prev.nextNode = curr.nextNode;
            } else {
                visited.put(curr.data, curr.data);
                prev =  curr;
            }
            curr = curr.nextNode;
        }
    }
}
