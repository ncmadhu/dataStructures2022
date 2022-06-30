package ReAttempt.Trees;

import Common.Problem;

import java.util.Arrays;

public class SegmentTree extends Problem {
    @Override
    public void run() {
        System.out.println("Running Segment Tree");
        int[][] input = new int[][]{{1,3,5,7,9,11}, {3,4,2,1,6,-1,-2}};
        int[][] ranges = new int[][]{{1,3},{0,0},{0,5},{4,5},{0,5}};
        int[][] update = new int[][]{{2,-4},{1,2},{2,2},{5,-20},{4,-3}};
        this.execute(input, ranges, update);
    }

    private void execute(int[][] input, int[][] ranges, int[][] update) {
        Operation minOp = new MinOperation();
        Operation sumOp = new SumOperation();
        for (int i = 0; i < input.length; i++) {
            int[] minSegArr = this.createSegmentTree(input[i], minOp);
            int[] sumSegArr = this.createSegmentTree(input[i], sumOp);
            int[] minInputClone = input[i].clone();
            int[] minSegCloneOne = minSegArr.clone();
            int[] minSegCloneTwo = minSegArr.clone();
            int[] minLazy = new int[minSegCloneTwo.length];
            int[] sumInputClone = input[i].clone();
            int[] sumSegCloneOne = sumSegArr.clone();
            int[] sumSegCloneTwo = sumSegArr.clone();
            int[] sumLazy = new int[sumSegCloneTwo.length];
            for (int j = 0; j < ranges.length; j++) {
                System.out.println("****************************************************");
                System.out.println("Input: " + Arrays.toString(minInputClone));
                //System.out.println("Min Segment Tree: " + Arrays.toString(minSegClone));
                System.out.println("Min In Range (" + ranges[j][0] + "," + ranges[j][1] + ") :" +
                        this.minRangeQuery(minSegCloneOne, ranges[j][0], ranges[j][1],0,input[i].length-1, 0));
                //System.out.println("Min Segment Tree: " + Arrays.toString(minSegCloneOne));
                //System.out.println("Min Segment Tree: " + Arrays.toString(minSegCloneTwo));
                System.out.println("Min In Range (Lazy) (" + ranges[j][0] + "," + ranges[j][1] + ") :" +
                        this.minRangeQueryLazy(minSegCloneTwo, minLazy, ranges[j][0], ranges[j][1],0,input[i].length-1, 0));
                System.out.println("Update " + update[j][0] + " by " + update[j][1]);
                this.updateMinSegmentTree(minInputClone, minSegCloneOne, update[j][0], update[j][1]);
                this.updateMinSegmentTreeLazy(minInputClone, minSegCloneTwo, minLazy, update[j][0], update[j][1]);
                System.out.println("Input: " + Arrays.toString(minInputClone));
                //System.out.println("Min Segment Tree: " + Arrays.toString(minSegClone));
                System.out.println("Min In Range (" + ranges[j][0] + "," + ranges[j][1] + ") :" +
                        this.minRangeQuery(minSegCloneOne, ranges[j][0], ranges[j][1],0,input[i].length-1, 0));
                //System.out.println("Min Segment Tree: " + Arrays.toString(minSegCloneTwo));
                System.out.println("Min In Range (Lazy) (" + ranges[j][0] + "," + ranges[j][1] + ") :" +
                        this.minRangeQueryLazy(minSegCloneTwo, minLazy, ranges[j][0], ranges[j][1],0,input[i].length-1, 0));
                System.out.println("****************************************************");
            }
            for (int j = 0; j < ranges.length; j++) {
                System.out.println("****************************************************");
                System.out.println("Input: " + Arrays.toString(sumInputClone));
                System.out.println("Sum In Range (" + ranges[j][0] + "," + ranges[j][1] + ") :" +
                        this.sumRangeQuery(sumSegCloneOne, ranges[j][0], ranges[j][1],0,input[i].length-1, 0));
                System.out.println("Sum In Range(Lazy) (" + ranges[j][0] + "," + ranges[j][1] + ") :" +
                        this.sumRangeQueryLazy(sumSegCloneTwo, sumLazy, ranges[j][0], ranges[j][1],0,input[i].length-1, 0));
                System.out.println("Update " + update[j][0] + " by " + update[j][1]);
                this.updateSumSegmentTree(sumInputClone, sumSegCloneOne, update[j][0], update[j][1]);
                this.updateSumSegmentTreeLazy(sumInputClone, sumSegCloneTwo, sumLazy, update[j][0], update[j][1]);
                System.out.println("Input: " + Arrays.toString(sumInputClone));
                System.out.println("Sum In Range (" + ranges[j][0] + "," + ranges[j][1] + ") :" +
                        this.sumRangeQuery(sumSegCloneOne, ranges[j][0], ranges[j][1],0,input[i].length-1, 0));
                System.out.println("Sum In Range(Lazy) (" + ranges[j][0] + "," + ranges[j][1] + ") :" +
                        this.sumRangeQueryLazy(sumSegCloneTwo, sumLazy, ranges[j][0], ranges[j][1],0,input[i].length-1, 0));
                System.out.println("****************************************************");
            }
        }
    }

    interface Operation {
        //int[] init(int len);
        int perform(int a, int b);
    }

    private class MinOperation implements Operation {
        @Override
        public int perform(int a, int b) {
            return Math.min(a,b);
        }
    }

    private class SumOperation implements Operation {
        @Override
        public int perform(int a, int b) {
            return a + b;
        }
    }

    private int nextPowOf2(int n) {
        if (n > 0 && (n & (n-1)) == 0) return n;
        int count = 0;
        while (n != 0) {
            n = n >> 1;
            count += 1;
        }
        return 1 << count;
    }

    private int[] createSegmentTree(int[] arr, Operation minOp) {
        if (arr == null) return null;
        int len = arr.length;
        int nextPowOf2 = this.nextPowOf2(len);
        int [] segArr = new int[nextPowOf2*2-1];
        this.constructSegmentTree(arr, segArr, 0, len-1, 0, minOp);
        return segArr;
    }

    private void constructSegmentTree(int[] arr, int[] segArr, int low, int high, int pos, Operation operation) {
        if (low == high) {
            segArr[pos] = arr[low];
            return;
        }
        int mid = low + (high - low) / 2;
        this.constructSegmentTree(arr,segArr, low, mid, 2*pos + 1, operation);
        this.constructSegmentTree(arr, segArr, mid+1, high, 2*pos + 2, operation);
        segArr[pos] = operation.perform(segArr[2*pos + 1], segArr[2*pos +2]);
    }


    private void updateMinSegmentTree(int[] input, int[] segArr, int index, int delta) {
        if (index < 0 || index >= input.length) return;
        input[index] += delta;
        this.updateMinSegmentTree(segArr, index, delta, 0, input.length-1, 0);
    }

    private void updateMinSegmentTree(int[] segArr, int index, int delta, int low, int high, int pos) {
        // If index is greater than high, then that side of tree does not need any update
        // If index is lower than low, then that side of tree does not need any update
        if (index < low || index > high) return;

        // If low == high we have a position to update
        if (low == high) {
            segArr[pos] += delta;
            return;
        }

        // Partial overlap. Traverse both side of the tree
        int mid = low + (high-low) / 2;
        this.updateMinSegmentTree(segArr, index, delta, low, mid, 2*pos+1);
        this.updateMinSegmentTree(segArr, index, delta, mid+1, high, 2*pos+2);
        segArr[pos] = Math.min(segArr[2*pos+1], segArr[2*pos+2]);
    }

    private void updateMinSegmentTreeLazy(int[] input, int[] segArr, int[] lazy, int index, int delta) {
        this.updateMinSegmentTreeLazy(segArr, lazy, index, index, delta, 0, input.length-1, 0);
    }

    private void updateMinSegmentTreeLazy(int[] segArr, int[] lazy, int start, int end, int delta,
                                          int low, int high, int pos) {
        if (low > high) return;

        // Update the child value because of previous updates and not done due to lazy
        if (lazy[pos] != 0) {
            segArr[pos] += lazy[pos];
            if (low != high) { // check for leaf node
                // propagate to children
                lazy[2*pos + 1] += lazy[pos];
                lazy[2*pos + 2] += lazy[pos];
            }
            lazy[pos] = 0; // Reset the value
        }

        if (start > high || end < low) {
            return; // No overlap
        }

        if (start <= low && end >= high) {
            // total overlap
            segArr[pos] += delta;
            if (low != high) { // check for leaf node
                // propagate to children
                lazy[2*pos + 1] += lazy[pos];
                lazy[2*pos + 2] += lazy[pos];
            }
            return;
        }

        // partial overlap
        int mid = low + (high-low) / 2;
        this.updateMinSegmentTreeLazy(segArr, lazy, start, end, delta, low, mid, 2*pos+1);
        this.updateMinSegmentTreeLazy(segArr, lazy, start, end, delta, mid+1, high, 2*pos+2);
        segArr[pos] = Math.min(segArr[2*pos+1], segArr[2*pos+2]);
    }


    private void updateSumSegmentTree(int[] input, int[] segArr, int index, int delta) {
        if (index < 0 || index >= input.length) return;
        input[index] += delta;
        this.updateSumSegmentTree(segArr, index, delta, 0, input.length-1, 0);
    }

    private void updateSumSegmentTree(int[] segArr, int index, int delta, int low, int high, int pos) {
        if (index < low || index > high) return;
        if (low == high) {
            segArr[pos] += delta;
            return;
        }
        int mid = low + (high-low) / 2;
        this.updateSumSegmentTree(segArr, index, delta, low, mid, 2*pos+1);
        this.updateSumSegmentTree(segArr, index, delta, mid+1, high, 2*pos+2);
        segArr[pos] = segArr[2*pos+1] + segArr[2*pos+2];
    }

    private void updateSumSegmentTreeLazy(int[] input, int[] segArr, int[] lazy, int index, int delta) {
        this.updateSumSegmentTreeLazy(segArr, lazy, index, index, delta, 0, input.length-1, 0);
    }

    private void updateSumSegmentTreeLazy(int[] segArr, int[] lazy, int start, int end, int delta,
                                          int low, int high, int pos) {
        if (low > high) return;

        // Update the child value because of previous updates and not done due to lazy
        if (lazy[pos] != 0) {
            segArr[pos] += lazy[pos];
            if (low != high) { // check for leaf node
                // propagate to children
                lazy[2*pos + 1] += lazy[pos];
                lazy[2*pos + 2] += lazy[pos];
            }
            lazy[pos] = 0; // Reset the value
        }

        if (start > high || end < low) {
            return; // No overlap
        }

        if (start <= low && end >= high) {
            // total overlap
            segArr[pos] += delta;
            if (low != high) { // check for leaf node
                // propagate to children
                lazy[2*pos + 1] += lazy[pos];
                lazy[2*pos + 2] += lazy[pos];
            }
            return;
        }

        // partial overlap
        int mid = low + (high-low) / 2;
        this.updateSumSegmentTreeLazy(segArr, lazy, start, end, delta, low, mid, 2*pos+1);
        this.updateSumSegmentTreeLazy(segArr, lazy, start, end, delta, mid+1, high, 2*pos+2);
        segArr[pos] = segArr[2*pos+1] + segArr[2*pos+2];
    }



    private int minRangeQuery(int[] segArr, int qLow, int qHigh, int low, int high, int pos) {
        // No overLap
        if (qHigh < low || qLow > high) return Integer.MAX_VALUE;

        // Total overlap
        if (qLow <= low && qHigh >= high) return segArr[pos];

        // Partial overlap
        int mid = low + (high-low) / 2;
        return Math.min(this.minRangeQuery(segArr, qLow, qHigh, low, mid, 2*pos + 1),
                this.minRangeQuery(segArr, qLow, qHigh, mid+1, high, 2*pos + 2));
    }

    private int minRangeQueryLazy(int[] segArr, int[] lazy, int qLow, int qHigh, int low, int high, int pos) {
        if (low > high) return Integer.MAX_VALUE;

        // Update the child value because of previous updates and not done due to lazy
        if (lazy[pos] != 0) {
            segArr[pos] += lazy[pos];
            if (low != high) { // check for leaf node
                // propagate to children
                lazy[2*pos + 1] += lazy[pos];
                lazy[2*pos + 2] += lazy[pos];
            }
            lazy[pos] = 0; // Reset the value
        }

        if (qLow > high || qHigh < low) {
            return Integer.MAX_VALUE; // No overlap
        }

        if (qLow <= low && qHigh >= high) {
            // total overlap
            return segArr[pos];
        }

        // partial overlap
        int mid = low + (high-low) / 2;

        return Math.min(this.minRangeQueryLazy(segArr, lazy, qLow, qHigh, low, mid, 2*pos+1),
                this.minRangeQueryLazy(segArr, lazy, qLow, qHigh, mid+1, high, 2*pos+2));

    }

    private int sumRangeQuery(int[] segArr, int qLow, int qHigh, int low, int high, int pos) {
        // No overlap
        if (qLow > high || qHigh < low) return 0;

        // Total overlap
        if (qLow <= low && qHigh >= high) return segArr[pos];

        // Partial overlap
        int mid = low + (high-low) / 2;
        return this.sumRangeQuery(segArr, qLow, qHigh, low, mid, 2*pos+1) +
                this.sumRangeQuery(segArr, qLow, qHigh, mid+1, high, 2*pos+2);
    }

    private int sumRangeQueryLazy(int[] segArr, int[] lazy, int qLow, int qHigh, int low, int high, int pos) {
        if (low > high) return 0;

        // Update the child value because of previous updates and not done due to lazy
        if (lazy[pos] != 0) {
            segArr[pos] += lazy[pos];
            if (low != high) { // check for leaf node
                // propagate to children
                lazy[2*pos + 1] += lazy[pos];
                lazy[2*pos + 2] += lazy[pos];
            }
            lazy[pos] = 0; // Reset the value
        }

        if (qLow > high || qHigh < low) {
            return 0; // No overlap
        }

        if (qLow <= low && qHigh >= high) {
            // total overlap
            return segArr[pos];
        }

        // partial overlap
        int mid = low + (high-low) / 2;

        return this.sumRangeQueryLazy(segArr, lazy, qLow, qHigh, low, mid, 2*pos+1) +
                this.sumRangeQueryLazy(segArr, lazy, qLow, qHigh, mid+1, high, 2*pos+2);

    }
}
