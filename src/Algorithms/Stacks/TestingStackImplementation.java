package Algorithms.Stacks;

import Algorithms.Algorithms;

public class TestingStackImplementation extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Testing Stack Implementation");
        Stack<Integer> integerStack = new Stack<>(10);
        System.out.println("Max Size: " + integerStack.getCapacity());
        System.out.println("Is Empty: " + integerStack.isEmpty());
        for (int i = 0; i < 10; i++) {
            integerStack.push(i);
        }
        System.out.println("Is Full: " + integerStack.isFull());
        System.out.println("Top: " + integerStack.top());
        integerStack.push(11);
        for (int i = 0; i < 10; i++) {
            System.out.println("Pop: " + integerStack.pop());
        }
        System.out.println("Empty Pop: " + integerStack.pop());
    }
}
