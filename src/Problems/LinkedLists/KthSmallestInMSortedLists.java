package Problems.LinkedLists;

import Common.Problem;
import Utils.LinkedList;
import Utils.LinkedListNode;
import Utils.LinkedListUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestInMSortedLists extends Problem {
    @Override
    public void run() {
        System.out.println("Running Merge K Sorted Lists");
        int[][] input = new int[][]{{4,7,9}, {1,3,5}, {4,5,9}, {5},
                                    {11,23,50}, {1,6,9}, {0,25, 50}, {1},
                                    {30, 32, 40}, {85, 90}, {30, 32, 40}, {8}};
        this.execute(input);
    }
    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 4) {
            LinkedList<Integer> list1 = LinkedListUtils.generateLinkedListFromArray(input[i]);
            System.out.println("List 1: ");
            list1.displayLinkedList();
            LinkedList<Integer> list2 = LinkedListUtils.generateLinkedListFromArray(input[i+1]);
            System.out.println("List 2: ");
            list2.displayLinkedList();
            LinkedList<Integer> list3 = LinkedListUtils.generateLinkedListFromArray(input[i+2]);
            System.out.println("List 3: ");
            list3.displayLinkedList();
            System.out.println("K: " + input[i+3][0]);
            LinkedList<Integer> merged = new LinkedList<Integer>();
            List<LinkedListNode> lists = new ArrayList<>();
            lists.add(list1.head);
            lists.add(list2.head);
            lists.add(list3.head);
            int kthSmallest = this.findKthSmallestInMSortedLists(lists, input[i+3][0]);
            System.out.println("Kth Smallest : " + kthSmallest);
        }
    }

    private int findKthSmallestInMSortedLists(List<LinkedListNode> lists, int k) {
        PriorityQueue<LinkedListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.data));
        // Add root of each lists to the minHeap
        for (LinkedListNode root : lists) {
            minHeap.add(root);
        }
        int count = 0;
        while (!minHeap.isEmpty()) {
            LinkedListNode node = minHeap.poll();
            count++;
            if (count == k) return node.data;
            if (node.next != null) minHeap.add(node.next);
        }
        return -1;
    }


}
