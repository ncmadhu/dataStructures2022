package ReAttempt.Stack;

import Common.Problem;
import java.util.Arrays;

public class CelebrityCheck extends Problem {
    @Override
    public void run() {
        System.out.println("Running Celebrity Check");
        int[][][] input = new int[][][]{{{0, 1, 1, 0}, {1, 0, 1, 1}, {0, 0, 0, 0}, {0, 1, 1, 0}},
                {{0, 1, 0, 1}, {0, 0, 0, 0}, {1, 1, 0, 0}, {0, 1, 0, 0}},
                {{1, 1, 0}, {0, 1, 0}, {1, 1, 1}},
                {{1, 0, 1}, {1, 1, 0}, {0, 1, 1}}};
        this.execute(input);
    }

    private void execute(int[][][]input) {
        int[][] arr;
        for (int i = 0; i < input.length; i++) {
            arr = input[i];
            System.out.println("Input: ");
            for (int[] row: arr) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("Celebrity: " + this.findCelebrity(arr, arr.length));
            System.out.println("Celebrity (ReAttempt): " + this.reAttempt(arr, arr.length));
        }
    }

    private int reAttempt(int[][] party, int n) {
        if (n == 0) return -1;
        Stack<Integer> peopleStack = new Stack<>(n);
        for (int i = n-1; i >= 0; i--) {
            // Push all the people present to the stack
            peopleStack.push(i);
        }
        while (!peopleStack.isEmpty() && peopleStack.getCurrentSize() > 1) {
            int p1 = peopleStack.pop();
            int p2 = peopleStack.pop();
            // If P1 knows P2, then it can't be a celebrity (Celebrity doesn't know anybody else)
            // P2 can be a celebrity since it is known by someone else (Celebrity is known by everybody else)
            if (party[p1][p2] == 1) peopleStack.push(p2);
            // P1 can be a celebrity since it doesn't know P2.
            // P2 can't be a celebrity because it is not known by someone else
            else peopleStack.push(p1);
        }
        int celebrity  = peopleStack.pop();
        for (int i = 0; i < n; i++) {
            if (i != celebrity && party[celebrity][i] == 1) return -1;
        }
        return celebrity;
    }

    private int findCelebrity(int[][] party, int numPeople) {
        int celebrity = -1;
        // Initialize stack with the people index
        Stack<Integer> person = new Stack<>(numPeople);
        for (int i = numPeople - 1; i >= 0; i--) {
            person.push(i);
        }
        // Find somebody who does not know anybody
        // if x know y discard x ---> x knows somebody
        // if x does not y keep x ---> x can be celebrity
        while (!person.isEmpty() && person.getCurrentSize() > 1) {
            int p1 =  person.pop();
            int p2 = person.pop();
            if (party[p1][p2] == 1) {
                person.push(p2);
            } else {
                person.push(p1);
            }
        }
        celebrity = person.pop();
        for (int i = 0; i < numPeople; i++) {
            if (i != celebrity && party[celebrity][i] == 1) {
                celebrity = -1;
                break;
            }
        }
        return celebrity;
    }
}
