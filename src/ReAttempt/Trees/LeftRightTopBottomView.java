package ReAttempt.Trees;

import Common.Problem;

import java.util.*;

public class LeftRightTopBottomView extends Problem {
    @Override
    public void run() {
        System.out.println("Running Left Right Top Bottom View Of Binary Tree");
        String[][] input = new String[][]{{"1-L-2", "1-R-3", "2-L-4", "2-R-5", "3-L-6", "3-R-7"},
                {"1-L-2", "1-R-3", "2-R-4", "3-L-5", "4-L-6", "4-R-7", "5-L-8", "5-R-9"},
                {"1-L-2", "1-R-3", "2-R-4", "3-R-5", "4-L-6"},
                {"1-L-2", "1-R-3", "2-L-4", "2-R-5", "3-R-6", "5-R-7"}};
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
            System.out.println("Left View : " + this.printLeftView(bt));
            System.out.println("Right View : " + this.printRightView(bt));
            System.out.println("Top View : " + this.printTopView(bt));
            System.out.println("Bottom View : " + this.printBottomView(bt));
        }
    }

    private List<Integer> printLeftView(BinaryTree bt) {
        List<Integer> result = new ArrayList<>();
        if (bt == null || bt.root == null) return result;
        BinaryTreeNode curr = bt.root;
        Queue<BinaryTreeNode> holdingQueue = new LinkedList<>();
        holdingQueue.add(curr);
        while (!holdingQueue.isEmpty()) {
            Queue<BinaryTreeNode> tempQueue = new LinkedList<>();
            boolean first = true;
            while (!holdingQueue.isEmpty()) {
                curr = holdingQueue.poll();
                if (first) {
                    result.add(curr.data);
                    first = false;
                }
                if (curr.left != null) tempQueue.add(curr.left);
                if (curr.right != null) tempQueue.add(curr.right);
            }
            holdingQueue = tempQueue;
        }
        return result;
    }

    private List<Integer> printRightView(BinaryTree bt) {
        List<Integer> result = new ArrayList<>();
        if (bt == null || bt.root == null) return result;
        BinaryTreeNode curr = bt.root;
        Queue<BinaryTreeNode> holdingQueue = new LinkedList<>();
        holdingQueue.add(curr);
        while (!holdingQueue.isEmpty()) {
            Queue<BinaryTreeNode> tempQueue = new LinkedList<>();
            while (!holdingQueue.isEmpty()) {
                curr = holdingQueue.poll();
                if (curr.left != null) tempQueue.add(curr.left);
                if (curr.right != null) tempQueue.add(curr.right);
            }
            result.add(curr.data);
            holdingQueue = tempQueue;
        }
        return result;
    }

    private List<List<Integer>> doVerticalOrderTraversal(BinaryTree bt) {
        List<List<Integer>> result = new ArrayList<>();
        if (bt == null || bt.root == null) return result;
        Queue<BinaryTreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> distanceQueue = new LinkedList<>();
        Map<Integer, List<Integer>> distanceNodesMap = new HashMap<>();
        int max = 0;
        int min = 0;
        int hDistance = 0;
        BinaryTreeNode curr = bt.root;
        nodeQueue.add(curr);
        distanceQueue.add(hDistance);
        while (!nodeQueue.isEmpty()) {
            curr = nodeQueue.poll();
            hDistance = distanceQueue.poll();
            min = Math.min(min, hDistance);
            max = Math.max(max, hDistance);
            List<Integer> nodes;
            if (distanceNodesMap.containsKey(hDistance)) {
                nodes = distanceNodesMap.get(hDistance);
                nodes.add(curr.data);
            } else {
                nodes = new ArrayList<>();
                nodes.add(curr.data);
            }
            distanceNodesMap.put(hDistance, nodes);
            if (curr.left != null) {
                nodeQueue.add(curr.left);
                distanceQueue.add(hDistance-1);
            }
            if (curr.right != null) {
                nodeQueue.add(curr.right);
                distanceQueue.add(hDistance+1);
            }
        }
        for (int i = min; i <= max; i++) {
            result.add(distanceNodesMap.get(i));
        }
        return result;
    }

    private List<Integer> printTopView(BinaryTree bt) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> verticalOrder = this.doVerticalOrderTraversal(bt);
        for (List<Integer> nodes : verticalOrder) {
            result.add(nodes.get(0));
        }
        return result;
    }

    private List<Integer> printBottomView(BinaryTree bt) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> verticalOrder = this.doVerticalOrderTraversal(bt);
        for (List<Integer> nodes : verticalOrder) {
            result.add(nodes.get(nodes.size()-1));
        }
        return result;
    }


}
