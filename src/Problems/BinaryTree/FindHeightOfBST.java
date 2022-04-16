package Problems.BinaryTree;

import Common.Problem;

public class FindHeightOfBST extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find Height Of BST");
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
        System.out.println("Height of BST is: " + this.findHeight(bst.getRoot()));
    }

    private int findHeight(Node node) {
        if (node == null || node.getLeftChild() == null && node.getRightChild() == null) return 0;
        int height = 1 + Math.max(this.findHeight(node.getLeftChild()), this.findHeight(node.getRightChild()));
        return height;
    }


}
