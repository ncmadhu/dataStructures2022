package Algorithms.Heap;

public class Heap {

    // Build Max Heap for the whole array
    public void buildMaxHeap(int[] heapArray) {
        this.buildMaxHeap(heapArray, heapArray.length);
    }

    // Build Max Heap for the part of array
    // Useful in HeapSort where tail end stores the sorted elements
    public void buildMaxHeap(int[] heapArray, int heapSize) {
        // Parents present in the first half of the array
        // Hence pass parent nodes only to check for maxHeapProperty
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            this.maxHeapify(heapArray, i, heapSize);
        }
    }

    private void maxHeapify(int[] heapArray, int index, int heapSize) {
        // Init current largest element index
        // Assume element at the index value is the maximum between its left child and right child
        int largestIndex = index;
        while (index < heapSize / 2) { // do only for parent nodes
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            // Check left child value with value at current largestIndex to determine largestIndex
            // check leftChildIndex is within bounds of considered heap elements which can be partial array
            // in case of HeapSort
            if (leftChildIndex < heapSize && heapArray[leftChildIndex] > heapArray[largestIndex]) {
                largestIndex = leftChildIndex;
            }

            // Check right child value with value at current largestIndex to determine largestIndex
            // check rightChildIndex is within bounds of considered heap elements which can be partial array
            // in case of HeapSort
            if (rightChildIndex < heapSize && heapArray[rightChildIndex] > heapArray[largestIndex]) {
                largestIndex = rightChildIndex;
            }

            // largest value among Parent, leftChild and rightChild is identified
            // swap the parent with the largest value
            if (index != largestIndex) {
                // largestIndex change determines swap condition
                int temp = heapArray[index];
                heapArray[index] = heapArray[largestIndex];
                heapArray[largestIndex] = temp;
                // This is done to continue the maxHeapify for the nodes rooted at the largestIndex value
                // whose max heap property may have been invalidated because of this swap
                index = largestIndex;
            } else {
                // No swap needed
                // already maxHeapified
                break;
            }
        }
    }

    // Build Min Heap for the whole array
    public void buildMinHeap(int[] heapArray) {
        this.buildMinHeap(heapArray, heapArray.length);
    }

    // Build Min Heap for the part of array
    // Useful in HeapSort where tail end stores the sorted elements
    public void buildMinHeap(int[] heapArray, int heapSize) {
        // Parents present in the first half of the array
        // Hence pass parent nodes only to check for minHeapProperty
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            this.minHeapify(heapArray, i, heapSize);
        }
    }

    private void minHeapify(int[] heapArray, int index, int heapSize) {
        // Init current minimum element index
        // Assume element at the index value is the minimum between its left child and right child
        int smallestIndex = index;
        while (index < heapSize / 2) { // do only for parent nodes
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            // Check left child value with value at current smallestIndex to determine smallestIndex
            // check leftChildIndex is within bounds of considered heap elements which can be partial array
            // in case of HeapSort
            if (leftChildIndex < heapSize && heapArray[leftChildIndex] < heapArray[smallestIndex]) {
                smallestIndex = leftChildIndex;
            }

            // Check right child value with value at current smallestIndex to determine smallestIndex
            // check rightChildIndex is within bounds of considered heap elements which can be partial array
            // in case of HeapSort
            if (rightChildIndex < heapSize && heapArray[rightChildIndex] < heapArray[smallestIndex]) {
                smallestIndex = rightChildIndex;
            }

            // smallest value among Parent, leftChild and rightChild is identified
            // swap the parent with the smallest value
            if (index != smallestIndex) {
                // smallestIndex change determines swap condition
                int temp = heapArray[index];
                heapArray[index] = heapArray[smallestIndex];
                heapArray[smallestIndex] = temp;
                // This is done to continue the minHeapify for the nodes rooted at the smallestIndex value
                // whose min heap property may have been invalidated because of this swap
                index = smallestIndex;
            } else {
                // No swap needed
                // already minHeapified
                break;
            }
        }
    }
}
