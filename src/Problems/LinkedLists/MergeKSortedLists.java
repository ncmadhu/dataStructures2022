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

    private List<LinkedListNode> generateInput(int[][] input, int index) {
        LinkedList list1 = LinkedListUtils.generateLinkedListFromArray(input[index]);
        System.out.println("List 1: ");
        list1.displayLinkedList();
        LinkedList list2 = LinkedListUtils.generateLinkedListFromArray(input[index+1]);
        System.out.println("List 2: ");
        list2.displayLinkedList();
        LinkedList list3 = LinkedListUtils.generateLinkedListFromArray(input[index+2]);
        System.out.println("List 3: ");
        list3.displayLinkedList();
        List<LinkedListNode> lists = new ArrayList<>();
        lists.add(list1.head);
        lists.add(list2.head);
        lists.add(list3.head);
        return lists;
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 3) {
            LinkedList merged = new LinkedList();
            merged.head = this.mergeKSortedLists(this.generateInput(input, i));
            System.out.println("Merged: ");
            merged.displayLinkedList();
            List<LinkedListNode> lists = this.generateInput(input, i);
            merged.head = this.mergeTwoLinkedLists(lists.get(0), lists.get(1));
            System.out.println("Merge Two Lists: ");
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

    private LinkedListNode mergeTwoLinkedLists(LinkedListNode headOne, LinkedListNode headTwo) {
        LinkedListNode list1 = headOne;
        LinkedListNode list2 = headTwo;
        LinkedListNode prev = null;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                prev = list1;
                list1 = list1.next;
            } else {
                if (prev != null) prev.next = list2;
                prev = list2;
                list2 = list2.next;
                prev.next = list1;
            }
        }
        if (list1 == null) prev.next = list2;
        return headOne.data < headTwo.data ? headOne : headTwo;
    }


}
