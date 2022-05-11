package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;
import java.util.Comparator;

public class ConflictingAppointments extends Problem {
    @Override
    public void run() {
        System.out.println("Running Conflicting appointments");
        int[][][] input;
        input = new int[][][]{{{6,7},{2,4}, {8,12}},
                              {{4,5},{2,3}, {3,6}},
                              {{1,4}, {2,5}, {7,9}}};
        this.execute(input);
    }

    private void execute(int[][][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: ");
            for (int j = 0; j < input[i].length; j++) {
                System.out.println(Arrays.toString(input[i][j]));
            }
            int[][] schedules;
            schedules = input[i].clone();
            System.out.println("Output: " + this.canAttendAllAppointments(schedules));
            schedules = input[i].clone();
            System.out.println("Output (Re Attempt): " + this.reAttempt(schedules));
        }
    }
    private boolean reAttempt(int[][] schedules) {
        boolean canAttend = true;
        int length = schedules.length;
        if (length < 2) return canAttend;
        // Sort based on meeting starting time
        Arrays.sort(schedules, Comparator.comparingInt(n -> n[0]));
        for (int i = 0; i < length - 1; i++) {
            if (schedules[i][1] > schedules[i+1][0]) return false;
        }
        return canAttend;
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
