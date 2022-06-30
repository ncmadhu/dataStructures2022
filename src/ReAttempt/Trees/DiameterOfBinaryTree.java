package ReAttempt.Trees;

import Common.Problem;

public class DiameterOfBinaryTree extends Problem {
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
            System.out.println("Diameter : " + this.diameter(bt));
        }
    }

    private int diameter(BinaryTree bt) {
        return this.diameter(bt.root);
    }

    private int diameter(BinaryTreeNode node) {
        if (node == null) return 0;
        int lHeight = this.height(node.left);
        int rHeight = this.height(node.right);

        int lDiameter = this.diameter(node.left);
        int rDiameter = this.diameter(node.right);

        return Math.max(1 + lHeight + rHeight, Math.max(lDiameter, rDiameter));
    }

    private int height(BinaryTreeNode node) {
        if (node == null) return 0;
        return (1 + Math.max(this.height(node.left), this.height(node.right)));
    }
}
