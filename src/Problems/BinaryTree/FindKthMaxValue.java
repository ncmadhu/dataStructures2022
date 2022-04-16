package Problems.BinaryTree;

import Common.Problem;
import Problems.Stacks.Stack;

import java.util.ArrayList;

public class FindKthMaxValue extends Problem {


    @Override
    public void run() {
        System.out.println("Running Find Kth Max Value in BST");
        int k;
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(6);
        bst.add(4);
        bst.add(9);
        bst.add(5);
        bst.add(2);
        bst.add(8);
        bst.add(12);
        bst.add(10);
        bst.add(14);
        System.out.println("In Order Tree:");
        bst.inOrderTraversalStack();
        k = 3;
        int kthMax = this.findKthMax(bst.getRoot(), k);
        System.out.println("Kth Max value is: " + kthMax);
        kthMax = this.findKthMaxRecursion(bst.getRoot(), k);
        System.out.println("Kth Max value (Recursion) is: " + kthMax);
        System.out.println("Kth Max value (Better Solution) is: " + this.findKthMaxBetterSolution(
                bst.getRoot(), k));
    }

    // In order traversal gives the element in increasing (non-decreasing order)
    // traverse in order , populate list, get last kth from list
    // Time complexity O(n)
    private int findKthMax(Node node, int k) {
        if (node == null) return -1;
        ArrayList<Integer> values =  new ArrayList<>();
        Node currNode = node;
        Stack<Node> nodes =  new Stack<>(10);
        while (currNode != null || !nodes.isEmpty()) {
            while (currNode != null) {
                nodes.push(currNode);
                currNode = currNode.getLeftChild();
            }
            currNode = nodes.pop();
            values.add(currNode.getData());
            currNode = currNode.getRightChild();
        }
        int kthMax = values.get(values.size() - k);
        return kthMax;
    }

    private int findKthMaxRecursion(Node node, int k) {
        ArrayList<Integer> values = new ArrayList<>();
        this.findKthMaxRecursionHelper(node, values);
        int kthMax = values.get(values.size() - k);
        return kthMax;
    }

    private void findKthMaxRecursionHelper(Node node, ArrayList<Integer> values) {
        if (node == null) return;
        findKthMaxRecursionHelper(node.getLeftChild(), values);
        values.add(node.getData());
        findKthMaxRecursionHelper(node.getRightChild(), values);
    }

    // Better solution
    // Do recursive search starting from the right side, since right side has the larger values
    // Use a counter to track number of nodes visited
    // when counter matches k return the node value
    int counter; // object variable
    public int findKthMaxBetterSolution(Node node, int k) {
        this.counter = 0;
        node =  this.findKthMaxBetterSolutionRecursion(node, k);
        if (node == null) return -1;
        return node.getData();
    }

    private Node findKthMaxBetterSolutionRecursion(Node node, int k) {
        if (node == null) return null;

        Node currNode = this.findKthMaxBetterSolutionRecursion(node.getRightChild(), k);
        // This if condition is important, while backtracking to preserve the returned node value
        if (this.counter != k) {
            // increment counter
            this.counter += 1;
            currNode = node;
        }
        if (this.counter == k) {
            return currNode;
        } else {
            // Traverse left child if any
            return this.findKthMaxBetterSolutionRecursion(node.getLeftChild(), k);
        }
    }
}
