package ReAttempt.Trees;

public class BinaryTreeNode {
    public int data;
    public int height;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
        this.height = 0;
    }
}
