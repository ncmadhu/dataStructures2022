package ReAttempt.Trees;

import Common.Problem;

public class TestThreadedBinaryTree extends Problem {


    @Override
    public void run() {
        System.out.println("Running Test Threaded Binary Tree Implementation");
        int[][] input = new int[][]{{1},{2,3,4,5,6,7}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i+2) {
            this.testTBTImplementation(input[i][0],input[i+1]);
        }
    }

    private void testTBTImplementation(int parent, int[] children) {
        ThreadedBinaryTree tbt = new ThreadedBinaryTree(parent, children);
        System.out.print ("TBT: ");
        tbt.printTBT();
        System.out.print ("In Order Traversal Iterative: ");
        tbt.inOrderTraversalTBT();
        System.out.println("Insert : 7 - > 8 9");
        tbt.insertCustom(7, new int[]{8,9});
        System.out.print ("TBT: ");
        tbt.printTBT();
        System.out.print ("In Order Traversal Iterative: ");
        tbt.inOrderTraversalTBT();
    }
}
