package ReAttempt.Stack;

import Common.Problem;

public class BalancedParentheses extends Problem {
    @Override
    public void run() {
        System.out.println("Running Balanced Parentheses");
        String[] input = new String[]{"{[({})]}", "{[({{})]}"};
        this.execute(input);
    }

    private void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.println("Input: " + input[i]);
            System.out.println("Balanced: " + this.isBalanced(input[i]));
        }
    }

    private boolean isBalanced(String input) {
        int length = input.length();
        if (length == 0) return true;
        Stack<Character> stack = new Stack<>(length);
        for (int i = 0; i < length; i++) {
            char ch = input.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else {
                switch (ch) {
                    case ']':
                        if (stack.pop() != '[') return false;
                        break;
                    case '}':
                        if (stack.pop() != '{') return false;
                        break;
                    case ')':
                        if (stack.pop() != '(') return false;
                        break;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
