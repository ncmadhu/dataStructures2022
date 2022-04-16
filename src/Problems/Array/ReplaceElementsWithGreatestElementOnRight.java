package Problems.Array;

import Common.Problem;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRight extends Problem {
    @Override
    public void run() {
        System.out.println("Running Replace Elements With Greatest Element On Right");
        int[] nums;
        nums = new int[]{17,18,5,4,6,1};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.replaceElements(nums)));
        nums = new int[]{400};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(this.replaceElements(nums)));
    }

    public int[] replaceElements(int[] arr) {
        int length = arr.length - 1;
        int maxIndex = 0;
        for (int i = 0; i < length; i ++) {
            if (maxIndex <= i) {
                maxIndex = this.max(arr, i + 1, length);
            }
            arr[i] = arr[maxIndex];
        }
        arr[length] = -1;
        return arr;
    }
    
    public int max(int[] arr, int start, int end) {
        int maxIndex = start;
        for (int j = start + 1; j <= end; j++) {
            if (arr[maxIndex] < arr[j]) {
                maxIndex  = j;
            }
        }
        return maxIndex;
    }
}
