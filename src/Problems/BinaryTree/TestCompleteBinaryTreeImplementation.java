package Problems.BinaryTree;

import Common.Problem;

public class TestCompleteBinaryTreeImplementation extends Problem {
    @Override
    public void run() {
        System.out.println("Running Testing Complete Binary Tree Implementation");
        Node temp;
        CompleteBinaryTree cbt = new CompleteBinaryTree();
        cbt.insert(1);
        cbt.insert(2);
        cbt.insert(3);
        cbt.insert(4);
        cbt.insert(5);
        cbt.insert(6);
        cbt.insert(7);
        cbt.insert(8);
        cbt.insert(9);
        System.out.print("Complete Binary Tree : ");
        cbt.printTree(cbt.getRoot());

    }


}
