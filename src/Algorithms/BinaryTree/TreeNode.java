package Algorithms.BinaryTree;

import com.sun.source.tree.Tree;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {};

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildBinaryTree(List<Integer> values, int start, int end) {
        if (end < start) return null;
        TreeNode node = new TreeNode();
        int mid = start + (end - start) / 2;
        node.val = values.get(mid);
        node.left = buildBinaryTree(values, start, mid - 1);
        node.right = buildBinaryTree(values, mid + 1, end);
        return node;
    }

    public static TreeNode addNodeToCBT(int[] values, int currIndex) {
        if (currIndex >= values.length) return null;
        TreeNode node = new TreeNode();
        node.val = values[currIndex];
        node.left = addNodeToCBT(values, 2* currIndex + 1);
        node.right = addNodeToCBT(values, 2* currIndex + 2);
        return node;
    }

    public static TreeNode buildCompleteBinaryTree(int[] values) {
        return addNodeToCBT(values, 0);
    }

    public static TreeNode generateBinaryTree(List<Integer> values) {
        int length = values.size();
        int start = 0;
        int end = length - 1;
        TreeNode root = buildBinaryTree(values, start, end);
        return root;
    }

    public static void levelTraverse(TreeNode node, List<Integer> values) {
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            values.add(currNode.val);
            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }
    }

    public static List<Integer> levelOrderTraversal(TreeNode root) {
        // Node, Left, Right
        List<Integer> values =  new ArrayList<>();
        levelTraverse(root, values);
        return values;
    }

    private static void preTraverse(TreeNode node, List<Integer> values) {
        if (node != null) {
            values.add(node.val);
            if (node.left != null) {
                preTraverse(node.left, values);
            }
            if (node.right != null) {
                preTraverse(node.right, values);
            }
        }
    }

    public static List<Integer> preOrderTraversal(TreeNode root) {
        // Node, Left, Right
        List<Integer> values =  new ArrayList<>();
        preTraverse(root, values);
        return values;
    }

    public static void inTraverse(TreeNode node, List<Integer> values) {
        if (node != null) {
            if (node.left != null) {
                inTraverse(node.left, values);
            }
            values.add(node.val);
            if (node.right != null) {
                inTraverse(node.right, values);
            }
        }
    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        // Left, Node, Right
        List<Integer> values =  new ArrayList<>();
        inTraverse(root,values);
        return values;
    }

    public static void postTraverse(TreeNode node, List<Integer> values) {
        if (node != null) {
            if (node.left != null) {
                postTraverse(node.left, values);
            }
            if (node.right != null) {
                postTraverse(node.right, values);
            }
            values.add(node.val);
        }
    }

    public static List<Integer> postOrderTraversal(TreeNode root) {
        // Left, Right, Node
        List<Integer> values =  new ArrayList<>();
        postTraverse(root,values);
        return values;
    }



}
