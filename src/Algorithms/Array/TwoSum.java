package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class TwoSum extends Algorithms {

    @Override
    public void run() {
        System.out.println("Running Two Sum");
        int[] nums;
        int target;
        nums = new int[]{2,7,11,15};
        target = 9;
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(twoSum(nums,target)));
        nums = new int[]{2,3,4};
        target = 6;
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(alternateSolution(nums,target)));
        nums = new int[]{-1,0};
        target = -1;
        System.out.println(("Input: " + Arrays.toString(nums)));
        System.out.println("Output: " + Arrays.toString(alternateSolution(nums,target)));
    }

    public int[] twoSum(int[] numbers, int target) {
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
