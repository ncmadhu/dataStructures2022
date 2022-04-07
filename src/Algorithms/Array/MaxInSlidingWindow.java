package Algorithms.Array;

import Algorithms.Algorithms;

import java.awt.*;
import java.util.*;

public class MaxInSlidingWindow extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Find Max In Sliding Window");
        int[] arr;
        int window;
        this.execute(new int[]{-4,2,-5,3,6}, 3);
        this.execute(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3);
        this.execute(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4);
    }

    public void execute(int[] arr, int window) {
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Window Size: " + window);
        System.out.println("Output: " + Arrays.toString(this.findMaxInSlidingWindow(arr, window)));
        System.out.println("Output (Priority Queue): " + Arrays.toString(this.findMaxInWindowPQ(arr, window)));
        System.out.println("Output (Double Ended Queue): " + Arrays.toString(this.findMaxInWindowDQ(arr, window)));
    }

    private int[] findMaxInSlidingWindow(int[] arr, int window) {
        int length = arr.length;
        if (length == 0) return new int[]{};
        if (length < window) window = length;
        int left = 0;
        int right = window - 1;
        int maxIndex = this.findMaxIndex(arr, left, right);
        int[] maxInWindow = new int[length - (window - 1)];
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
        // Remove the first element from the maxPQ
        maxPQ.remove(arr[0]);
        // Slide the window one at a time and calculate the max in that window
        for (int i = window; i < length; i++) {
            maxPQ.add(arr[i]);
            // Add the max element in the window to the result
            result[++resultIndex] = maxPQ.peek();
            maxPQ.remove(arr[i - window + 1]);
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
        for (int i = 0; i < window; ++i) {
            // remove the elements at the end which are less than the element being added
            while (!dQueue.isEmpty() && arr[dQueue.peekLast()] <= arr[i]) dQueue.removeLast();
            // Add the element to the end
            dQueue.addLast(i);
        }
        for (int i =  window; i < length; ++i) {
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
