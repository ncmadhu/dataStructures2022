package Algorithms.BinaryTree;

import Algorithms.Algorithms;

public class TestAVLTreeImplementation extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Testing AVL Tree Implementation");
        AVLTree avlTree = new AVLTree();
        avlTree.add(50);
        avlTree.add(40);
        avlTree.add(35);
        avlTree.add(30);
        avlTree.add(20);
        avlTree.add(10);
        avlTree.add(5);
        System.out.print("AVL Tree : ");
        avlTree.preOrderTraversalStack();
        avlTree.delete(35);
        avlTree.preOrderTraversalStack();
        avlTree.delete(50);
        avlTree.preOrderTraversalStack();
        avlTree.delete(40);
        avlTree.preOrderTraversalStack();

    }
}
