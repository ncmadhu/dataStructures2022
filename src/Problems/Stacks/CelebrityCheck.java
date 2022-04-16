package Problems.Stacks;

import Common.Problem;

import java.util.Arrays;

public class CelebrityCheck extends Problem {
    @Override
    public void run() {
        System.out.println("Running Celebrity Check");
        int[][] arr;
        arr = new int[][]{{0,1,1,0},{1,0,1,1},{0,0,0,0},{0,1,1,0}};
        System.out.println("Input: ");
        for (int[] row: arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Celebrity: " + this.findCelebrity(arr, 4));
        arr = new int[][]{{0,1,0,1},{0,0,0,0},{1,1,0,0},{0,1,0,0}};
        System.out.println("Input: ");
        for (int[] row: arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Celebrity: " + this.findCelebrity(arr, 4));
        arr = new int[][]{{1,1,0},{0,1,0},{1,1,1}};
        System.out.println("Input: ");
        for (int[] row: arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Celebrity: " + this.findCelebrity(arr, 3));
        arr = new int[][]{{1,0,1},{1,1,0},{0,1,1}};
        System.out.println("Input: ");
        for (int[] row: arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Celebrity: " + this.findCelebrity(arr, 3));
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
