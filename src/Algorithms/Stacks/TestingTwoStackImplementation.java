package Algorithms.Stacks;

import Algorithms.Algorithms;

public class TestingTwoStackImplementation extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Testing Two Stack Implementation");
        TwoStacks<Integer> twoStacks = new TwoStacks<>(5);
        for (int i = 1; i < 4; i ++) {
            twoStacks.push1(i);
        }
        for (int i = 4; i < 6; i ++) {
            twoStacks.push2(i);
        }
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
