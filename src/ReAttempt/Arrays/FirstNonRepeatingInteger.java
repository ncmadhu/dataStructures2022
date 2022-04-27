package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;
import java.util.HashMap;

public class FirstNonRepeatingInteger extends Problem {
    @Override
    public void run() {
        System.out.println("Running Product of All Except Itself");
        int[][] input = new int[][]{{9, 2, 3, 2, 6, 6}, {1, 1, 2, 2, 3, 3, 4}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Output: " + this.findFirstUnique(input[i]));
            System.out.println("ReAttempt: " + this.reAttempt(input[i]));
        }
    }

    private int reAttempt(int[] nums) {
        int length = nums.length;
        if (length == 0) return -1;
        HashMap<Integer,Integer> count = new HashMap<>();
        for (int i = 0; i < length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < length; i++) {
            if (count.get(nums[i]) == 1) return nums[i];
        }
        return -1;
    }

    private int findFirstUnique(int[] nums) {
        if (nums.length == 0) return -1;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (countMap.get(nums[i]) == 1) return nums[i];
        }
        return -1;
    }
}
