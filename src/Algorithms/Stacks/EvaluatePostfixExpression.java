package Algorithms.Stacks;

import Algorithms.Algorithms;

public class EvaluatePostfixExpression extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Evaluate Postfix Expression");
        String expression;
        expression = "921*-8-4+";
        System.out.println("Expression: " + expression);
        System.out.println("Output: " + this.evaluatePostfix(expression));
        expression = "638*+4-";
        System.out.println("Expression: " + expression);
        System.out.println("Output: " + this.evaluatePostfix(expression));
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
