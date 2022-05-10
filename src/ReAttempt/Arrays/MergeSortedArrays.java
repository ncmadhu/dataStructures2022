package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class MergeSortedArrays extends Problem {
    @Override
    public void run() {
        System.out.println("Running Merge Sorted Array");
        int[][] input = new int[][]{{1, 3, 5}, {2, 4, 6},
                                    {1}, {},
                                    {}, {1},
                                    {0, 1}, {0,0},
                                    {1,2,3}, {4,5,6},
                                    {1,1,1},{2,2,2}};
        this.execute(input);
    }

    private void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            int[] nums1, nums2, merged;
            nums1 = input[i].clone();
            nums2 = input[i+1].clone();
            System.out.println(("Array 1: " + Arrays.toString(nums1)));
            System.out.println(("Array 2: " + Arrays.toString(nums2)));
            merged = this.merge(nums1, nums2);
            System.out.println(("Merged: " + Arrays.toString(merged)));
            nums1 = input[i].clone();
            nums2 = input[i+1].clone();
            merged = this.reAttempt(nums1, nums2);
            System.out.println(("Merged (Re Attempt): " + Arrays.toString(merged)));
        }
    }

    private int[] reAttempt(int[] nums1, int[] nums2) {
        int n1Len = nums1.length;
        int n2Len = nums2.length;
        int[] merged = new int[n1Len+n2Len];
        int n1, n2, m;
        n1 = n2 = m = 0;
        while (n1 < n1Len && n2 < n2Len) {
            if (nums1[n1] < nums2[n2]) merged[m++] = nums1[n1++];
            else merged[m++] = nums2[n2++];
        }
        while (n1 < n1Len) merged[m++] = nums1[n1++];
        while (n2 < n2Len) merged[m++] = nums2[n2++];
        return merged;
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int arr1Len = arr1.length;
        int arr2Len = arr2.length;

        // If any one of the array is zero return the other
        // If both are empty it does not matter which array is returned
        if (arr1Len == 0) return arr2;
        if (arr2Len == 0) return arr1;

        // Init new array to a length of combined array
        int[] merged = new int[arr1Len + arr2Len];

        int a1 = 0; // arr1 index start
        int a2 = 0; // arr2 index start
        int m = 0; // merged index start

        // compare elements in two arrays and add the lesser one to merged
        while (a1 < arr1Len && a2 < arr2Len) {
            if (arr1[a1] < arr2[a2]) {
                merged[m++] = arr1[a1++];
            } else {
                merged[m++] = arr2[a2++];
            }
        }

        // order does not matter since only one of the array can be non-empty at this point

        // add left over elements in arr1 to merged
        while (a1 < arr1Len) {
            merged[m++] = arr1[a1++];
        }

        // add left over elements in arr2 to merged
        while (a2 < arr2Len) {
            merged[m++] = arr2[a2++];
        }

        return merged;
    }
}
