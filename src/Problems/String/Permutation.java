package Problems.String;

import Common.Problem;

public class Permutation extends Problem {
    int count;
    @Override
    public void run() {
        System.out.println("Running Permutation Of String");
        char[] chars;
        chars = new char[]{'a', 'b', 'c', 'd'};
        this.count = 0;
        this.permutate(chars, 0);
        System.out.println("Total run: " + this.count);

    }

    // Swap characters at the given index positions
    private void swap(char[] chars, int from, int to) {
        char temp = chars[from];
        chars[from] = chars[to];
        chars[to] = temp;
    }

    private void permutate(char[] chars, int index) {

        // Base case when index reaches the length new permutation has been reached
        // no more characters available to the right of the index to permutate
        if (index == chars.length) {
            this.count++;
            System.out.println(chars);
            return;
        }

        // String is divided into two parts <0 ---- index - 1><index ---- length - 1>
        // Characters in the first part remain static unchanged
        // Start from given index position
        // swap the characters to the index position one at a time iteratively
        // Call the permutate recursively
        // Restore the character at the index position to its original index at the end of the loop
        for (int curr = index; curr < chars.length; curr++) {
            this.swap(chars, index, curr); // This swap is to move characters to different index positions

            this.permutate(chars, index+1);
            this.swap(chars, index, curr); // This swap is to restore the characters to their original positions
        }
    }
}
