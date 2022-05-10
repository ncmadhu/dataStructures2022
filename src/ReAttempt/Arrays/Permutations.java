package ReAttempt.Arrays;

import Common.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations extends Problem {
    @Override
    public void run() {
        System.out.println("Running Permutations of Array");
        int[][] input = new int[][]{{1,3,5}, {1}, {1,2,3,4}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Permutations: " + this.permutate(input[i]));
            System.out.println("Permutations (Re Attempt): " + this.reAttempt(input[i]));
        }
    }

    private List<List<Integer>> reAttempt(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int length = arr.length;
        if (length == 0) return result;
        this.reAttemptPermutate(arr, 0, result);
        return result;
    }

    private void reAttemptPermutate(int[] arr, int index, List<List<Integer>> result) {
        if (index == arr.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int i: arr) {
                permutation.add(i);
            }
            result.add(permutation);
            return;
        }
        for (int curr = index; curr < arr.length; curr++) {
            this.swap(arr, curr, index);
            this.reAttemptPermutate(arr, index+1, result);
            this.swap(arr, index, curr);
        }
    }

    private List<List<Integer>> permutate(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr.length == 0) return result;
        this.permutate(arr, 0, result);
        return result;
    }
    private void swap(int[] arr, int src, int dst) {
        int temp = arr[src];
        arr[src] = arr[dst];
        arr[dst] = temp;
    }

    private void permutate(int[] arr, int index, List<List<Integer>> result) {
        if (index == arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : arr) {
                list.add(i);
            }
            result.add(list);
            return;
        }
        for (int curr = index; curr < arr.length; curr++) {
            this.swap(arr, index, curr);
            this.permutate(arr, index+1, result);
            this.swap(arr, curr, index);
        }
    }
}
