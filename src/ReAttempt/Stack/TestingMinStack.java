package ReAttempt.Stack;

import Common.Problem;

public class TestingMinStack extends Problem {
    @Override
    public void run() {
        System.out.println("Running Testing MinStack");
        MinStack minStack = new MinStack(10);
        System.out.println("Pushing: 5");
        minStack.push(5);
        System.out.println("Pushing: 2");
        minStack.push(2);
        System.out.println("Pushing: 4");
        minStack.push(4);
        System.out.println("Pushing: 1");
        minStack.push(1);
        System.out.println("Pushing: 3");
        minStack.push(3);
        System.out.println("Pushing: 9");
        minStack.push(9);
        System.out.println("Minimum: " + minStack.min());
        System.out.println("Popping: " + minStack.pop());
        System.out.println("Minimum: " + minStack.min());
        System.out.println("Popping: " + minStack.pop());
        System.out.println("Popping: " + minStack.pop());
        System.out.println("Minimum: " + minStack.min());
        System.out.println("Popping: " + minStack.pop());
        System.out.println("Minimum: " + minStack.min());
        System.out.println("Popping: " + minStack.pop());
        System.out.println("Minimum: " + minStack.min());
    }
}
