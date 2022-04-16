package Problems.BinaryTree;

import Common.Problem;

public class FindNodesAtKDistanceFromRoot extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find Nodes At K Distance From Root Of BST");
        int k;
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(6);
        bst.add(4);
        bst.add(9);
        bst.add(5);
        bst.add(2);
        bst.add(8);
        bst.add(12);
        bst.add(10);
        bst.add(14);
        System.out.println("In Order Tree:");
        bst.inOrderTraversalStack();
        k = 2;
        System.out.println("Nodes at " + k + " distance from root: " + this.findKthDistanceNodes(bst.getRoot(), k));
    }

    private String findKthDistanceNodes(Node node, int k) {
        String result = "";
        result = this.findKthDistanceNodes(node, k, 0, result);
        return result;
    }

    private String findKthDistanceNodes(Node node, int k, int level, String result) {
        if (node == null) return result;
        if (level < k) {
            result = this.findKthDistanceNodes(node.getLeftChild(), k, level + 1, result);
            result = this.findKthDistanceNodes(node.getRightChild(), k , level + 1, result);
        } else if (level == k) {
            result = result + node.getData() + ",";
        }
        return result;
    }
}
