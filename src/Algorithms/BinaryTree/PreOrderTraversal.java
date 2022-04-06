package Algorithms.BinaryTree;

import Algorithms.Algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PreOrderTraversal extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Binary Tree PreOrder Traversal");
        TreeNode root;
        List<Integer> values;
        List<Integer> traversedOrder;
        values = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println("Input: " + values);
        root = TreeNode.generateBinaryTree(values);
        traversedOrder = TreeNode.preOrderTraversal(root);
        System.out.println("Output: " + traversedOrder);
        values = Arrays.asList(3,2,4,1,6,5,7,8);
        System.out.println("Input: " + values);
        root = TreeNode.generateBinaryTree(values);
        traversedOrder = TreeNode.preOrderTraversal(root);
        System.out.println("Output 1: " + traversedOrder);
        traversedOrder = this.preOrderTraversalStack(root);
        System.out.println("Output 2: " + traversedOrder);
    }

    public List<Integer> preOrderTraversalStack(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output =  new LinkedList<>();

        if (root == null) return output;

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);

            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}
