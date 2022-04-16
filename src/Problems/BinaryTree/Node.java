package Problems.BinaryTree;

public class Node {
    private int data;
    Node leftChild;
    Node rightChild;
    int height;

    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
        this.height = 0;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
