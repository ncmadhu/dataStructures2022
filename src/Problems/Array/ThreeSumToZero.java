package Problems.Array;

import Common.Problem;

import java.util.*;

public class ThreeSumToZero extends Problem {
    @Override
    public void run() {
        System.out.println("Running Three Sum To Zero");
        int[][] input = new int[][]{{-3, 0, 1, 2, -1, 1, -2}, {-5, 2, -1, -2, 3}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Output: " + this.searchTriplets(input[i]));
        }
    }

    private List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int length = arr.length;
        if (length == 0) return result;
        for (int i = 0; i < length - 2; i++) {
            this.twoSum(arr,i + 1,- arr[i], result);
        }
        return result;
    }

    private void twoSum(int[] arr, int start, int target, List<List<Integer>> result) {
        HashSet<Integer> otherNum = new HashSet<>();
        for (int i = start; i < arr.length; i++) {
            if (otherNum.contains(target - arr[i])) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(arr[start-1]);
                triplet.add(target - arr[i]);
                triplet.add(arr[i]);
                result.add(triplet);
            } else {
                otherNum.add(arr[i]);
            }
        }
    }
}
