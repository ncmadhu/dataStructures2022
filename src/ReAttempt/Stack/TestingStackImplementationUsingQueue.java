package ReAttempt.Stack;

import Common.Problem;

public class TestingStackImplementationUsingQueue extends Problem {
    @Override
    public void run() {
        System.out.println("Running Testing Stack Implementation Using Queue");
        StackUsingQueue<Integer> integerStack = new StackUsingQueue<>(10);
        System.out.println("Max Size: " + integerStack.getCapacity());
        System.out.println("Is Empty: " + integerStack.isEmpty());
        // Push O(1)
        for (int i = 1; i <= 10; i++) {
            System.out.println("Push 1: " + i);
            integerStack.push1(i);
        }
        System.out.println("Is Full: " + integerStack.isFull());
        System.out.println("Top 1: " + integerStack.top1());
        integerStack.push1(11);
        for (int i = 1; i <= 10; i++) {
            System.out.println("Pop 1: " + integerStack.pop1());
        }
        System.out.println("Empty Pop 1: " + integerStack.pop1());
        // Pop O(1)
        for (int i = 1; i <= 10; i++) {
            System.out.println("Push 2: " + i);
            integerStack.push2(i);
        }
        System.out.println("Is Full: " + integerStack.isFull());
        System.out.println("Top: " + integerStack.top2());
        integerStack.push2(11);
        for (int i = 1; i <= 10; i++) {
            System.out.println("Pop 2: " + integerStack.pop2());
        }
        System.out.println("Empty Pop 2: " + integerStack.pop2());
    }
}
