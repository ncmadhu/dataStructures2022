package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class MergeSortedArray extends Problem {
    @Override
    public void run() {
        System.out.println("Running Merge Sorted Array");
        int[][] input = new int[][]{{1, 2, 3, 0, 0, 0}, {2, 5, 6}, {3,3},
                                    {1}, {}, {1, 0},
                                    {0}, {1}, {0, 1},
                                    {1, 3, 5, 0, 0, 0}, {1, 3, 5}, {3, 3},
                                    {4, 5, 6, 0, 0, 0}, {1, 2, 3}, {3, 3},
                                    {1, 1, 1, 0, 0, 0}, {2, 2, 2}, {3, 3},
                                    {2, 2, 2, 0, 0, 0}, {1, 1, 1}, {3, 3},
                                    {1, 1, 1, 0, 0, 0}, {1, 1, 1}, {3, 3},
                                    {0, 0, 0, 0, 0, 0}, {1, 2, 3, 4, 5, 6}, {0, 6}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 3) {
            int m, n;
            int[] nums1, nums2;
            nums1 = input[i];
            nums2 = input[i+1];
            m = input[i+2][0];
            n = input[i+2][1];
            System.out.println(("Input 1: " + Arrays.toString(nums1)));
            System.out.println(("Input 2: " + Arrays.toString(nums2)));
            this.mergeWithNoAuxSpace(nums1, m, nums2, n);
            System.out.println(("Output: " + Arrays.toString(nums1)));
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        int[] merged = new int[len];
        int i = 0;
        int j = 0;
        int k = 0;
        while (j < m && k < n) {
            if (nums1[j] <= nums2[k]) {
                merged[i++] = nums1[j++];
            } else {
                merged[i++] = nums2[k++];
            }
        }
        while (j < m) {
            merged[i++] = nums1[j++];
        }
        while (k < n) {
            merged[i++] = nums2[k++];
        }
        for (i = 0; i < len; i++) {
            nums1[i] = merged[i];
        }
    }

    private void mergeWithNoAuxSpace(int[] nums1, int m, int[] nums2, int n) {
        int n1Right = m - 1;
        int n2Right = n - 1;
        int insPos = m + n - 1;
        while (insPos >= 0) {
            // Because nums2 is the smaller array of two
            if (n2Right < 0) break;
            if (n1Right >= 0 && nums1[n1Right] > nums2[n2Right]) {
                nums1[insPos--] = nums1[n1Right--];
            } else {
                nums1[insPos--] = nums2[n2Right--];
            }
        }
    }
}
