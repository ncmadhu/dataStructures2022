package Algorithms.Heap;

import Algorithms.Algorithms;

import java.util.Arrays;

public class FindKSmallestElements extends Algorithms {
    Heap heap;
    @Override
    public void run() {
        System.out.println("Running Find K smallest Element");
        int k;
        int[] heapArr;
        heap = new Heap();
        k = 2;
        heapArr = new int[]{9,4,7,1,-2,6,5};
        System.out.println("Input Array: " + Arrays.toString(heapArr));
        System.out.println("K smallest (" + k + ") in Array: " + Arrays.toString(this. findKSmallest(heapArr, k)));
        k = 3;
        heapArr = new int[]{9,4,7,1,-2,6,5};
        System.out.println("Input Array: " + Arrays.toString(heapArr));
        System.out.println("K smallest (" + k + ") in Array: " + Arrays.toString(this. findKSmallest(heapArr, k)));
        k = 5;
        heapArr = new int[]{9,4,7,1,-2,6,5};
        System.out.println("Input Array: " + Arrays.toString(heapArr));
        System.out.println("K smallest (" + k + ") in Array: " + Arrays.toString(this. findKSmallest(heapArr, k)));
    }

    public int[] findKSmallest(int[] arr, int k) {
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = extractMin(arr, arr.length);
        }
        return result;
    }

    public int extractMin(int[] heapArr, int heapSize) {
        this.heap.buildMinHeap(heapArr, heapArr.length);
        int min = heapArr[0];
        heapArr[0] = heapArr[heapSize - 1];
        return min;
    }
}
