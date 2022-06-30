package ReAttempt.Trees;

import Common.Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftRightTopBottomView extends Problem {
    @Override
    public void run() {
        System.out.println("Running Left Right Top Bottom View Of Binary Tree");
        String[][] input = new String[][]{{"1-L-2", "1-R-3", "2-L-4", "2-R-5", "3-L-6", "3-R-7"},
                {"1-L-2", "1-R-3", "2-R-4", "3-L-5", "4-L-6", "4-R-7", "5-L-8", "5-R-9"}};
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
        }
    }

    private List<Integer> printLeftView(BinaryTree bt) {
        List<Integer> result = new ArrayList<>();
        if (bt == null || bt.root == null) return result;
        BinaryTreeNode curr = bt.root;
        Queue<BinaryTreeNode> holdingQueue = new LinkedList<>();
        holdingQueue.add(curr);
        while (!holdingQueue.isEmpty()) {
            curr = holdingQueue.poll();
            result.add(curr.data);
            if (curr.left != null) holdingQueue.add(curr.left);
            else if (curr.right != null) holdingQueue.add(curr.right);
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
            curr = holdingQueue.poll();
            result.add(curr.data);
            if (curr.right != null) holdingQueue.add(curr.right);
            else if (curr.left != null) holdingQueue.add(curr.left);
        }
        return result;
    }


}
