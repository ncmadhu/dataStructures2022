package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class CycleSort extends Problem {
    @Override
    public void run() {
        System.out.println("Running Cycle Sort");
        int[][] input = new int[][]{{3, 1, 5, 4, 2}, {2, 6, 4, 3, 1, 5},
                {1, 5, 6, 4, 3, 2}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            this.cycleSort(input[i]);
            System.out.println("Output: " +Arrays.toString(input[i]));
        }
    }

    private void cycleSort(int[] arr) {
        int length = arr.length;
        if (length == 0) return;
        int index = 0;
        while (index < length) {
            if (arr[index] != index + 1) {
                int temp = arr[index];
                arr[index] = arr[temp - 1];
                arr[temp - 1] = temp;
            } else {
                index++;
            }
        }
    }
}
