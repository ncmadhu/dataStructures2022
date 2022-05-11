package ReAttempt.Arrays;

import Common.Problem;

import java.util.Arrays;

public class NextLetter extends Problem {
    @Override
    public void run() {
        System.out.println("Running Next Letter");
        char[][] input = new char[][]{{'a', 'c', 'f', 'h'}, {'f'}, {'a', 'c', 'f', 'h'}, {'b'},
                {'a', 'c', 'f', 'h'}, {'m'}, {'a', 'c', 'f', 'h'}, {'h'}};
        this.execute(input);
    }

    private void execute(char[][] input) {
        for (int i = 0; i < input.length; i = i + 2) {
            System.out.println("Input: " + Arrays.toString(input[i]));
            System.out.println("Key: " + input[i+1][0]);
            System.out.println("Output: " + this.nextLetter(input[i], input[i+1][0]));
        }
    }

    private char nextLetter(char[] letters, char key) {
        int length = letters.length;
        if (length == 0) return ' ';
        int start, mid, end;
        start = 0;
        end = length-1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (letters[mid] == key) return letters[(mid + 1) % length];
            if (letters[mid] > key) end = mid - 1;
            else start = mid + 1;
        }
        return letters[start % length];
    }
}
