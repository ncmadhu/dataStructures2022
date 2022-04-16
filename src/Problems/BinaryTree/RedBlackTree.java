package Problems.BinaryTree;

import Problems.Stacks.Stack;

public class RedBlackTree extends BinarySearchTree{
    RedBlackNode root;
    boolean leftLeftRotation;
    boolean leftRightRotation;
    boolean rightRightRotation;
    boolean rightLeftRotation;

    public void setRoot(RedBlackNode root) {
        this.root = root;
    }
    public Node getRoot() {
        return this.root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void preOrderTraversalStack() {
        if (this.isEmpty()) return;
        Stack<Node> nodes = new Stack<>(5);
        nodes.push(this.root);
        while (!nodes.isEmpty()) {
            Node temp = nodes.pop();
            System.out.print(temp.getData() + " --> ");
            if (temp.getRightChild() != null) nodes.push(temp.getRightChild());
            if (temp.getLeftChild() != null) nodes.push(temp.getLeftChild());
        }
        System.out.print("END");
        System.out.println();
    }
    public boolean isLeftLeftRotation() {
        return leftLeftRotation;
    }

    public void setLeftLeftRotation(boolean leftLeftRotation) {
        this.leftLeftRotation = leftLeftRotation;
    }

    public boolean isLeftRightRotation() {
        return leftRightRotation;
    }

    public void setLeftRightRotation(boolean leftRightRotation) {
        this.leftRightRotation = leftRightRotation;
    }

    public boolean isRightRightRotation() {
        return rightRightRotation;
    }

    public void setRightRightRotation(boolean rightRightRotation) {
        this.rightRightRotation = rightRightRotation;
    }

    public boolean isRightLeftRotation() {
        return rightLeftRotation;
    }

    public void setRightLeftRotation(boolean rightLeftRotation) {
        this.rightLeftRotation = rightLeftRotation;
    }

    private RedBlackNode rotateLeft(RedBlackNode node) {
        RedBlackNode rightChild = node.getRightChild();
        RedBlackNode rightChildsLeftChild = rightChild.getLeftChild();
        node.setRightChild(rightChildsLeftChild);
        rightChild.setLeftChild(node);
        node.setParent(rightChild); // update parent
        if (rightChildsLeftChild != null) rightChildsLeftChild.setParent(node);
        return rightChild;
    }

    private RedBlackNode rotateRight(RedBlackNode node) {
        RedBlackNode leftChild = node.getLeftChild();
        RedBlackNode leftChildsRightChild = leftChild.getRightChild();
        node.setLeftChild(leftChildsRightChild);
        leftChild.setRightChild(node);
        node.setParent(leftChild);
        if (leftChildsRightChild != null)  leftChildsRightChild.setParent(node);
        return leftChild;
    }

    @Override
    public boolean add(int value) {
        if (this.isEmpty()) {
            RedBlackNode redBlackNode = new RedBlackNode(value);
            redBlackNode.setRed(false);
            this.root = redBlackNode;
        } else {
            this.root = this.add(this.root, value);
        }
        return true;
    }

    public RedBlackNode add(RedBlackNode node, int value) {
        // Parent and its child cannot be Red in Red Black Tree
        boolean redRedViolation = false;

        // If node is null create new node with default color of Red
        if (node == null) return new RedBlackNode(value);
        if (value < node.getData()) {
            // If new value is lesser than current node value move to left side
            node.setLeftChild(this.add(node.getLeftChild(), value));
            // update left child node parent to current node
            node.getLeftChild().setParent(node);
            if (node != this.root) {
                if (node.isRed() && node.getLeftChild().isRed()) {
                    redRedViolation = true;
                }
            }
        } else if (value > node.getData()) {
            // If new value is lesser than current node value move to right side
            node.setRightChild(this.add(node.getRightChild(), value));
            // update the right child node parent to current node
            node.getRightChild().setParent(node);
            if (node != this.root) {
                if (node.isRed() && node.getRightChild().isRed()) {
                    redRedViolation = true;
                }
            }
        }

        // rotation processing on parent level
        if (this.isLeftLeftRotation()) {
            node = this.rotateLeft(node);
            // recolor
            // B       becomes      R   after rotation  Hence recolor to      B
            //    R              B     R                                   R     R
            //       R
            node.setRed(false); // new node becomes black
            node.getLeftChild().setRed(true); // new left child becomes red
            this.setLeftLeftRotation(false);
        } else if (this.isLeftRightRotation()) {
            node.setLeftChild(this.rotateLeft(node.getLeftChild()));
            node.getLeftChild().setParent(node);
            node = this.rotateRight(node);
            // recolor
            //     B                    B                R                               B
            //  R       becomes      R        becomes R     B     Hence recolor to    R     R
            //     R              R
            node.setRed(false);
            node.getRightChild().setRed(true);
            this.setLeftRightRotation(false);
        } else if (this.isRightRightRotation()) {
            node = this.rotateRight(node);
            // recolor
            //        B                R                               B
            //     R        becomes R     B     Hence recolor to    R     R
            //  R
            node.setRed(false);
            node.getRightChild().setRed(true);
            this.setRightRightRotation(false);
        } else if (this.isRightLeftRotation()) {
            node.setRightChild(this.rotateRight(node.getRightChild()));
            node.getRightChild().setParent(node);
            node = this.rotateLeft(node);
            // recolor
            //  B               B                      R                          B
            //     R  becomes      R      becomes   B     R Hence recolor to   R     R
            //  R                     R
            node.setRed(false);
            node.getLeftChild().setRed(true);
            this.setRightLeftRotation(false);
        }

        // red-red violation processing marks the rotation to be performed
        // one level above when the backtracking takes place
        // parent --> child --> grand child
        // child --> grand child red-red violation
        // rotate(parent)
        if (redRedViolation) {
            RedBlackNode parent = node.getParent();

            // Check current node is in right or left side of the parent
            if (node == parent.getRightChild()) {
                // node is right child of the parent
                // check current node sibling color
                if (parent.getLeftChild() == null || !parent.getLeftChild().isRed()) {
                    // current node sibling color is black.
                    if (node.getLeftChild() != null && node.getLeftChild().isRed()) {
                        // node is right child of parent and node is red
                        // node left child is red
                        // right-left imbalance
                        // hence right left imbalance
                        this.setRightLeftRotation(true);
                    } else if (node.getRightChild() != null && node.getRightChild().isRed()) {
                        // node is right child of its parent and node is red
                        // node right child is red
                        // right-right imbalance
                        // hence left-left rotation
                        this.setLeftLeftRotation(true);
                    }

                } else {
                    // current node sibling color is red
                    // recolor sibling and current node
                    parent.getLeftChild().setRed(false);
                    node.setRed(false);
                    // check parent is not root and recolor it
                    if (parent != this.root) {
                        parent.setRed(true);
                    }
                }
            } else {
                // node is left child of the parent
                // check current node sibling color
                if (parent.getRightChild() == null || !parent.getRightChild().isRed()) {
                    // current node sibling color is black
                    if (node.getLeftChild() != null && node.getLeftChild().isRed()) {
                        // node is left child of its parent and node is red
                        // node left child is red
                        // left-left imbalance
                        // hence right-right rotation
                        this.setRightRightRotation(true);
                    } else if (node.getRightChild() != null && node.getRightChild().isRed()) {
                        // node is left child of its parent and node is red
                        // node right child is red
                        // left right imbalance
                        // hence left-right rotation
                        this.setLeftRightRotation(true);
                    }
                } else {
                    // current node sibling color is red
                    // recolor sibling and current node
                    parent.getRightChild().setRed(false);
                    node.setRed(false);
                    // check parent is not root and recolor it
                    if (parent != this.root) {
                        parent.setRed(true);
                    }
                }
            }
            // update red-red violation status
            redRedViolation = false;

        }
        return node;
    }
}
