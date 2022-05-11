package ReAttempt.Arrays;

import Common.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals extends Problem {

    @Override
    public void run() {
        System.out.println("Running Merge Overlapping Intervals");
        int[][][] input = new int[][][]{{{1,3},{2,6},{8,10},{15,18}},
                                         {{1,5},{3,7},{4,6},{6,8},{10,12},{12,15}}};
        this.execute(input);
    }

    private void execute(int[][][] input) {
        for (int i = 0; i < input.length; i++) {
            int[][] intervals;
            intervals = input[i].clone();
            System.out.println("Input: ");
            for (int j = 0; j < intervals.length; j++) {
                System.out.println(Arrays.toString(intervals[j]));
            }
            System.out.println("Output: ");
            for (int[] pair: this.mergeIntervals(intervals)) {
                System.out.println(Arrays.toString(pair));
            }
            intervals = input[i].clone();
            System.out.println("Output (Re Attempt): ");
            for (int[] pair: this.reAttempt(intervals)) {
                System.out.println(Arrays.toString(pair));
            }
        }
    }

    private List<int[]> reAttempt(int[][] input) {
        List<int[]> result = new ArrayList<>();
        int length = input.length;
        if (length == 0) return result;
        int[] prev = input[0];
        for (int i = 1; i < length; i++) {
            int[] curr = input[i];
            if (prev[1] >= curr[0]) prev[1] = Math.max(prev[1], curr[1]);
            else {
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        return result;
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
