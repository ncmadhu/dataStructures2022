package Algorithms.BinaryTree;

import Algorithms.Stacks.Stack;

public class BinarySearchTree {
    Node root;

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
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
    public boolean add(int value) {

        if (isEmpty()) {
            root = new Node(value);
            return true;
        }

        Node currNode = this.root;

        while (currNode != null) {
            Node leftChild = currNode.getLeftChild();
            Node rightChild = currNode.getRightChild();

            if (value < currNode.getData()) {
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currNode.setLeftChild(leftChild);
                    return true;
                } else {
                    currNode = leftChild;
                }
            } else {
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currNode.setRightChild(rightChild);
                    return true;
                } else {
                    currNode = rightChild;
                }
            }
        }
        return false;
    }

    public boolean addRecursive(int value) {
        this.root = this.addRecursiveHelper(this.root, value);
        return true;
    }

    public Node addRecursiveHelper(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.getData()) {
            currentNode.setLeftChild(this.addRecursiveHelper(currentNode.getLeftChild(), value));
        } else if (value > currentNode.getData()){
            currentNode.setRightChild(this.addRecursiveHelper(currentNode.getRightChild(), value));
        }
        return currentNode;
    }

    public Node search(int value) {
        if (isEmpty()) return null; // Empty tree
        Node currNode = this.root;
        while (currNode != null) {
            if (currNode.getData() == value) return currNode;
            if (currNode.getData() > value)
                currNode = currNode.getLeftChild();
            else
                currNode = currNode.getRightChild();
        }
        System.out.println(value + " not found in the Tree");
        return null;
    }

    public Node searchRecursive(int value) {
        return this.searchRecursiveHelper(this.root, value);
    }

    public Node searchRecursiveHelper(Node currNode, int value) {
        if (currNode == null) {
            System.out.println(value + " not found in the Tree");
            return currNode;
        }
        if (currNode.getData() == value) return currNode;
        if (currNode.getData() > value)
            return this.searchRecursiveHelper(currNode.getLeftChild(), value);
        else
            return this.searchRecursiveHelper(currNode.getRightChild(), value);

    }

    // Conditions to check
    // root node has the value to be deleted
    // To be deleted node has left and right child
    // Only left or right child
    // both left and right child

    public boolean delete(int value) {
        if (isEmpty()) return false;
        Node parent = null;
        Node currNode = this.root;

        // Determine the parent node of the value to be deleted
        // for updating the parent once its child is deleted
        while (currNode != null && currNode.getData() != value) {
            parent = currNode;
            if (value < currNode.getData())
                currNode = currNode.getLeftChild();
            else
                currNode = currNode.getRightChild();
        }

        if (currNode == null) {
            // value is not found in the tree to delete
            return false;
        }

        //
        Node leftChild = currNode.getLeftChild();
        Node rightChild = currNode.getRightChild();

        // Leaf Node condition
        if (leftChild == null && rightChild == null) {
            // If root is the currNode ---> Tree with just a root
            if (currNode.getData() == this.root.getData()) {
                this.setRoot(null);
                return true;
            }
            if (currNode.getData() < parent.getData())
                parent.setLeftChild(null);
            else
                parent.setRightChild(null);
            return true;
        } else if(rightChild == null) {
            // root with just a left child matching the value
            if (currNode.getData() == this.root.getData()) {
                setRoot(leftChild);
                return true;
            } else if (currNode.getData() < parent.getData()) {
                parent.setLeftChild(leftChild);
                return true;
            } else {
                parent.setRightChild(leftChild);
                return true;
            }
        } else if (leftChild == null) {
            // root with just a right child with matching value
            if (currNode.getData() == this.root.getData()) {
                setRoot(rightChild);
                return true;
            } else if (currNode.getData() < parent.getData()) {
                parent.setLeftChild(rightChild);
                return true;
            } else {
                parent.setRightChild(rightChild);
                return true;
            }
        } else {
            // To be deleted node having both left and right child
            // Find the minimum value node in the right subtree
            // Delete that node and update current node value to the minimum value node
            Node minNode = this.findLeastNode(rightChild);
            int temp = minNode.getData();
            this.delete(temp);
            currNode.setData(temp);
            return true;
        }
    }

    public Node findLeastNode(Node currNode) {
        while (currNode.getLeftChild() != null) {
            currNode = currNode.getLeftChild();
        }
        return currNode;
    }

    // PreOrder ---> Node --> Left --> Right
    // Process node before leaves
    // Used in copying/duplicating binary tree
    // Time complexity -- O(n) --> visiting each node exactly once

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

    public void preOrderTraversalRecursion() {
        if (isEmpty()) return;
        this.preOrderTraversalRecursionHelper(this.getRoot());
        System.out.print("END");
        System.out.println();
    }

    public void preOrderTraversalRecursion(Node root) {
        this.preOrderTraversalRecursionHelper(root);
        System.out.print("END");
        System.out.println();
    }

    private void preOrderTraversalRecursionHelper(Node node) {
        if (node == null) return;
        System.out.print(node.getData() + " --> ");
        this.preOrderTraversalRecursionHelper(node.getLeftChild());
        this.preOrderTraversalRecursionHelper(node.getRightChild());
    }

    public void inOrderTraversalRecursion() {
        if (isEmpty()) return;
        this.inOrderTraversalHelper(this.getRoot());
        System.out.print("END");
        System.out.println();
    }

    public void inOrderTraversalHelper(Node node) {
        if (node == null) return;
        this.inOrderTraversalHelper(node.getLeftChild());
        System.out.print(node.getData() + " --> ");
        this.inOrderTraversalHelper(node.getRightChild());
    }
    // 1. Init a stack
    // 2. Enter while loop if curr is not null or stack is not empty
    // 3. Go to the end to get left most leaf node by pushing nodes to stack
    // 4. When no more left elements, pop the element from stack
    // 5. Now push elements to the right of popped element to stack
    // 6. Idea here is leaf will not have right, so node will be processed before right elements are processed as we go
    //    up
    // 7. Key here is two while loops
    public void inOrderTraversalStack() {
        if (isEmpty()) return;
        Stack<Node> nodes =  new Stack<>(10);
        Node curr = this.getRoot();
        while (curr != null || !nodes.isEmpty()) {
            while (curr != null) {
                nodes.push(curr);
                // Move to the left most node
                curr = curr.getLeftChild();
            }
            curr = nodes.pop();
            System.out.print(curr.getData() + " --> ");
            // Move to right
            curr = curr.getRightChild();
        }
        System.out.print("END");
        System.out.println();

    }

    public void postOrderTraversalRecursion() {
        if (isEmpty()) return;
        this.postOrderTravelHelper(this.getRoot());
        System.out.print("END");
        System.out.println();
    }

    public void postOrderTravelHelper(Node node) {
        if (node == null) return;
        this.postOrderTravelHelper(node.getLeftChild());
        this.postOrderTravelHelper(node.getRightChild());
        System.out.print(node.getData() + " --> ");
    }

    // Post order traversal using stack can be done by using two stacks
    // first part is same as pre order traversal but instead of printing add to the second stack
    // and add left child before the right child
    // When all nodes are processed, second stack will have the nodes in post order, just pop the
    // elements from second stack
    public void postOrderTraversalTwoStack() {
        if (isEmpty()) return;

        Stack<Node> stack1 = new Stack<>(10);
        Stack<Node> stack2 = new Stack<>(10);
        Node curr = this.getRoot();
        stack1.push(curr);
        while (!stack1.isEmpty()) {
            Node temp = stack1.pop();
            stack2.push(temp);
            if (temp.getLeftChild() != null) stack1.push(temp.getLeftChild());
            if (temp.getRightChild() != null) stack1.push(temp.getRightChild());
        }
        while (!stack2.isEmpty()) {
            Node temp = stack2.pop();
            System.out.print(temp.getData() + " --> ");
        }
        System.out.print("END");
        System.out.println();
    }

    // Post order traversal using one stack
    // 1. Init empty stack
    // 2. Init curr to root
    // 3. If curr not null enter while loop
    // 4. Push curr right child to stack and curr to stack. Set curr as curr left child
    // 5. Repeat 4 until no more left child to explore --- All left child is visited and their immediate right is stored
    //    for processing lately
    // 6. Pop item from stack ,
    //      6.1 If item has right child and stack top is that right child pop that also and push the item back to stack
    //      6.2 set curr has right child and explore its left child path by repeating step 4 & 5
    //      6.3 If no right child is present print the item and set curr has null
    //      6.4 Here pushing the curr node again to stack will not cause infinite loop of exploring the same right child
    //          again because top of the stack is not the right child of curr popped element
    // Explore left child path while storing the parent and immediate right to the stack. Explore the right child
    // subtree on the return path. Key: comparing top of the stack to the right child of the popped element
    public void postOrderTraversalOneStackMethod1() {
        if (isEmpty()) return;
        Node curr = this.getRoot();
        Stack<Node> nodes = new Stack<>(10);
        while (curr != null || !nodes.isEmpty()) {
            while (curr != null) {
                if (curr.getRightChild() != null) nodes.push(curr.getRightChild());
                nodes.push(curr);
                curr = curr.getLeftChild();
            }
            curr = nodes.pop();
            if (curr.getRightChild() == nodes.top()) {
                Node temp = nodes.pop();
                nodes.push(curr);
                curr = temp;
            } else {
                System.out.print(curr.getData() + " --> ");
                curr = null; // *Important*
            }
        }
        System.out.print("END");
        System.out.println();
    }

    // Same as above technique with little change. Instead of pushing right child to stack, push curr node twice
    // While comparing check top of stack is same as curr node. If yes set curr node as curr node right child
    public void postOrderTraversalOneStackMethod2() {
        if (isEmpty()) return;
        Node curr = this.getRoot();
        Stack<Node> nodes = new Stack<>(10);
        while (curr != null || !nodes.isEmpty()) {
            while (curr != null) {
                nodes.push(curr);
                nodes.push(curr);
                curr = curr.getLeftChild();
            }
            curr = nodes.pop();
            if (curr == nodes.top()) {
                curr = curr.getRightChild();
            } else {
                System.out.print(curr.getData() + " --> ");
                curr = null; // *Important*
            }
        }
        System.out.print("END");
        System.out.println();
    }


}
