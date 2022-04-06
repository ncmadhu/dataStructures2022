package Algorithms.BinaryTree;

public class RedBlackNode extends Node{
    boolean isRed;
    RedBlackNode parent;

    public RedBlackNode(int data) {
        super(data);
        this.isRed = true;
        this.parent = null;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean isRed) {
        this.isRed = isRed;
    }

    public void setParent(RedBlackNode parent) {
        this.parent = parent;
    }

    public RedBlackNode getParent() {
        return parent;
    }

    @Override
    public RedBlackNode getLeftChild() {
        return (RedBlackNode) super.getLeftChild();
    }

    @Override
    public RedBlackNode getRightChild() {
        return (RedBlackNode) super.getRightChild();
    }

    public void setLeftChild(RedBlackNode node) {
        this.leftChild = node;
    }

    public void setRightChild(RedBlackNode node) {
        this.rightChild = node;
    }
}
