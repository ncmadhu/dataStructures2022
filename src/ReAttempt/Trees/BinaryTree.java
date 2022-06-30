package ReAttempt.Trees;

import java.util.*;


public class BinaryTree {
    public BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int[] arr) {
        root = null;
        for (int data: arr) {
            insertBT(data);
        }
    }

    private void insertBT(int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
            return;
        }
        Queue<BinaryTreeNode> holdingQueue = new LinkedList<>();
        BinaryTreeNode curr = root;
        holdingQueue.add(curr);
        while (!holdingQueue.isEmpty()) {
            curr = holdingQueue.poll();
            if (curr.left == null) {
                curr.left = new BinaryTreeNode(data);
                break;
            } else {
                holdingQueue.add(curr.left);
            }
            if (curr.right == null) {
                curr.right = new BinaryTreeNode(data);
                break;
            } else {
                holdingQueue.add(curr.right);
            }
        }
    }

    public void deleteNode(BinaryTreeNode node) {
        if (this.root == null) return;
        Queue<BinaryTreeNode> holdingQueue = new LinkedList<>();
        BinaryTreeNode curr = this.root;
        holdingQueue.add(curr);
        while (!holdingQueue.isEmpty()) {
            curr = holdingQueue.poll();
            if (curr.left != null) {
                if (curr.left == node) {
                    curr.left = null;
                    return;
                }
                holdingQueue.add(curr.left);
            }
            if (curr.right != null) {
                if (curr.right == node) {
                    curr.right = null;
                    return;
                }
                holdingQueue.add(curr.right);
            }
        }
    }

    public void deleteNode(int value) {
        if (this.root == null) return;
        Queue<BinaryTreeNode> holdingQueue = new LinkedList<>();
        BinaryTreeNode curr = this.root;
        BinaryTreeNode deletionNode = null;
        holdingQueue.add(curr);
        while (!holdingQueue.isEmpty()) {
            curr = holdingQueue.poll();
            if (curr.data == value) deletionNode = curr;
            if (curr.left != null) holdingQueue.add(curr.left);
            if (curr.right != null) holdingQueue.add(curr.right);
        }
        if (deletionNode != null) {
            value = curr.data;
            this.deleteNode(curr);
            deletionNode.data = value;
        }
        return;
    }

    public void printBT() {
        if (root == null) {
            System.out.println("NULL");
            return;
        }
        Queue<BinaryTreeNode> holdingQueue = new LinkedList<>();
        BinaryTreeNode curr = root;
        holdingQueue.add(curr);
        while (!holdingQueue.isEmpty()) {
            curr = holdingQueue.poll();
            System.out.print(curr.data + "->");
            if (curr.left != null) holdingQueue.add(curr.left);
            if (curr.right != null) holdingQueue.add(curr.right);
        }
        System.out.println("NULL");
    }

    public BinaryTree cloneBTIterative() {
        BinaryTree newBT = new BinaryTree();
        if (this.root == null) return newBT;
        Queue<BinaryTreeNode> oldQueue = new LinkedList<>();
        Queue<BinaryTreeNode> newQueue = new LinkedList<>();
        BinaryTreeNode oldTreeNode = this.root;
        newBT.insertBT(oldTreeNode.data);
        BinaryTreeNode newTreeNode = newBT.root;
        oldQueue.add(oldTreeNode);
        newQueue.add(newTreeNode);
        while (!oldQueue.isEmpty()) {
            oldTreeNode = oldQueue.poll();
            newTreeNode = newQueue.poll();
            if (oldTreeNode.left != null) {
                newTreeNode.left = new BinaryTreeNode(oldTreeNode.left.data);
                oldQueue.add(oldTreeNode.left);
                newQueue.add(newTreeNode.left);
            }
            if (oldTreeNode.right != null) {
                newTreeNode.right = new BinaryTreeNode(oldTreeNode.right.data);
                oldQueue.add(oldTreeNode.right);
                newQueue.add(newTreeNode.right);
            }
        }
        return newBT;
    }
    public BinaryTree cloneRecursiveBT() {
        BinaryTree newBT = new BinaryTree();
        newBT.root = this.cloneNode(this.root);
        return newBT;
    }

    private BinaryTreeNode cloneNode(BinaryTreeNode node) {
        if (node == null) return null;
        BinaryTreeNode newNode = new BinaryTreeNode(node.data);
        newNode.left = this.cloneNode(node.left);
        newNode.right = this.cloneNode(node.right);
        return newNode;
    }

    public void preOrderTraversalIterative() {
        if (this.root == null) {
            System.out.println("NULL");
        }
        Stack<BinaryTreeNode> holdingStack = new Stack<>();
        BinaryTreeNode curr = this.root;
        holdingStack.push(curr);
        while (!holdingStack.isEmpty()) {
            curr = holdingStack.pop();
            System.out.print(curr.data + "->");
            if (curr.right != null) holdingStack.push(curr.right);
            if (curr.left != null) holdingStack.push(curr.left);
        }
        System.out.println("NULL");
    }

    public void preOrderTraversalRecursive() {
        this.preOrderTraversalRec(this.root);
        System.out.println("NULL");
    }

    private void preOrderTraversalRec(BinaryTreeNode node) {
        if (node == null) return;
        System.out.print(node.data + "->");
        preOrderTraversalRec(node.left);
        preOrderTraversalRec(node.right);
    }

    public void postOrderTraversalIterative() {
        if (this.root == null) {
            System.out.println("NULL");
        }
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        BinaryTreeNode curr = this.root;
        stack1.push(curr);
        while (!stack1.isEmpty()) {
            curr = stack1.pop();
            if (curr.left != null) stack1.push(curr.left);
            if (curr.right != null) stack1.push(curr.right);
            stack2.push(curr);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + "->");
        }
        System.out.println("NULL");
    }

    public void postOrderTraversalRecursive() {
        this.postOrderTraversalRec(this.root);
        System.out.println("NULL");
    }

    private void postOrderTraversalRec(BinaryTreeNode node) {
        if (node == null) return;
        postOrderTraversalRec(node.left);
        postOrderTraversalRec(node.right);
        System.out.print(node.data + "->");
    }

    public void inOrderTraversalIterative() {
        if (this.root == null) {
            System.out.println("NULL");
        }
        Stack<BinaryTreeNode> holdingStack = new Stack<>();
        BinaryTreeNode curr = this.root;
        while (curr != null || !holdingStack.isEmpty()) {
            while (curr != null) {
                holdingStack.push(curr);
                curr = curr.left;
            }
            curr = holdingStack.pop();
            System.out.print(curr.data + "->");
            curr = curr.right;
        }
        System.out.println("NULL");
    }

    public void inOrderTraversalRecursive() {
        this.inOrderTraversalRec(this.root);
        System.out.println("NULL");
    }

    private void inOrderTraversalRec(BinaryTreeNode node) {
        if (node == null) return;
        inOrderTraversalRec(node.left);
        System.out.print(node.data + "->");
        inOrderTraversalRec(node.right);
    }

    public void levelOrderTraversal() {
        if (this.root == null) {
            System.out.println("NULL");
            return;
        }
        Queue<BinaryTreeNode> holdingQueue = new LinkedList<>();
        BinaryTreeNode curr = this.root;
        holdingQueue.add(curr);
        while (!holdingQueue.isEmpty()) {
            curr = holdingQueue.poll();
            System.out.print(curr.data + "->");
            if (curr.left != null) holdingQueue.add(curr.left);
            if (curr.right != null) holdingQueue.add(curr.right);
        }
        System.out.println("NULL");
    }

    public BinaryTreeNode findInBT(BinaryTreeNode node, int data) {
        if (node == null) return null;
        if (node.data == data) return node;
        BinaryTreeNode leftNode = this.findInBT(node.left, data);
        if (leftNode != null) return leftNode;
        BinaryTreeNode rightNode = this.findInBT(node.right, data);
        if (rightNode != null) return rightNode;
        return null;
    }

    public void insertCustom(String s) {
        String[] out = s.split("-");
        int nodeData = Integer.parseInt(out[0]);
        int newNodeData = Integer.parseInt(out[2]);

        if (root == null) {
            root = new BinaryTreeNode(nodeData);
        }
        BinaryTreeNode nodeToInsert = this.findInBT(root, nodeData);
        if (out[1].equals("L")) nodeToInsert.left = new BinaryTreeNode(newNodeData);
        else nodeToInsert.right = new BinaryTreeNode(newNodeData);
    }
}
