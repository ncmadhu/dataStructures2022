package Algorithms.BinaryTree;

import Algorithms.Algorithms;
import Algorithms.Queues.Queue;

public class CompleteBinaryTree {
    Node root;

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node node) {
        this.root = node;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public  void  printTree(Node current) {
        this.printTreeHelper(current);
        System.out.println("--> END");
    }
    public void printTreeHelper(Node current) {
        if (current == null) return;
        System.out.print(current.getData() + ",");
        printTreeHelper(current.getLeftChild());
        printTreeHelper(current.getRightChild());
    }

    public boolean insert(int value) {
        if (isEmpty()) {
            this.root = new Node(value);
            return true;
        }

        Node curr = this.root;
        Queue<Node> nodes = new Queue<>(5);
        nodes.enqueue(curr);
        while (!nodes.isEmpty()) {
            Node temp = nodes.dequeue();
            if (temp.getLeftChild() == null) {
                temp.setLeftChild(new Node(value));
                return true;
            }
            if (temp.getRightChild() == null) {
                temp.setRightChild(new Node(value));
                return true;
            }
            nodes.enqueue(temp.getLeftChild());
            nodes.enqueue(temp.getRightChild());
        }
        return false;
    }
}
