package ReAttempt.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadedBinaryTree {

    public ThreadedBinaryTreeNode root;

    public ThreadedBinaryTree () {
        this.root = null;
    }

    public ThreadedBinaryTree(int[] arr) {
        this.root = null;
        for (int value: arr) {
            this.insertTBT(value);
        }
    }

    public ThreadedBinaryTree(int root, int[] children) {
        this.root = null;
        this.insertCustom(root, children);
    }

    private void insertTBT(int value) {
        if (this.root == null) {
            root = new ThreadedBinaryTreeNode(value);
            return;
        }
        Queue<ThreadedBinaryTreeNode> holdingQueue = new LinkedList<>();
        ThreadedBinaryTreeNode curr = this.root;
        holdingQueue.add(curr);
        while (!holdingQueue.isEmpty()) {
            curr = holdingQueue.poll();
            if (curr.left == null) {
                curr.left = new ThreadedBinaryTreeNode(value);
                curr.left.rightThread = true;
                curr.left.right = curr;
                break;
            } else holdingQueue.add(curr.left);
            if (curr.right == null || curr.rightThread) {
                ThreadedBinaryTreeNode temp = null;
                if (curr.rightThread) temp = curr.right;
                curr.right = new ThreadedBinaryTreeNode(value);
                if (curr.rightThread && temp != null) {
                    curr.right.rightThread = true;
                    curr.right.right = temp;
                    curr.rightThread = false;
                }
                break;
            } else holdingQueue.add(curr.right);
        }
    }

    private ThreadedBinaryTreeNode findNode(int value) {
        if (root == null) return null;
        ThreadedBinaryTreeNode curr = root;
        Queue<ThreadedBinaryTreeNode> holdingQueue = new LinkedList<>();
        holdingQueue.add(curr);
        while (!holdingQueue.isEmpty()) {
            curr = holdingQueue.poll();
            if (curr.data == value) return curr;
            if (curr.left != null) holdingQueue.add(curr.left);
            if (curr.right != null) holdingQueue.add(curr.right);
        }
        return null;
    }

    public void insertCustom(int parent, int[] children) {
        ThreadedBinaryTreeNode curr;
        if (root == null) {
            root = new ThreadedBinaryTreeNode(parent);
            curr = root;
        } else {
            curr = this.findNode(parent);
        }
        int index = 0;
        Queue<ThreadedBinaryTreeNode> holdingQueue = new LinkedList<>();
        holdingQueue.add(curr);
        while (index < children.length) {
            curr = holdingQueue.poll();
            curr.left = new ThreadedBinaryTreeNode(children[index++]);
            curr.left.rightThread = true;
            curr.left.right = curr;
            holdingQueue.add(curr.left);
            if (index == children.length) break;
            ThreadedBinaryTreeNode temp = null;
            if (curr.rightThread) temp = curr.right;
            curr.right = new ThreadedBinaryTreeNode(children[index++]);
            if (curr.rightThread && temp != null) {
                curr.right.rightThread = true;
                curr.right.right = temp;
                curr.rightThread = false;
            }
            holdingQueue.add(curr.right);
        }
    }

    public ThreadedBinaryTreeNode getLeftMost(ThreadedBinaryTreeNode node) {
        if (node == null) return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void inOrderTraversalTBT() {
        if (root == null) {
            System.out.println("NULL");
            return;
        }
        ThreadedBinaryTreeNode curr = this.getLeftMost(root);
        while (curr != null) {
            System.out.print(curr.data + "->");
            if (curr.rightThread) curr = curr.right;
            else curr = this.getLeftMost(curr.right);
        }
        System.out.println("NULL");
    }

    public void printTBT() {
        if (root == null) {
            System.out.println("NULL");
            return;
        }
        Queue<ThreadedBinaryTreeNode> holdingQueue = new LinkedList<>();
        ThreadedBinaryTreeNode curr = root;
        holdingQueue.add(curr);
        while (!holdingQueue.isEmpty()) {
            curr = holdingQueue.poll();
            System.out.print(curr.data + "->");
            if (curr.left != null) holdingQueue.add(curr.left);
            if (!curr.rightThread && curr.right != null) holdingQueue.add(curr.right);
        }
        System.out.println("NULL");
    }
}
