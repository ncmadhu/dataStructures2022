package Problems.Heap;

import Common.Problem;

import java.util.Arrays;

public class FindKLargestElements extends Problem {
    Heap heap;
    @Override
    public void run() {
        System.out.println("Running Find K largestElement");
        int k;
        int[] heapArr;
        heap = new Heap();
        k = 2;
        heapArr = new int[]{9,4,7,1,-2,6,5};
        System.out.println("Input Array: " + Arrays.toString(heapArr));
        System.out.println("K largest (" + k + ") in Array: " + Arrays.toString(this.findKLargest(heapArr, k)));
        k = 3;
        heapArr = new int[]{9,4,7,1,-2,6,5};
        System.out.println("Input Array: " + Arrays.toString(heapArr));
        System.out.println("K largest (" + k + ") in Array: " + Arrays.toString(this.findKLargest(heapArr, k)));
        k = 5;
        heapArr = new int[]{9,4,7,1,-2,6,5};
        System.out.println("Input Array: " + Arrays.toString(heapArr));
        System.out.println("K largest (" + k + ") in Array: " + Arrays.toString(this.findKLargest(heapArr, k)));
    }

    public int[] findKLargest(int[] arr, int k) {
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = extractMax(arr, arr.length - i);
        }
        return result;
    }

    public int extractMax(int[] heapArr, int heapSize) {
        this.heap.buildMaxHeap(heapArr, heapSize);
        int max = heapArr[0];
        heapArr[0] = heapArr[heapSize - 1];
        return max;
    }
}
