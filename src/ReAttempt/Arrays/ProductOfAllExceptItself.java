package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class ProductOfAllExceptItself extends Problem {
    @Override
    public void run() {
        System.out.println("Running Product of All Except Itself");
        int[][] input = new int[][]{{0, 1, 2}, {0, 1, 2, 0}, {1, 2, 3, 4}, {2, 5, 9, 3, 6}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            //System.out.println("Output Brute Force: " + Arrays.toString(this.findProductBF(input[i])));
            System.out.println("Output: " + Arrays.toString(this.findProduct(input[i])));
            System.out.println("Output: " + Arrays.toString(this.reAttempt(input[i])));
        }
    }

    private int[] reAttempt(int[] nums) {
        int length = nums.length;
        int[] product = new int[length];
        if (length == 0) return product;
        int prod = 1;
        int zeroCount = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                prod = prod * nums[i];
            } else {
                zeroCount += 1;
                if (zeroCount > 1) {
                    return product;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) product[i] = prod;
            else if (zeroCount == 1) product[i] = 0;
            else product[i] = prod / nums[i];
        }
        return product;
    }

    private int[] findProduct(int[] nums) {
        int length = nums.length;
        if (length == 0) return nums;
        int[] product = new int[length];
        int prod = 1;
        int zeroCount = 0;
        for (int i = 0; i < length; i++) {

            if (nums[i] == 0) {
                zeroCount++;
            } else {
                prod = prod * nums[i];
            }
            // More than one zero implies the product array will be zero
            if (zeroCount > 1) return product;
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                product[i] = prod;
            } else {
                if (zeroCount == 1) {
                    product[i] = 0;
                } else {
                    product[i] = prod / nums[i];
                }
            }
        }
        return product;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int[] findProductBF(int[] nums) {
        int length = nums.length;
        if (length == 0) return nums;
        int[] product = new int[length];
        for (int i = 0; i < length; i++) {
            this.swap(nums,0, i);
            int j = 1;
            int prod = 1;
            while (j < length) {
                prod = prod * nums[j];
                j++;
            }
            product[i] = prod;
            this.swap(nums, 0, i);
        }
        return product;
    }
}
