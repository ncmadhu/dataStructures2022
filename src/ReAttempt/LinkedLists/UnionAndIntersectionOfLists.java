package ReAttempt.LinkedLists;

import Common.Problem;
import Utils.LinkedListUtils;
import Utils.SinglyLinkedList;
import Utils.SinglyLinkedList.Node;

import java.util.HashSet;

public class UnionAndIntersectionOfLists extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find Union And Intersection Of Linked List");
        int[][] input = new int[][]{{7, 14, 21, 22}, {14, 15, 16}, {15, 22, 8}, {7, 14, 22}, {14,15,16}, {16, 15}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            SinglyLinkedList<Integer> sll1 = LinkedListUtils.generateListFromArray(input[i]);
            System.out.print("List 1: ");
            sll1.printList();
            SinglyLinkedList<Integer> sll2 = LinkedListUtils.generateListFromArray(input[i + 1]);
            System.out.print("List 2: ");
            sll2.printList();
            SinglyLinkedList<Integer> intersection;
            intersection = this.reAttemptIntersection(sll1,sll2);
            System.out.print("Intersection (Re Attempt): ");
            intersection.printList();
            intersection = this.intersection(sll1,sll2);
            System.out.print("Intersection: ");
            intersection.printList();
            SinglyLinkedList<Integer> union;
            union = this.reAttemptUnion(sll1, sll2);
            System.out.print("Union (Re Attempt): ");
            union.printList();
            union = this.union(sll1,sll2);
            System.out.print("Union: ");
            union.printList();
        }
    }

    private <T> SinglyLinkedList<T> reAttemptUnion(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        SinglyLinkedList<T> union = new SinglyLinkedList<>();
        SinglyLinkedList<T>.Node curr = list1.headNode;
        HashSet<T> nodeValues = new HashSet<>();
        while (curr != null) {
            union.insertAtEnd(curr.data);
            nodeValues.add(curr.data);
            curr = curr.nextNode;
        }
        curr = list2.headNode;
        while (curr != null) {
            if (!nodeValues.contains(curr.data)) {
                nodeValues.add(curr.data);
                union.insertAtEnd(curr.data);
            }
            curr = curr.nextNode;
        }
        return union;
    }

    private <T> SinglyLinkedList<T> reAttemptIntersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> intersection = new SinglyLinkedList<>();
        if (list1.isEmpty() || list2.isEmpty()) return intersection;
        HashSet<T> nodeValues = new HashSet<>();
        SinglyLinkedList<T>.Node curr = list1.headNode;
        while (curr != null) {
            nodeValues.add(curr.data);
            curr = curr.nextNode;
        }
        curr = list2.headNode;
        while (curr != null) {
            if (nodeValues.contains(curr.data)) {
                intersection.insertAtEnd(curr.data);
            }
            curr = curr.nextNode;
        }
        return intersection;
    }

    public <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1,SinglyLinkedList<T> list2) {
        if (list1.isEmpty() && list2.isEmpty()) return null;
        if (list1.isEmpty()) return list2;
        if (list2.isEmpty()) return list1;
        //move to the end of the list 1 while tracking visited nodes
        Node curr = list1.headNode;
        Node prev = null;
        HashSet<Object> visitedNodes = new HashSet<>();
        while (curr != null) {
            visitedNodes.add(curr.data);
            prev = curr;
            curr = curr.nextNode;
        }
        curr = list2.headNode;
        prev.nextNode = curr;
        while (curr != null) {
            if (visitedNodes.contains(curr.data)) {
                prev.nextNode = curr.nextNode;
            } else {
                visitedNodes.add(curr.data);
                prev = curr;
            }
            curr = curr.nextNode;
        }
        return list1;
    }

    public <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        if (list1.isEmpty() || list2.isEmpty()) return null;
        SinglyLinkedList<T> intersection = new SinglyLinkedList<>();
        Node curr = list1.headNode;
        HashSet<Object> visitedNodes = new HashSet<>();
        while (curr != null) {
            visitedNodes.add(curr.data);
            curr = curr.nextNode;
        }
        curr = list2.headNode;
        while (curr != null) {
            if (visitedNodes.contains(curr.data)) {
                intersection.insertAtEnd((T)curr.data);
            }
            curr = curr.nextNode;
        }
        return intersection;
    }
}
