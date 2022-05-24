package Problems.String;

import Common.Problem;

public class PalindromicPartitioning extends Problem {
    @Override
    public void run() {
        System.out.println("Running Palindromic Partitioning");
        String[] input = new String[]{"noonabbad", "abdbca", "cddpd", "pqr"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Brute Force: " + this.palindromicPartitioning(input[i]));
            System.out.println("Top Down " + this.palindromicPartitioningTopDown(input[i]));
            System.out.println("Bottom Up " + this.palindromicPartitioningBottomUp(input[i]));
        }
    }

    private int palindromicPartitioningTopDown(String s) {
        int length = s.length();
        if (length < 2) return 0;
        Integer[][] mem = new Integer[length][length];
        Boolean[][] isPalindrome = new Boolean[length][length];
        return this.palindromicPartitioningTopDown(s, 0, length-1, mem, isPalindrome);
    }

    private int palindromicPartitioningTopDown(String s, int start, int end,
                                               Integer[][] mem, Boolean[][] isPalindrome) {
        if (mem[start][end] != null) return mem[start][end];
        if (start >= end || this.isPalindromeDP(s, start, end, isPalindrome)) return 0;
        int minCuts = end - start;
        for (int i = start; i <= end; i++) {
            if (this.isPalindromeDP(s, start, i, isPalindrome)) {
                minCuts = Math.min(minCuts, 1 + this.palindromicPartitioningTopDown(s, i+1, end, mem,
                        isPalindrome));
            }
        }
        mem[start][end] = minCuts;
        return mem[start][end];
    }

    private boolean isPalindromeDP(String s, int start, int end, Boolean[][] isPalindrome) {
        if (isPalindrome[start][end] != null) return isPalindrome[start][end];
        int left = start;
        int right = end;
        isPalindrome[start][end] = true;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                isPalindrome[start][end] = false;
                break;
            }
            if (left < right && isPalindrome[left][right] != null) {
                isPalindrome[start][end] = isPalindrome[left][right];
                break;
            }
        }
        return isPalindrome[start][end];
    }

    private int palindromicPartitioning(String s) {
        return this.palindromicPartitioning(s, 0, s.length()-1);
    }

    private int palindromicPartitioning(String s, int start, int end) {
        // No need to cut if the string is palindrome
        if (start >= end || this.isPalindrome(s, start, end)) return 0;

        // At max we need to cut string into n - 1 pieces
        int minCuts = end - start;
        for (int i = start; i <= end; i++) {
            if(this.isPalindrome(s, start, i)) {
                minCuts = Math.min(minCuts, 1 + this.palindromicPartitioning(s, i+1, end));
            }
        }
        return minCuts;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    private int palindromicPartitioningBottomUp(String s) {
        int length =  s.length();
        if (length < 2) return 0;

        // Building isPalindrome table
        boolean[][] isPalindrome = new boolean[length][length];
        // All one character is a palindrome
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
        }
        // Building isPalindrome for other combos with bottom up
        for (int start = length - 1; start >= 0; start--) {
            for (int end = start + 1; end < length; end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start == 1 || isPalindrome[start+1][end-1]) {
                        isPalindrome[start][end] = true;
                    }
                }
            }
        }

        // Populate every cuts table with minimum cuts required at that index to the end
        int[] cuts = new int[length];
        for (int start = length - 1; start >= 0; start--) {
            int minCuts = length;
            for (int end = length - 1; end >= start; end--) {
                if (isPalindrome[start][end]) {
                    minCuts = (end  == length-1) ? 0: Math.min(minCuts, 1 + cuts[end+1]);
                }
            }
            cuts[start] = minCuts;
        }
        return cuts[0];
    }
}
