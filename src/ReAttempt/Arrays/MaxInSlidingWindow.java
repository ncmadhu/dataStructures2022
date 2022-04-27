package ReAttempt.Arrays;

import Common.Problem;

import java.util.*;

public class MaxInSlidingWindow extends Problem {
    @Override
    public void run() {
        System.out.println("Running Find Max In Sliding Window");
        int[][] input = new int[][]{{-4,2,-5,3,6}, {3}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {3},
                {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, {4}};
        this.execute(input);
    }

    public void execute(int[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            int[] arr = input[i];
            int window = input[i+1][0];
            System.out.println("Input: " + Arrays.toString(arr));
            System.out.println("Window Size: " + window);
            System.out.println("Output: " + Arrays.toString(this.findMaxInSlidingWindow(arr, window)));
            System.out.println("Output (Re Attempt BF): " + Arrays.toString(this.findMaxInSlidingWindow(arr, window)));
            System.out.println("Output (Priority Queue): " + Arrays.toString(this.findMaxInWindowPQ(arr, window)));
            System.out.println("Output (Re Attempt PQ): " + Arrays.toString(this.reAttemptPQ(arr, window)));
            System.out.println("Output (Double Ended Queue): " + Arrays.toString(this.findMaxInWindowDQ(arr, window)));
            System.out.println("Output (Re Attempt DQ): " + Arrays.toString(this.reAttemptDQ(arr, window)));
        }
    }

    private int[] reAttemptBF(int[] arr, int window) {
        int length = arr.length;
        if (length < window) window = length;
        int[] result = new int[length - window + 1];
        if (window == 0) return result;
        int left = 0;
        int right = window - 1;
        int resultIndex = 0;
        // Find the index of max element in the first window
        int maxIndex = this.findMaxIndex(arr, left, right);
        result[resultIndex] = arr[maxIndex];
        // Start sliding the window
        left += 1;
        right += 1;
        while (right < length) {
            // Check the current maxIndex is with in the window
            if (left <= maxIndex && arr[right] >= arr[maxIndex]) {
                // current maxIndex is with in the window, but the new incoming element is greater than
                // the current max
                maxIndex = right;
            } else if (left > maxIndex) {
                // current max index is not with in the window. Recalculate the max in the window
                maxIndex = this.findMaxIndex(arr, left, right);
            }
            result[++resultIndex] = arr[maxIndex];
        }
        return result;
    }

    private int[] reAttemptPQ(int[] arr, int window) {
        int length = arr.length;
        if (length < window) window = length;
        int[] result = new int[length - window + 1];
        if (length == 0) return result;
        if (length == 1) return arr;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < window; i++) {
            priorityQueue.add(arr[i]);
        }
        int resultIndex = 0;
        result[resultIndex] = priorityQueue.peek();
        for (int i = window; i < length; i++) {
            priorityQueue.add(arr[i - window]);
            priorityQueue.add(arr[i]);
            result[++resultIndex] = priorityQueue.peek();
        }
        return result;
    }

    private int[] reAttemptDQ(int[] arr, int window) {
        int length = arr.length;
        if (length < window) window = length;
        if (window == 1) return arr;
        int[] result = new int[length - window + 1];
        if (length == 0) return result;
        int resultIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < window; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (int i = window; i < length; i++) {
            result[resultIndex++] = arr[deque.peek()];
            while (!deque.isEmpty() && deque.peekFirst() <= i - window) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        result[resultIndex++] = arr[deque.peek()];
        return result;
    }

    private int[] findMaxInSlidingWindow(int[] arr, int window) {
        int length = arr.length;
        if (length == 0) return new int[]{};
        if (length < window) window = length;
        int left = 0;
        int right = window - 1;
        int maxIndex = this.findMaxIndex(arr, left, right);
        int[] maxInWindow = new int[(length - window) + 1];
        int maxWindowIndex = 0;
        maxInWindow[maxWindowIndex] = arr[maxIndex];
        left += 1;
        right += 1;
        while (right <= length - 1) {
            if (left <= maxIndex && arr[right] > arr[maxIndex]) {
                maxIndex = right;
            } else if (left > maxIndex) {
                maxIndex = this.findMaxIndex(arr, left, right);
            }
            maxInWindow[++maxWindowIndex] = arr[maxIndex];
            left++;
            right++;
        }
        return maxInWindow;
    }

    private int findMaxIndex(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (arr[i] > max) {
                maxIndex = i;
                max = arr[i];
            }
        }
        return maxIndex;
    }

    // Time complexity is nLogk
    // Insert in max/min heap takes log n times.
    // Since the insert is done n times and heap contains k elements at any point of time it is n log k
    private int[] findMaxInWindowPQ(int[] arr, int window) {
        int length = arr.length;
        if (length == 0) return new int[0];
        if (length < window) window = length;
        // Max heap - Priority queue stores min element at the top. Hence, reverse the order
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        // Result array initialization
        int[] result = new int[length - (window - 1)];
        int resultIndex = 0;
        // Add the elements in the first window size to the maxPQ
        for (int i = 0; i < window; i++) {
            maxPQ.add(arr[i]);
        }
        // Add the max element in the window to the result
        result[resultIndex] = maxPQ.peek();
        // Slide the window one at a time and calculate the max in that window
        for (int i = window; i < length; i++) {
            // Remove the element from the maxPQ out of the window
            maxPQ.remove(arr[i - window]);
            // Add new element
            maxPQ.add(arr[i]);
            // Add the max element in the window to the result
            result[++resultIndex] = maxPQ.peek();
        }
        return result;
    }

    // Double Ended Queue
    // Can add at both the ends and removed from both the ends
    private int[] findMaxInWindowDQ(int[] arr, int window) {
        int length = arr.length;
        if (length == 0) return new int[0];
        if (length < window) window = length;
        // Result array initialization
        int resultIndex = -1;
        int[] result = new int[length - (window - 1)];
        Deque<Integer> dQueue = new ArrayDeque<>();

        for (int i = 0; i < window; i++) {
            // remove the elements at the end which are less than the element being added
            while (!dQueue.isEmpty() && arr[dQueue.peekLast()] <= arr[i]) dQueue.removeLast();
            // Add the element to the end
            dQueue.addLast(i);
        }
        for (int i =  window; i < length; i++) {
            result[++resultIndex] = arr[dQueue.peek()];
            // remove the index out of the current window
            while (!dQueue.isEmpty() && dQueue.peekFirst() <= i - window) dQueue.removeFirst();
            // remove the elements at the end which are less than the element being added
            while (!dQueue.isEmpty() && arr[dQueue.peekLast()] <= arr[i]) dQueue.removeLast();
            // Add the element to the end
            dQueue.addLast(i);
        }
        result[++resultIndex] = arr[dQueue.peek()];
        return result;
    }
}
