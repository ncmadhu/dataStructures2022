package Problems.Heap;

import Common.Problem;
import Problems.BinaryTree.TreeNode;

import java.util.Arrays;
import java.util.List;

import static Problems.BinaryTree.TreeNode.levelOrderTraversal;

public class HeapImplementation extends Problem {

    @Override
    public void run() {
        System.out.println("Running Heap Implementation");
        this.testMaxHeapImplementation();
    }

    public void testMaxHeapImplementation() {
        int[] nums;
        nums =  new int[]{10,5,8,20,2,18};
        System.out.println(("Input: " + Arrays.toString(nums)));
        TreeNode completeBinaryTree = TreeNode.buildCompleteBinaryTree(nums);
        List<Integer> values = levelOrderTraversal(completeBinaryTree);
        System.out.println("Complete Binary Tree: " + values);
        this.buildMaxHeap(nums);
        completeBinaryTree = TreeNode.buildCompleteBinaryTree(nums);
        values = levelOrderTraversal(completeBinaryTree);
        System.out.println("Max Heapified Complete Binary Tree: " + values);
        System.out.println("Heap Maximum: " + this.getHeapMax(nums));
        this.increaseHeapKey(nums, 3, 25);
        System.out.println("Array After Key Increase: " + Arrays.toString(nums));
        System.out.println("Extract Heap Maximum: " + this.extractHeapMax(nums, nums.length-1));
        System.out.println("Extract Heap Maximum: " + this.extractHeapMax(nums, nums.length-2));
        nums =  new int[]{10,5,8,20,2,18};
        System.out.println("Input: " + Arrays.toString(nums));
        this.heapSort(nums);
        System.out.println("Heap Sorted Array: " + Arrays.toString(nums));
        /*
        this.buildMinHeap(nums);
        completeBinaryTree = TreeNode.buildCompleteBinaryTree(nums);
        values = levelOrderTraversal(completeBinaryTree);
        System.out.println("Min Heapified Complete Binary Tree: " + values);*/
    }

    public void maxHeapify(int[] nums, int index, int heapSize) {
       int left = 2 * index + 1;
       int right = 2 * index + 2;

       int largest = index;

       if (left <= heapSize && nums[left] > nums[index]) {
           largest = left;
       }
       if (right <= heapSize && nums[right] > nums[largest]) {
            largest = right;
       }
       if (largest != index) {
           int temp = nums[index];
           nums[index] = nums[largest];
           nums[largest] = temp;
           maxHeapify(nums, largest, heapSize);
       }
    }

    public int getHeapMax(int[] nums) {
        return nums[0];
    }

    public int extractHeapMax(int[] nums, int heapSize) {
        if (heapSize < 0) {
            System.out.println("Heap underflow");
            return Integer.MIN_VALUE;
        }
        int heapMax = nums[0];
        nums[0] = nums[heapSize];
        this.maxHeapify(nums, 0,heapSize - 1);
        return heapMax;
    }

    public void increaseHeapKey(int[] nums, int index, int key) {
        if (key < nums[index]) {
            System.out.println("Key is smaller than current key");
        }
        nums[index] = key;
        while (index > 0 && nums[this.parent(index)] < nums[index]) {
            int temp = nums[this.parent(index)];
            nums[this.parent(index)] = nums[index];
            nums[index] = temp;
            index = this.parent(index);
        }
    }

    public int parent(int index) {
        return Math.floorDiv(index - 1, 2);
    }

    public void buildMaxHeap(int[] nums) {
        int length = nums.length;
        // leaves start from n/2 for n element array
        // Bottom up approach
        for (int i = length / 2; i >= 0; i--) {
            this.maxHeapify(nums, i, length - 1);
        }
    }

    public void heapSort(int[] nums) {
        this.buildMaxHeap(nums);
        for (int i = nums.length - 1; i >= 1; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            this.maxHeapify(nums, 0, i - 1);
        }
    }

    public void minHeapify(int[] nums, int i) {
        int left = 2 * i + 1;
        int right =  2 * i + 2;

        int smallest = i;

        if (left < nums.length && nums[left] < nums[smallest]) {
            smallest = left;
        }

        if (right < nums.length && nums[right] < nums[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = nums[i];
            nums[i] = nums[smallest];
            nums[smallest] = temp;
            minHeapify(nums, smallest);
        }
    }

    public void buildMinHeap(int[] nums) {
        int length = nums.length;
        // leaves start from n/2 for n element array
        // Bottom approach
        for (int i = length / 2; i >= 0; i--) {
            this.minHeapify(nums, i);
        }
    }
}
