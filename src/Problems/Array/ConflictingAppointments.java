package Problems.Array;

import Common.Problem;

import java.util.Arrays;
import java.util.Comparator;

public class ConflictingAppointments extends Problem {
    @Override
    public void run() {
        System.out.println("Running Conflicting appointments");
        int[][] input;
        input = new int[][]{{6,7},{2,4}, {8,12}};
        this.execute(input);
        input = new int[][]{{4,5},{2,3}, {3,6}};
        this.execute(input);
        input = new int[][]{{1,4}, {2,5}, {7,9}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        System.out.println("Input: ");
        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
        System.out.println("Output: " + this.canAttendAllAppointments(input));
    }

    private boolean canAttendAllAppointments(int[][] input) {
        boolean attendAll = true;
        int length = input.length;
        if (length < 2) return attendAll;
        // Sort based in start time
        Arrays.sort(input, Comparator.comparingInt(a -> a[0]));
        int[] prev = input[0];
        for (int i = 1; i < length; i++) {
            int[] curr = input[i];
            if (prev[1] > curr[0]) return false;
            else prev = curr;
        }
        return attendAll;
    }
}
