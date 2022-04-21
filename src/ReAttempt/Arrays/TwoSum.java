package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum extends Problem {

    @Override
    public void run() {
        System.out.println("Running Two Sum");
        int[][] input;
        input = new int[][]{{2, 7, 11, 15}, {9}, {2, 3, 4}, {6}, {-1, 0}, {-1}, {5, 7, 8, 9}, {25}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            int[] nums = input[i];
            int target = input[i+1][0];
            System.out.println("Input: " + Arrays.toString(nums));
            System.out.println("Target: " + target);
            System.out.println("Output: " + Arrays.toString(twoSum(nums,target)));
            System.out.println("Output (WithOut Aux Space): " + Arrays.toString(twoSum(nums,target)));
        }
    }

    private int[] twoSum(int[] nums, int target) {
        int[] indices = new int[] {-1,-1};
        HashMap<Integer, Integer> otherNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (otherNum.containsKey(target - nums[i])) {
                indices[0] = otherNum.get(target - nums[i]);
                indices[1] = i;
            } else {
                otherNum.put(nums[i], i);
            }
        }
        return indices;
    }

    // This solution for sorted arrays
    private int[] twoSumWithOutAuxSpace(int[] nums, int target) {
        int[] indices = new int[]{-1,-1};
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int currSum = nums[left] + nums[right];
            if (currSum == target) {
                indices[0] = left;
                indices[1] = right;
                break;
            } else if (currSum < target) left++;
            else right--;
        }
        return indices;

    }

    public int[] twoSumO(int[] numbers, int target) {
        int[] indices = new int[2];
        int length = numbers.length;
        for(int i=0;i<length-1;i++) {
            for(int j=i+1;j<length;j++) {
                if(numbers[i] + numbers[j] == target) {
                    indices[0] = i + 1;
                    indices[1] = j + 1;
                    break;
                }
            }
        }
        return indices;
    }

    public int[] alternateSolution(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            int currSum = numbers[left] + numbers[right];
            if (currSum == target) {
                return new int[]{left + 1, right + 1};
            } else if(currSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}
