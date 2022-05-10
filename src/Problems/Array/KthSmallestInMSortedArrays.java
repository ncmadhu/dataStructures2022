package Problems.Array;

import Common.Problem;

import java.util.*;

public class KthSmallestInMSortedArrays extends Problem {
    @Override
    public void run() {
        System.out.println("Running Kth Smallest In M Sorted Arrays");
        Integer[][] input = new Integer[][]{{4,7,9}, {1,3,5}, {4,5,9}, {5},
                {11,23,50}, {1,6,9}, {0,25, 50}, {1},
                {30, 32, 40}, {85, 90}, {30, 32, 40}, {8}};
        this.execute(input);
    }
    private void execute(Integer[][] input) {
        for (int i = 0; i < input.length; i = i + 4) {
            System.out.println("Array 1: " + Arrays.toString(input[i]));
            System.out.println("Array 2: " + Arrays.toString(input[i+1]));
            System.out.println("Array 3: " + Arrays.toString(input[i+2]));
            System.out.println("K: " + input[i+3][0]);
            List<Integer[]> list = new ArrayList<>();
            list.add(input[i]);
            list.add(input[i+1]);
            list.add(input[i+2]);
            System.out.println("Merged: " + Arrays.toString(this.mergeMSortedArrays(list)));
            System.out.println("Kth Smallest: " + this.findKthSmallest(list, input[i+3][0]));
            System.out.println("Median: " + this.findMedianOfMsortedArrays(list));
        }
    }


    class ArrayTracker {
        int arrayIndex;
        int elementIndex;
        ArrayTracker(int arrayIndex, int elementIndex) {
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }

    private Integer[] mergeMSortedArrays(List<Integer[]> list) {
        PriorityQueue<ArrayTracker> minHeap = new PriorityQueue<>(Comparator.comparingInt(n ->
                list.get(n.arrayIndex)[n.elementIndex]));
        int totalSize = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                totalSize += list.get(i).length;
                minHeap.add(new ArrayTracker(i, 0));
            }
        }
        int resultIndex = 0;
        Integer[] result = new Integer[totalSize];
        while(!minHeap.isEmpty()) {
            ArrayTracker arrayTracker = minHeap.poll();
            result[resultIndex++] = list.get(arrayTracker.arrayIndex)[arrayTracker.elementIndex];
            arrayTracker.elementIndex++;
            if (arrayTracker.elementIndex < list.get(arrayTracker.arrayIndex).length) minHeap.add(arrayTracker);
        }
        return result;
    }

    private int findKthSmallest(List<Integer[]> list, int k) {
        PriorityQueue<ArrayTracker> minHeap = new PriorityQueue<>(Comparator.comparingInt(n ->
                list.get(n.arrayIndex)[n.elementIndex]));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) minHeap.add(new ArrayTracker(i, 0)); // Add array and element index
        }
        int count = 0;
        while (!minHeap.isEmpty()) {
            ArrayTracker arrayTracker = minHeap.poll();
            if (++count == k) return list.get(arrayTracker.arrayIndex)[arrayTracker.elementIndex];
            arrayTracker.elementIndex++;
            if (arrayTracker.elementIndex < list.get(arrayTracker.arrayIndex).length) {
                minHeap.add(arrayTracker);
            }
        }
        return 0;
    }

    private int findMedianOfMsortedArrays(List<Integer[]> list) {
        int totalSize = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                totalSize += list.get(i).length;
            }
        }
        int k;
        if (totalSize % 2 == 0) k = totalSize / 2;
        else k = (totalSize / 2) + 1;
        return this.findKthSmallest(list, k);
    }
}
