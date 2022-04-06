package Algorithms.BinaryTree;

import Algorithms.Algorithms;

public class TestBinaryTreeTraversal extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Test Binary Tree Traversal");
        BinarySearchTree bst;
        bst = new BinarySearchTree();
        bst.add(6);
        bst.add(4);
        bst.add(9);
        bst.add(2);
        bst.add(5);
        bst.add(8);
        bst.add(12);
        System.out.println("Pre Order Traversal -- > Node --> Left --> Right");
        bst.preOrderTraversalRecursion();
        bst.preOrderTraversalStack();
        System.out.println("In Order Traversal -- > Left --> Node --> Right");
        bst.inOrderTraversalRecursion();
        bst.inOrderTraversalStack();
        System.out.println("Post Order Traversal -- > Left --> Right --> Node");
        bst.postOrderTraversalRecursion();
        bst.postOrderTraversalTwoStack();
        bst.postOrderTraversalOneStackMethod1();
        bst.postOrderTraversalOneStackMethod2();
    }
}
