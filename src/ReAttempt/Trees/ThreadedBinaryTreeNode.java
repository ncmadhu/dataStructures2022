package ReAttempt.Trees;

public class ThreadedBinaryTreeNode {
    public int data;
    public int height;
    public boolean rightThread;
    public ThreadedBinaryTreeNode left;
    public ThreadedBinaryTreeNode right;

    public ThreadedBinaryTreeNode(int data) {
        this.data = data;
        this.height = 0;
        this.left = null;
        this.right = null;
        this.rightThread = false;
    }
}
