package Problems.Queues;

import Common.Problem;

import java.util.Arrays;

public class GenerateBinaryNumbersOneToN extends Problem {
    @Override
    public void run() {
        System.out.println("Running Generate Binary Numbers One to N Using Queue");
        int n;
        n = 3;
        System.out.println("Input: " + n);
        System.out.println("Output: "+ Arrays.toString(this.findBin(n)));
        n = 10;
        System.out.println("Input: " + n);
        System.out.println("Output: "+ Arrays.toString(this.findBin(n)));
    }

    private String[] findBin(int n) {
        String binNum;
        String[] result = new String[n];
        //Initializing queue to 64 bits size
        Queue<Integer> holdingQueue = new Queue<>(64);
        for (int i = 1; i <= n; i++) {
            int currNum = i;
            // Capturing remainder in queue
            while (currNum != 0) {
                holdingQueue.enqueue( currNum % 2);
                currNum = currNum / 2;
            }
            binNum = "";
            while (!holdingQueue.isEmpty()) {
                binNum = holdingQueue.dequeue() + binNum;
            }
            result[i-1] = binNum;
        }
        return result;
    }
}
