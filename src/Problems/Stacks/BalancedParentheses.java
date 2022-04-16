package Problems.Stacks;

import Common.Problem;

public class BalancedParentheses extends Problem {
    @Override
    public void run() {
        System.out.println("Running Balanced Parentheses");
        String input;
        input = "{[({})]}";
        System.out.println("Input: " + input);
        System.out.println("Balanced: " + this.isBalanced(input));
        input = "{[({{})]}";
        System.out.println("Input: " + input);
        System.out.println("Balanced: " + this.isBalanced(input));
    }

    private boolean isBalanced(String input) {
        boolean isBalanced = true;
        Stack<Character> parenthesis = new Stack<>(input.length());
        for (char ch: input.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                parenthesis.push(ch);
            } else {
                switch (ch) {
                    case ']':
                        if (parenthesis.pop() != '[') {
                            isBalanced = false;
                            return isBalanced;
                        }
                        break;
                    case '}':
                        if (parenthesis.pop() != '{') {
                            isBalanced = false;
                            return isBalanced;
                        }
                        break;
                    case ')':
                        if (parenthesis.pop() != '(') {
                            isBalanced = false;
                            return isBalanced;
                        }
                        break;
                }
            }
        }
        return isBalanced;
    }
}
