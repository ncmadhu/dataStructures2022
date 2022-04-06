package Algorithms.ReAttempt1.Arrays;

import Algorithms.Algorithms;

import java.util.Arrays;

public class ProductOfAllExceptItself extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Product of All Except Itself");
        int[] nums;
        nums =  new int[]{0,1,2};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output Brute Force: " + Arrays.toString(this.findProductBF(nums)));
        System.out.println("Output: " + Arrays.toString(this.findProduct(nums)));
        nums =  new int[]{0,1,2,0};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output Brute Force: " + Arrays.toString(this.findProductBF(nums)));
        System.out.println("Output: " + Arrays.toString(this.findProduct(nums)));
        nums =  new int[]{1,2,3,4};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output Brute Force: " + Arrays.toString(this.findProductBF(nums)));
        System.out.println("Output: " + Arrays.toString(this.findProduct(nums)));
        nums =  new int[]{2,5,9,3,6};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output Brute Force: " + Arrays.toString(this.findProductBF(nums)));
        System.out.println("Output: " + Arrays.toString(this.findProduct(nums)));
    }

    private int[] findProduct(int[] nums) {
        int length = nums.length;
        if (length == 0) return nums;
        int[] product = new int[length];
        int prod = 1;
        int zeroCount = 0;
        for (int i = 0; i < length; i++) {
            // More than one zero implies the product array will be zero
            if (zeroCount > 1) return product;
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                prod = prod * nums[i];
            }
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
