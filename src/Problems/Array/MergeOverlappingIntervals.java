package Problems.Array;

import Common.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals extends Problem {

    @Override
    public void run() {
        System.out.println("Running Merge Overlapping Intervals");
        int[][] input;
        input = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        this.execute(input);
        input = new int[][]{{1,5},{3,7},{4,6},{6,8},{10,12},{12,15}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        System.out.println("Input: ");
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
        System.out.println("Output: ");
        for (int[] pair: this.mergeIntervals(input)) {
            System.out.println(Arrays.toString(pair));
        }
    }

    private List<int[]> mergeIntervals(int[][] input) {
        int length = input.length;
        ArrayList<int[]> result = new ArrayList<>();
        if (length == 0)  return result;
        int[] prev = input[0];
        for (int i = 1; i < length; i++) {
            int[] curr = input[i];
            if (prev[1] >= curr[0]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        return result;
    }
}
