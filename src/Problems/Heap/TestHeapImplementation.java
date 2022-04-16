package Problems.Heap;

import Common.Problem;

import java.util.Arrays;

public class TestHeapImplementation extends Problem {
    @Override
    public void run() {
        System.out.println("Running Test Heap implementation");
        Heap heap;
        int[] heapArr;
        heap = new Heap();
        heapArr = new int[]{1, 4, 7, 12, 15, 14, 9, 2, 3, 16};
        System.out.println("Input Array: " + Arrays.toString(heapArr));
        heap.buildMaxHeap(heapArr);
        System.out.println("Max Heapified Array: " + Arrays.toString(heapArr));
        heap.buildMinHeap(heapArr);
        System.out.println("Min Heapified Array: " + Arrays.toString(heapArr));
    }
}
