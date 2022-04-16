package Problems.Stacks;

import Common.Problem;

public class TestingMinStack extends Problem {
    @Override
    public void run() {
        System.out.println("Running Testing MinStack");
        MinStack minStack = new MinStack(10);
        minStack.push(5);
        minStack.push(2);
        minStack.push(4);
        minStack.push(1);
        minStack.push(3);
        minStack.push(9);
        System.out.println("Minimum: " + minStack.min());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println("Minimum: " + minStack.min());
        minStack.pop();
        minStack.pop();
        System.out.println("Minimum: " + minStack.min());
    }
}
