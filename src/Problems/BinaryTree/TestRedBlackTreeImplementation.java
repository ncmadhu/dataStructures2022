package Problems.BinaryTree;

import Common.Problem;

public class TestRedBlackTreeImplementation extends Problem {
    @Override
    public void run() {
        System.out.println("Running Testing Red Black Tree Implementation");
        RedBlackTree redBlackTree = new RedBlackTree();
        System.out.print("Red Black Tree : ");
        redBlackTree.add(10);
        redBlackTree.add(18);
        redBlackTree.add(7);
        redBlackTree.add(15);
        redBlackTree.add(16);
        redBlackTree.add(30);
        redBlackTree.add(25);
        redBlackTree.add(40);
        redBlackTree.add(60);
        redBlackTree.add(2);
        redBlackTree.add(1);
        redBlackTree.add(70);
        redBlackTree.preOrderTraversalStack();
    }
}
