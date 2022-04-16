package Problems.Stacks;

import Common.Problem;

import java.util.Arrays;

public class NextGreaterElement extends Problem {
    @Override
    public void run() {
        System.out.println("Running Next Greater Element");
        int[] arr;
        arr = new int[]{4,6,3,2,8,1,2};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Brute Force Output: " + Arrays.toString(this.bruteForceNextGreaterElement(arr)));
        System.out.println("Two Pointer Output: " + Arrays.toString(this.twoPointerNextGreaterElement(arr)));
        System.out.println("Stack Output: " + Arrays.toString(this.stackNextGreaterSolution(arr)));
        arr = new int[]{1,3,8,4,10,5};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Brute Force Output: " + Arrays.toString(this.bruteForceNextGreaterElement(arr)));
        System.out.println("Two Pointer Output: " + Arrays.toString(this.twoPointerNextGreaterElement(arr)));
        System.out.println("Stack Output: " + Arrays.toString(this.stackNextGreaterSolution(arr)));
    }

    private int[] stackNextGreaterSolution(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> tempStack = new Stack<>(arr.length);
        for (int i = arr.length - 1; i >= 0; i--) {
            // Try to bring up greater element than the current element in the stack
            if (!tempStack.isEmpty()) {
                while (!tempStack.isEmpty() && tempStack.top() <= arr[i]) {
                    tempStack.pop();
                }
            }
            // If stack is empty no next greater element than current one
            // else current stack top is the next greater element
            if (tempStack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = tempStack.top();
            }
            // push curr element to stack
            tempStack.push(arr[i]);
        }
        return result;
    }

    private int[] bruteForceNextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flipped = false;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    result[i] = arr[j];
                    flipped = true;
                    break;
                }
            }
            if (!flipped) result[i] = -1;
        }
        result[result.length - 1] = -1;
        return result;
    }

    private int[] twoPointerNextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        int left = 0, right = 1;
        while (left < arr.length - 1) {
            if (arr[left] < arr[right]) {
                while (left < right) {
                    result[left] = arr[right];
                    left++;
                }
            }
            right++;
            if (right == arr.length) {
                result[left] = -1;
                left++;
                right = left + 1;
            }
        }
        result[result.length - 1] = -1;
        return result;
    }
}
