package Problems.BinaryTree;

import Common.Problem;

public class FindMinimumInBST extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find Minimum in BST");
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
        System.out.println("Pre Order Tree:");
        bst.preOrderTraversalStack();
        Node minNode = this.findMinimum(bst.getRoot());
        int min = Integer.MIN_VALUE;
        if (minNode != null) {
            min = minNode.getData();
        }
        System.out.println("Minimum in BST is: " + min);
    }

    public Node findMinimum(Node node) {
        if (node == null) return null;
        Node currNode = node;
        while (currNode.getLeftChild() != null) {
            currNode = currNode.getLeftChild();
        }
        return currNode;
    }

}
