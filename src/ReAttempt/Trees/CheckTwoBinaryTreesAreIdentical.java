package ReAttempt.Trees;

import Common.Problem;

import java.util.LinkedList;
import java.util.Queue;

public class CheckTwoBinaryTreesAreIdentical extends Problem {
    @Override
    public void run() {
        System.out.println("Running Diameter Of Binary Tree");
        String[][] input = new String[][]{
                {"100-L-50", "100-R-200", "50-L-25", "200-L-125", "200-R-350"},
                {"100-L-50", "100-R-200", "50-L-25", "200-L-125", "200-R-350"},
                {"1-L-2", "1-R-3", "2-L-4", "4-L-5","5-L-6"},
                {"1-L-2", "1-R-3", "3-R-4", "4-R-5","5-R-6"},
        };
        this.execute(input);
    }

    private void execute(String[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            BinaryTree btOne = new BinaryTree();
            for (int j = 0; j < input[i].length; j++) {
                btOne.insertCustom(input[i][j]);
            }
            System.out.println("Binary Tree 1: ");
            btOne.printBT();
            BinaryTree btTwo = new BinaryTree();
            for (int j = 0; j < input[i+1].length; j++) {
                btTwo.insertCustom(input[i+1][j]);
            }
            System.out.println("Binary Tree 2: ");
            btTwo.printBT();
            System.out.println("Identical: " + this.checkIdentical(btOne, btTwo));
            System.out.println("Identical (Recursion): " + this.checkIdenticalRec(btOne, btTwo));
        }
    }

    private boolean checkIdenticalRec(BinaryTree btOne, BinaryTree btTwo) {
        if (btOne == null || btTwo == null) return false;
        return checkIdenticalRec(btOne.root, btTwo.root);
    }

    private boolean checkIdenticalRec(BinaryTreeNode node1, BinaryTreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.data != node2.data) return false;
        return this.checkIdenticalRec(node1.left, node2.left) && this.checkIdenticalRec(node1.right, node2.right);
    }

    private boolean checkIdentical(BinaryTree btOne, BinaryTree btTwo) {
        if (btOne == null || btTwo == null) return false;
        if (btOne.root == null || btTwo.root == null) return false;
        Queue<BinaryTreeNode> q1 = new LinkedList<>();
        Queue<BinaryTreeNode> q2 = new LinkedList<>();
        BinaryTreeNode curr1 = btOne.root;
        BinaryTreeNode curr2 = btTwo.root;
        q1.add(curr1);
        q2.add(curr2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            curr1 = q1.poll();
            curr2 = q2.poll();
            if (curr1.data != curr2.data) return false;
            if (curr1.left == null && curr2.left == null) {

            }
            else if (curr1.left != null && curr2.left != null) {
                q1.add(curr1.left);
                q2.add(curr2.left);
            } else return false;
            if (curr1.right != null && curr2.right != null) {
                q1.add(curr1.right);
                q2.add(curr2.right);
            } else if ((curr1.right == null && curr2.right != null) ||
                    (curr1.right != null && curr2.right == null)) return false;
        }
        return true;
    }
}
