package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class MergeSortedArrays extends Problem {
    @Override
    public void run() {
        System.out.println("Running Merge Sorted Array");
        int m, n;
        int[] nums1, nums2, merged;

        nums1 = new int[]{1,2,3};
        nums2 = new int[]{2,5,6};
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        merged  = this.merge(nums1, nums2);
        System.out.println(("Output: " + Arrays.toString(merged)));

        nums1 = new int[]{1};
        nums2 = new int[]{};
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        merged  = this.merge(nums1, nums2);
        System.out.println(("Output: " + Arrays.toString(merged)));

        nums1 = new int[]{0};
        nums2 = new int[]{1};
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        merged  = this.merge(nums1, nums2);
        System.out.println(("Output: " + Arrays.toString(merged)));

        nums1 = new int[]{0,0,0,1,3,5};
        nums2 = new int[]{1,3,5};
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        merged  = this.merge(nums1, nums2);
        System.out.println(("Output: " + Arrays.toString(merged)));

        nums1 = new int[]{4,5,6};
        nums2 = new int[]{1,2,3};
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        merged  = this.merge(nums1, nums2);
        System.out.println(("Output: " + Arrays.toString(merged)));

        nums1 = new int[]{1,1,1};
        nums2 = new int[]{2,2,2};
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        merged  = this.merge(nums1, nums2);
        System.out.println(("Output: " + Arrays.toString(merged)));

        nums1 = new int[]{2,2,2};
        nums2 = new int[]{1,1,1};
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        merged  = this.merge(nums1, nums2);
        System.out.println(("Output: " + Arrays.toString(merged)));

        nums1 = new int[]{1,1,1};
        nums2 = new int[]{1,1,1};
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        merged  = this.merge(nums1, nums2);
        System.out.println(("Output: " + Arrays.toString(merged)));

        nums1 = new int[]{};
        nums2 = new int[]{1,2,3,4,5,6};
        System.out.println(("Input 1: " + Arrays.toString(nums1)));
        System.out.println(("Input 2: " + Arrays.toString(nums2)));
        merged  = this.merge(nums1, nums2);
        System.out.println(("Output: " + Arrays.toString(merged)));

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
