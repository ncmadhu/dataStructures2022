package Problems.Scratch;

import Common.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scratch extends Problem {
    @Override
    public void run() {
        int[] input = new int[]{1,2,3};
        List<Integer[]> result = threeNumberSum(input, 6);
        for (Integer[] triplets: result) {
            System.out.println(Arrays.toString(triplets));
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            twoSum(array, i + 1, targetSum - array[i], result);
        }
        return result;
    }
    public static void twoSum(int[] array, int start, int target, List<Integer[]> result) {
        int left = start;
        int right = array.length - 1;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == target) result.add(new Integer[]{array[start - 1], array[left++], array[right--]});
            if (sum < target) left++;
            if (sum > target) right --;
        }
    }
}
