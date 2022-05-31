package Problems.String;

import Common.Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BalancedParentheses extends Problem {
    @Override
    public void run() {
        System.out.println("Running Balanced Parentheses");
        int[] input = new int[]{1,2,3,4};
        this.execute(input);
    }

    private void execute(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Output: " + this.balancedParentheses(input[i]));
        }
    }
    private class ParenthesesString {
        String str;
        int openCount;
        int closeCount;

        public ParenthesesString(String str, int openCount, int closeCount) {
            this.str = str;
            this.openCount = openCount;
            this.closeCount = closeCount;
        }
    }

    private List<String> balancedParentheses(int n) {
        List<String> parentheses = new ArrayList<>();
        if (n == 0) return parentheses;
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();
            if (ps.openCount == n && ps.closeCount == n) {
                parentheses.add(ps.str);
                continue;
            }
            if (ps.openCount < n) queue.add(new ParenthesesString(ps.str + "(",
                    ps.openCount + 1, ps.closeCount));
            if (ps.openCount > ps.closeCount) queue.add(new ParenthesesString(ps.str + ")",
                    ps.openCount, ps.closeCount + 1));

        }
        return parentheses;
    }
}
