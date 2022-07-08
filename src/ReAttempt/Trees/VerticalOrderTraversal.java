package ReAttempt.Trees;

import Common.Problem;

import java.util.*;

public class VerticalOrderTraversal extends Problem {
    @Override
    public void run() {
        System.out.println("Running Vertical Order Traversal Of Binary Tree");
        int[][] input = new int[][]{{1,2,3,4,5,6,7}, {1,2,3,4,5,6,7,8,9,10,11},
                {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}, {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            BinaryTree bt = new BinaryTree(input[i]);
            System.out.print ("BT: ");
            bt.printBT();
            System.out.println("Vertical Order Traversal: " + this.verticalOrderTraversal(bt));
        }
    }

    private List<List<Integer>> verticalOrderTraversal(BinaryTree bt) {
        List<List<Integer>> result = new ArrayList<>();
        if (bt == null || bt.root == null) return result;
        // These two values are to hold the horizontal distance range for iterating at the end
        int min = 0;
        int max = 0;
        int hDistance;
        Map<Integer, List<Integer>> distanceNodesMap = new HashMap<>();
        Queue<BinaryTreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> distanceQueue = new LinkedList<>();
        BinaryTreeNode curr = bt.root;
        // Initialize the queues with the root
        nodeQueue.add(curr);
        distanceQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            // poll the node and distance
            curr = nodeQueue.poll();
            hDistance = distanceQueue.poll();
            // update the max and min range of distances
            min = Math.min(min, hDistance);
            max = Math.max(max, hDistance);
            // add the node to the corresponding distance list
            List<Integer> nodes;
            if (distanceNodesMap.containsKey(hDistance)) {
                nodes = distanceNodesMap.get(hDistance);
                nodes.add(curr.data);
            } else {
                nodes = new ArrayList<>();
                nodes.add(curr.data);
                distanceNodesMap.put(hDistance, nodes);
            }
            // if there is a left node add it to the queue by decrementing the hDistance
            if (curr.left != null) {
                nodeQueue.add(curr.left);
                distanceQueue.add(hDistance - 1);
            }
            // if there is a right node add it to the queue by incrementing the hDistance
            if (curr.right != null) {
                nodeQueue.add(curr.right);
                distanceQueue.add(hDistance + 1);
            }
        }
        // Loop from min and max range to print the distance node combos
        for (int i = min; i <= max; i++) {
            result.add(distanceNodesMap.get(i));
        }
        return result;
    }
}
