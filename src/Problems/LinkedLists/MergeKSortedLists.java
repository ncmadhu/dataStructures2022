package Problems.LinkedLists;

import Common.Problem;
import Utils.LinkedList;
import Utils.LinkedListNode;
import Utils.LinkedListUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists extends Problem {
    @Override
    public void run() {
        System.out.println("Running Merge K Sorted Lists");
        int[][] input = new int[][]{{4,7,9}, {1,3,5}, {4,5,9},
                                    {11,23,50}, {1,6,9}, {0,25, 50},
                                    {30, 32, 40}, {85, 90}, {30, 32, 40}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 3) {
            LinkedList list1 = LinkedListUtils.generateLinkedListFromArray(input[i]);
            System.out.println("List 1: ");
            list1.displayLinkedList();
            LinkedList list2 = LinkedListUtils.generateLinkedListFromArray(input[i+1]);
            System.out.println("List 2: ");
            list2.displayLinkedList();
            LinkedList list3 = LinkedListUtils.generateLinkedListFromArray(input[i+2]);
            System.out.println("List 3: ");
            list3.displayLinkedList();
            LinkedList merged = new LinkedList();
            List<LinkedListNode> lists = new ArrayList<>();
            lists.add(list1.head);
            lists.add(list2.head);
            lists.add(list3.head);
            merged.head = this.mergeKSortedLists(lists);
            System.out.println("Merged: ");
            merged.displayLinkedList();
        }
    }

    private LinkedListNode mergeKSortedLists(List<LinkedListNode> lists) {
        PriorityQueue<LinkedListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.data));
        // Add root of each lists to the minHeap
        for (LinkedListNode root : lists) {
            minHeap.add(root);
        }
        LinkedListNode resultHead, resultTail;
        resultHead = resultTail = null;
        while (!minHeap.isEmpty()) {
            LinkedListNode node = minHeap.poll();
            if (resultHead == null) resultHead = node;
            else resultTail.next = node;
            resultTail = node;
            // Add the next node from the list which one element was added to the result
            // Idea here is all other lists are still at their smallest number
            if (node.next != null) minHeap.add(node.next);
        }
        return resultHead;
    }


}
