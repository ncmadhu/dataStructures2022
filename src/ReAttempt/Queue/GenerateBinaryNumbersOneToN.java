package ReAttempt.Queue;

import Common.Problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbersOneToN extends Problem {
    @Override
    public void run() {
        System.out.println("Running Generate Binary Numbers One to N Using Queue");
        int[] input = new int[]{3, 5};
        this.execute(input);
    }

    private void execute(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int n = input[i];
            System.out.println("Input: " + n);
            System.out.println("Output: "+ Arrays.toString(this.findBin(n)));
            System.out.println("Output (Queue): "+ Arrays.toString(this.findBinQueue(n)));
        }
    }

    private String[] findBin(int n) {
        if (n < 0) return new String[]{};
        String[] result = new String[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            int curNum = i;
            String binNum = "";
            while (curNum != 0) {
                binNum = curNum % 2 + binNum;
                curNum = curNum / 2;
            }
            result[i-1] = binNum;
        }
        return result;
    }

    private String[] findBinQueue(int n) {
        if (n < 0) return new String[]{};
        String[] result = new String[n];
        ReAttempt.Queue.Queue<String> queue = new ReAttempt.Queue.Queue<>(n+1);
        queue.enqueue("1");
        for (int i = 0; i < n; i++) {
            result[i] = queue.dequeue();
            queue.enqueue(result[i] + "0");
            queue.enqueue(result[i] + "1");
        }
        return result;
    }
}
