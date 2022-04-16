package Problems.BinaryTree;


import Common.Problem;

public class FindAncestors extends Problem {

    @Override
    public void run() {
        System.out.println("Running Find Ancestors of Value in BST");
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
        k = 10;
        String ancestors =  this.findAncestors(bst.getRoot(), k);
        System.out.println("Ancestors for " + k + " is " + ancestors);
    }

    private String findAncestors(Node node, int k) {
        String ancestors = "";
        while (node != null) {
            if (k == node.getData()) {
                return ancestors;
            }
            ancestors = ancestors + node.getData() + ",";
            if (k < node.getData()) {
                node = node.getLeftChild();
                continue;
            } else if (k > node.getData()) {
                node = node.getRightChild();
                continue;
            }
        }
        return "";
    }
}
