package Problems.BinaryTree;

public class AVLTree extends BinarySearchTree {
    @Override
    public boolean add(int value) {
        this.root = this.add(this.root, value);
        return true;
    }


    private Node add(Node node, int value) {
        // Base case reached end of the node or new root
        if (node == null) return new Node(value);

        if (value < node.getData()) {
            // value less than current node value
            node.setLeftChild(this.add(node.getLeftChild(), value));

        } else if (value > node.getData()) {
            // value greater than current node value
            node.setRightChild(this.add(node.getRightChild(), value));
        } else {
            // duplicate not allowed
            return node;
        }

        // updating height at this level
        node.height = 1 + Math.max(this.height(node.getLeftChild()),
                this.height(node.getRightChild()));

        // get balance factor
        int balance = this.getBalanceFactor(node);
        // balance in {-1, 0, 1} ---> Balanced
        if (balance > 1) {
            if (value < node.getLeftChild().getData()) {
                // Left --> Left scenario
                // Rotate right
                node = this.rotateRight(node);

            } else if (value > node.getRightChild().getData()) {
                // Left --> Right scenario
                // Rotate left && Rotate Right
                // Pivot for first rotation is the left of current node
                node.setLeftChild(this.rotateLeft(node.getLeftChild()));
                node = this.rotateRight(node);
            }
        } else if (balance < -1) {
            if (value > node.getRightChild().getData()) {
                // Right --> Right scenario
                // Rotate left
                node = this.rotateLeft(node);

            } else {
                // Right --> Left scenario
                // Rotate right && Rotate left
                // Pivot for first rotation is the right of current node
                node.setRightChild(this.rotateRight(node.getRightChild()));
                node = this.rotateLeft(node);
            }
        }
        return node;
    }

    private Node rotateRight(Node node) {
        Node leftChild = node.getLeftChild();
        Node grandChild = leftChild.getRightChild();
        leftChild.setRightChild(node);
        node.setLeftChild(grandChild);
        // Important to update node height before the leftChild height update. Since node has become the child now
        // after rotation
        node.height = Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1;
        leftChild.height = Math.max(height(leftChild.getLeftChild()), height(leftChild.getRightChild())) + 1;
        return leftChild;
    }

    private Node rotateLeft(Node node) {
        Node rightChild = node.getRightChild();
        Node grandChild = rightChild.getLeftChild();
        rightChild.setLeftChild(node);
        node.setRightChild(grandChild);
        // Important to update node height before the rightChild height update. Since node has become the child now
        // after rotation
        node.height = Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1;
        rightChild.height = Math.max(height(rightChild.getLeftChild()), height(rightChild.getRightChild())) + 1;
        return rightChild;
    }

    // Balance factor calculates height difference between the left and right subtree of the given node
    private int getBalanceFactor(Node node) {
        if (node == null) return 0;
        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    private int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    @Override
    public boolean delete(int value) {
        this.root = this.delete(this.getRoot(), value);
        return true;
    }

    private Node delete(Node node, int value) {
        // If empty node
        if (node == null) return node;


        if (value < node.getData()) {
            // If value is less than current node
            node.setLeftChild(this.delete(node.getLeftChild(), value));
        } else if (value > node.getData()) {
            // If value is greater than current node
            node.setRightChild(this.delete(node.getRightChild(), value));
        } else {
            // If value is same as current node
            // Three scenarios

            Node leftChild = node.getLeftChild();
            Node rightChild = node.getRightChild();
            if (leftChild == null && rightChild == null) {
                // No child nodes and current node is a leaf
                node = null;
            } else if (rightChild == null) {
                // No right child only left child present
                node = leftChild;
            } else if (leftChild == null) {
                // No leftChild only right child present
                node = rightChild;
            } else {
                // Both left and right children present
                Node temp = this.findLeastNode(rightChild);
                node.setData(temp.getData());
                node.setRightChild(this.delete(node.getRightChild(), temp.getData()));
            }
        }
        if (node == null) return node;

        // update height of current node
        node.height = Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1;

        // get balance factor
        int balance = this.getBalanceFactor(node);

        if (balance > 1 ) {
            if (this.getBalanceFactor(node.getLeftChild()) >= 0) {
                // Left - Left scenario
                node = this.rotateRight(node);
            } else {
                // Left - Right scenario
                node.setLeftChild(this.rotateLeft(node.getLeftChild()));
                node = this.rotateRight(node);
            }
        } else if (balance < -1) {
            if (this.getBalanceFactor(node.getRightChild()) <= 0) {
                // Right - Right scenario
                node = this.rotateLeft(node);
            } else {
                // Right - Left scenario
                node.setRightChild(this.rotateRight(node.getRightChild()));
                node = this.rotateLeft(node);
            }
        }
        return node;
    }
}
