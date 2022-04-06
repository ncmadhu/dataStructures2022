package Algorithms.Searching;

import Algorithms.Algorithms;

public class FirstBadVersion extends Algorithms {

    public final int BAD_VERSION = 7;

    private boolean isBadVersion(int version) {
        if (version >= BAD_VERSION) return true;
        return false;
    }

    public int firstBadVersion(int n) {

        int start =  1;
        int end = n;

        while (start < end) {
            int mid =  start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    @Override
    public void run() {
        System.out.println("Running FirstBadVersion");
        int badVersion = this.firstBadVersion(10);
        System.out.println("First Bad Version is: " + badVersion);
    }
}
