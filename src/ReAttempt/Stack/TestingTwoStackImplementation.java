package ReAttempt.Stack;

import Common.Problem;

public class TestingTwoStackImplementation extends Problem {
    @Override
    public void run() {
        System.out.println("Running Testing Two Stack Implementation");
        TwoStacks<Integer> twoStacks = new TwoStacks<>(10);
        System.out.println("Stack 1 Empty: " + twoStacks.isStack1Empty());
        System.out.println("Stack 2 Empty: " + twoStacks.isStack2Empty());
        for (int i = 1; i <= 5; i ++) {
            twoStacks.push1(i);
        }
        for (int i = 6; i <= 10; i ++) {
            twoStacks.push2(i);
        }
        System.out.println("Stack 1 Full: " + twoStacks.isFull());
        System.out.println("Stack 2 Full: " + twoStacks.isFull());
        twoStacks.push1(11);
        twoStacks.push2(11);
        System.out.println("Stack 1 Top: " + twoStacks.top1());
        System.out.println("Stack 2 Top: " + twoStacks.top2());
        System.out.println("Stack 1 Pop: ");
        while (!twoStacks.isStack1Empty()) {
            System.out.println(twoStacks.pop1());
        }
        System.out.println("Stack 2 Pop: ");
        while (!twoStacks.isStack2Empty()) {
            System.out.println(twoStacks.pop2());
        }
    }
}
