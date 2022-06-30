package ReAttempt.Trees;

import Common.Problem;

public class TestBinaryTree extends Problem {


    @Override
    public void run() {
        System.out.println("Running Test Binary Tree Implementation");
        int[][] input = new int[][]{{1,2,3,4,5,6,7}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            this.testBTImplementation(input[i]);
        }
    }

    private void testBTImplementation(int[] arr) {
        BinaryTree bt = new BinaryTree(arr);
        System.out.print ("BT: ");
        bt.printBT();
        BinaryTree cloneIterative = bt.cloneBTIterative();
        System.out.print ("Cloned Iteratively: ");
        cloneIterative.printBT();
        BinaryTree cloneRecursive = bt.cloneRecursiveBT();
        System.out.print ("Cloned Recursively: ");
        cloneRecursive.printBT();
        System.out.print ("Pre Order Traversal Iterative: ");
        bt.preOrderTraversalIterative();
        System.out.print ("Pre Order Traversal Recursive: ");
        bt.preOrderTraversalRecursive();
        System.out.print ("Post Order Traversal Iterative: ");
        bt.postOrderTraversalIterative();
        System.out.print ("Post Order Traversal Recursive: ");
        bt.postOrderTraversalRecursive();
        System.out.print ("In Order Traversal Iterative: ");
        bt.inOrderTraversalIterative();
        System.out.print ("In Order Traversal Recursive: ");
        bt.inOrderTraversalRecursive();
        System.out.print ("Level Order Traversal Iterative: ");
        bt.levelOrderTraversal();
        bt.deleteNode(3);
        System.out.print ("After deleting 3: ");
        bt.levelOrderTraversal();
        bt.deleteNode(9);
        System.out.print ("After deleting 9: ");
        bt.levelOrderTraversal();
    }
}
