package ReAttempt.Trees;

import Common.Problem;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorABinaryTree extends Problem {
    @Override
    public void run() {
        System.out.println("Running Diameter Of Binary Tree");
        String[][] input = new String[][]{{"1-L-2", "1-R-3", "2-L-4", "2-R-5", "3-R-6", "5-L-7", "5-R-8",
                "6-R-9", "9-L-10", "9-R-11", "10-R-12"}, {"1-L-2", "1-R-3", "2-L-4", "2-R-5","4-L-6", "4-R-7", "5-R-8",
                "7-L-9", "8-L-10", "8-R-11", "9-R-12"}};
        this.execute(input);
    }

    private void execute(String[][] input) {
        for (int i = 0; i < input.length; i++) {
            BinaryTree bt = new BinaryTree();
            for (int j = 0; j < input[i].length; j++) {
                bt.insertCustom(input[i][j]);
            }
            System.out.println("Input: ");
            bt.printBT();
            System.out.print ("In Order Traversal Iterative: ");
            bt.inOrderTraversalIterative();
            this.mirrorBinaryTree(bt);
            System.out.print ("In Order Traversal Iterative: ");
            bt.inOrderTraversalIterative();
        }
    }

    private void mirrorBinaryTree(BinaryTree bt) {
        if (bt == null || bt.root == null) return;
        BinaryTreeNode curr = bt.root;
        Queue<BinaryTreeNode> holdingQueue = new LinkedList<>();
        holdingQueue.add(curr);
        while (!holdingQueue.isEmpty()) {
            curr = holdingQueue.poll();
            BinaryTreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) holdingQueue.add(curr.left);
            if (curr.right != null) holdingQueue.add(curr.right);
        }
    }
}
