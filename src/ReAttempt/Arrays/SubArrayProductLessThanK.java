package ReAttempt.Arrays;

import Common.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubArrayProductLessThanK extends Problem {
    @Override
    public void run() {
        System.out.println("Running Sub Array Product Less Than K");
        int[][] input = new int[][]{{2, 5, 3, 10}, {30},{8, 2, 6, 5}, {50},
                {10,5,2,6}, {100}, {1,2,3},{0}, {1,2,3,4,5}, {150}, {2, 1, 3, 25, 2, 1}, {75}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("K: " + input[i+1][0]);
            System.out.println("Sub Array Less Than K: " + this.findSubArraysLessThanK(input[i], input[i+1][0]));
            System.out.println("Sub Array Less Than K (Alternate): " + this.findSubArraysAlt(input[i], input[i+1][0]));
        }
    }

    private List<List<Integer>> findSubArraysLessThanK(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int length = arr.length;
        if (length == 0) return result;
        int left, right;
        right = left = 0;
        int prod = 1;
        List<Integer> subArray = new ArrayList<>();
        while (right < length) {
            if (arr[right] < k) {
                List<Integer> currList = new ArrayList<>();
                currList.add(arr[right]);
                result.add(currList);
                prod = prod * arr[right];
                while (left < right && prod >= k) {
                    if (subArray.size() > 1) {
                        result.add(new ArrayList<>(subArray));
                    }
                    prod = prod / arr[left];
                    subArray.remove(0);
                    left++;
                }
                subArray.add(arr[right]);
                right++;
            } else {
                right++;
                left = right;
            }
        }
        if (subArray.size() > 1) {
            result.add(new ArrayList<>(subArray));
        }
        return result;
    }

    private List<List<Integer>> findSubArraysAlt(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int length = arr.length;
        if (length == 0) return result;
        int left = 0;
        int prod = 1;
        for (int right = 0; right < length; right++) {
            prod *= arr[right];
            while (prod >= k && left < length) {
                prod /= arr[left++];
            }
            List<Integer> subList = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                subList.add(0, arr[i]);
                result.add(new ArrayList<>(subList));
            }
        }
        return result;
    }
}
