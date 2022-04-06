package Algorithms.BinaryTree;

import Algorithms.Algorithms;
import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Binary Tree InOrder Traversal");
        TreeNode root;
        List<Integer> values;
        List<Integer> traversedOrder;
        values = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println("Input: " + values);
        root = TreeNode.generateBinaryTree(values);
        traversedOrder = TreeNode.inOrderTraversal(root);
        System.out.println("Output: " + traversedOrder);
        values = Arrays.asList(3,2,4,1,6,5,7,8);
        System.out.println("Input: " + values);
        root = TreeNode.generateBinaryTree(values);
        traversedOrder = this.inOrderTraversalStack(root);
        System.out.println("Output: " + traversedOrder);
    }

    public List<Integer> inOrderTraversalStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output =  new LinkedList<>();

        TreeNode curr = root;
        while(curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            output.add(curr.val);
            curr = curr.right;
        }
        return output;
    }
}
