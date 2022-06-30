package ReAttempt.Stack;

import Common.Problem;

public class EvaluatePostfixExpression extends Problem {
    @Override
    public void run() {
        System.out.println("Running Evaluate Postfix Expression");
        String input[] = new String[]{"921*-8-4+", "638*+4-"};
        this.execute(input);
    }

    public void execute(String[] input) {
        for (int i = 0; i < input.length; i++) {
            String expression = input[i];
            System.out.println("Expression: " + expression);
            System.out.println("Output: " + this.evaluatePostfix(expression));
            System.out.println("Output (ReAttempt): " + this.reAttempt(expression));
        }
    }

    private int reAttempt(String expression) {
        int length = expression.length();
        if (length == 0) return 0;
        Stack<Integer> holdingStack = new Stack<>(length);
        for (int i = 0; i < length; i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                holdingStack.push(Character.getNumericValue(ch));
            } else {
                int n2 = holdingStack.pop();
                int n1 = holdingStack.pop();
                switch (ch) {
                    case '*':
                        holdingStack.push(n1 * n2);
                        break;
                    case '/':
                        holdingStack.push(n1 /  n2);
                        break;
                    case '+':
                        holdingStack.push(n1 + n2);
                        break;
                    case '-':
                        holdingStack.push(n1 - n2);
                        break;
                }
            }
        }
        return holdingStack.pop();
    }

    private int evaluatePostfix(String expression) {
        Stack<Integer> exprStack =  new Stack<>(expression.length());
        char[] chars = expression.toCharArray();
        for (char ch : chars) {
            if (ch == '%' || ch == '/' || ch == '*' || ch == '+' || ch == '-') {
                int result = 0;
                int n2 = exprStack.pop();
                int n1 = exprStack.pop();
                switch (ch) {
                    case '+':
                        result = n1 + n2;
                        break;
                    case '-':
                        result = n1 - n2;
                        break;
                    case '*':
                        result = n1 * n2;
                        break;
                    case '/':
                        result = n1 / n2;
                        break;
                }
                exprStack.push(result);
            } else {
                exprStack.push(Integer.parseInt(String.valueOf(ch)));
            }
        }
        return exprStack.pop();
    }
}
