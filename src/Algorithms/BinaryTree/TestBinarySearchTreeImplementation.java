package Algorithms.BinaryTree;

import Algorithms.Algorithms;

public class TestBinarySearchTreeImplementation extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Testing Binary Search Tree Implementation");
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
        System.out.print("Tree : ");
        bst.printTree(bst.getRoot());
        this.search(bst, 5, "Iterative");
        this.search(bst, 51, "Iterative");
        System.out.print("\nDeleting Node 6: ");
        bst.delete(6);
        bst.printTree(bst.getRoot());
        System.out.print("\nDeleting Node 15: ");
        bst.delete(15);
        bst.printTree(bst.getRoot());
        System.out.print("\nDeleting Node 1: ");
        bst.delete(1);
        bst.printTree(bst.getRoot());

        BinarySearchTree bstRecursion = new BinarySearchTree();
        bstRecursion.addRecursive(6);
        bstRecursion.addRecursive(4);
        bstRecursion.addRecursive(9);
        bstRecursion.addRecursive(5);
        bstRecursion.addRecursive(2);
        bstRecursion.addRecursive(8);
        bstRecursion.addRecursive(12);
        bstRecursion.addRecursive(10);
        bstRecursion.addRecursive(14);
        bstRecursion.printTree(bstRecursion.getRoot());
        this.search(bstRecursion, 5, "Recursion");
        this.search(bstRecursion, 51, "Recursion");

        bst = new BinarySearchTree();
        bst.add(6);
        bst.add(7);
        bst.add(8);
        bst.add(12);
        bst.add(1);
        bst.add(15);
        System.out.print("Tree : ");
        bst.printTree(bst.getRoot());
        System.out.print("\nDeleting Node 6: ");
        bst.delete(6);
        bst.printTree(bst.getRoot());
        System.out.print("\nDeleting Node 15: ");
        bst.delete(15);
        bst.printTree(bst.getRoot());
        System.out.print("\nDeleting Node 1: ");
        bst.delete(1);
        bst.printTree(bst.getRoot());

    }

    public void search(BinarySearchTree bst, int value, String method) {
        Node temp;
        if (method.equals("Recursion")) {
            temp = bst.searchRecursive(value);
        } else {
            temp = bst.search(value);
        }
        if (temp != null)
            System.out.println(temp.getData() + " found in the Tree");
    }


}
