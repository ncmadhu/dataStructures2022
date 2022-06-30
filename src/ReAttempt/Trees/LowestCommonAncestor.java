package ReAttempt.Trees;

import Common.Problem;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor extends Problem {
    @Override
    public void run() {
        System.out.println("Running Lowest Common Ancestor of Binary Tree");
        int[][] input = new int[][]{{1,2,3,4,5,6,7}, {4,5}, {1,2,3,4,5,6,7,8,9,10,11}, {8,11},
                {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}, {8,15}, {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}, {8,16}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i+2) {
            BinaryTree bt = new BinaryTree(input[i]);
            System.out.print ("BT: ");
            bt.printBT();
            System.out.println("LCA Of " + input[i+1][0] +" and " + input[i+1][1] + ": " + this.findLca(bt,
                    input[i+1][0],input[i+1][1]));
            System.out.println("LCA (Rec) Of " + input[i+1][0] +" and " + input[i+1][1] + ": " + this.findLcaRec(bt,
                    input[i+1][0],input[i+1][1]));
        }
    }

    private int findLca(BinaryTree bt, int n1, int n2) {
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        this.findLca(bt.root, n1, path1);
        this.findLca(bt.root, n2, path2);
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            // break when non-equal value is found that means the path is diverging
            if (!path1.get(i).equals(path2.get(i))) break;
        }
        return path1.get(i-1);
    }

    private boolean findLca(BinaryTreeNode node, int n, List<Integer> path) {
        if (node == null) return false;

        path.add(node.data);
        if (node.data == n) return true;
        if (node.left != null && this.findLca(node.left, n, path)) return true;
        if (node.right != null && this.findLca(node.right, n, path)) return true;

        // Current node is not in the path hence remove it
        path.remove(path.size() - 1);
        return false;
    }
    private int findLcaRec(BinaryTree bt, int n1, int n2) {
        return findLcaRec(bt.root, n1, n2);
    }

    private int findLcaRec(BinaryTreeNode node, int n1, int n2) {
        if (node == null) return -1;
        if (node.data == n1 || node.data == n2) return node.data;
        int left_lca = this.findLcaRec(node.left, n1, n2);
        int right_lca = this.findLcaRec(node.right, n1, n2);
        // If both the left and right return non-negative value that means current node is the common ancestor
        if (left_lca != -1 && right_lca != -1) return node.data;
        // If one of the branches returned non-negative value that means other value is in other side of the tree
        return left_lca != -1 ? left_lca : right_lca;
    }
}
