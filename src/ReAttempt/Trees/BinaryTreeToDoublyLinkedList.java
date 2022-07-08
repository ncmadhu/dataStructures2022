package ReAttempt.Trees;

import Common.Problem;

public class BinaryTreeToDoublyLinkedList extends Problem {
    @Override
    public void run() {
        System.out.println("Running Diameter Of Binary Tree");
        String[][] input = new String[][]{{"1-L-2", "1-R-3", "2-L-4", "2-R-5", "3-R-6", "5-L-7", "5-R-8",
                "6-R-9", "9-L-10", "9-R-11", "10-R-12"}, {"1-L-2", "1-R-3", "2-L-4", "2-R-5","4-L-6", "4-R-7", "5-R-8",
                "7-L-9", "8-L-10", "8-R-11", "9-R-12"}};
        this.execute(input);
    }

    private void execute(String[][] input) {
        for (int i = 0; i < input.length; i++) {
            BinaryTree bt = new BinaryTree();
            for (int j = 0; j < input[i].length; j++) {
                bt.insertCustom(input[i][j]);
            }
            System.out.println("Input: ");
            bt.printBT();
            System.out.print ("In Order Traversal Iterative: ");
            bt.inOrderTraversalIterative();
            NodeRef nodeRef = this.binaryTreeToDoublyLinkedList(bt);
            System.out.print ("Doubly Linked List: ");
            this.printList(nodeRef);
            System.out.print ("Reversed Doubly Linked List: ");
            this.reversePrintList(nodeRef);
        }
    }

    private void printList(NodeRef nodeRef) {
        if (nodeRef.head == null) {
            System.out.println("NULL");
        }
        BinaryTreeNode curr = nodeRef.head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.right;
        }
        System.out.println("NULL");
    }

    private void reversePrintList(NodeRef nodeRef) {
        if (nodeRef.head == null) {
            System.out.println("NULL");
        }
        BinaryTreeNode curr = nodeRef.head;
        while (curr.right != null) {
            curr = curr.right;
        }
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.left;
        }
        System.out.println("NULL");
    }

    class NodeRef {
        BinaryTreeNode head;
        BinaryTreeNode prev;

        public NodeRef() {
            head = null;
            prev = null;
        }
    }

    private NodeRef binaryTreeToDoublyLinkedList(BinaryTree bt) {
        NodeRef nodeRef = new NodeRef();
        if (bt == null || bt.root == null) return nodeRef;
        this.binaryTreeToDoublyLinkedList(nodeRef, bt.root);
        return nodeRef;
    }

    private void binaryTreeToDoublyLinkedList(NodeRef nodeRef, BinaryTreeNode node) {
        if (node == null) return;
        this.binaryTreeToDoublyLinkedList(nodeRef, node.left);
        if (nodeRef.prev == null) {
            // Head node
            nodeRef.head = node;
        } else {
            nodeRef.prev.right = node;
            node.left = nodeRef.prev;
        }
        nodeRef.prev = node;
        this.binaryTreeToDoublyLinkedList(nodeRef, node.right);
    }
}
