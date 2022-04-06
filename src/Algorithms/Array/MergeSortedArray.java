package Algorithms.Array;

import Algorithms.Algorithms;

import java.util.Arrays;

public class MergeSortedArray extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Merge Sorted Array");
        int m, n;
        int[] nums1, nums2;
        nums1 = new int[]{1,2,3,0,0,0};
        nums2 = new int[]{2,5,6};
        m = 3;
        n = 3;
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        this.merge(nums1, m, nums2, n);
        System.out.println(("Output: " + Arrays.toString(nums1)));
        nums1 = new int[]{1};
        nums2 = new int[]{};
        m = 1;
        n = 0;
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        this.merge(nums1, m, nums2, n);
        System.out.println(("Output: " + Arrays.toString(nums1)));
        nums1 = new int[]{0};
        nums2 = new int[]{1};
        m = 0;
        n = 1;
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        this.merge(nums1, m, nums2, n);
        System.out.println(("Output: " + Arrays.toString(nums1)));
        nums1 = new int[]{1,3,5,0,0,0};
        nums2 = new int[]{1,3,5};
        m = 3;
        n = 3;
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        this.merge(nums1, m, nums2, n);
        System.out.println(("Output: " + Arrays.toString(nums1)));
        nums1 = new int[]{4,5,6,0,0,0};
        nums2 = new int[]{1,2,3};
        m = 3;
        n = 3;
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        this.merge(nums1, m, nums2, n);
        System.out.println(("Output: " + Arrays.toString(nums1)));
        nums1 = new int[]{1,1,1,0,0,0};
        nums2 = new int[]{2,2,2};
        m = 3;
        n = 3;
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        this.merge(nums1, m, nums2, n);
        System.out.println(("Output: " + Arrays.toString(nums1)));
        nums1 = new int[]{2,2,2,0,0,0};
        nums2 = new int[]{1,1,1};
        m = 3;
        n = 3;
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        this.merge(nums1, m, nums2, n);
        System.out.println(("Output: " + Arrays.toString(nums1)));
        nums1 = new int[]{1,1,1,0,0,0};
        nums2 = new int[]{1,1,1};
        m = 3;
        n = 3;
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        this.merge(nums1, m, nums2, n);
        System.out.println(("Output: " + Arrays.toString(nums1)));
        nums1 = new int[]{0,0,0,0,0,0};
        nums2 = new int[]{1,2,3,4,5,6};
        m = 0;
        n = 6;
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        this.merge(nums1, m, nums2, n);
        System.out.println(("Output: " + Arrays.toString(nums1)));

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1right = m - 1;
        int n2right = n - 1;

        for (int insPos = m + n - 1; insPos >=0; insPos--) {
            if (n2right < 0) {
                break;
            }

            if (n1right >= 0 && nums1[n1right] > nums2[n2right]) {
                nums1[insPos] = nums1[n1right--];
            } else {
                nums1[insPos] = nums2[n2right--];
            }
        }
    }
}
