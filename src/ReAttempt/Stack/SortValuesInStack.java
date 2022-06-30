package ReAttempt.Stack;

import Common.Problem;

public class SortValuesInStack extends Problem {
    @Override
    public void run() {
        System.out.println("Running Sort Values In Stack");
        Stack<Integer> integerStack = new Stack<>(10);
        integerStack.push(23);
        integerStack.push(60);
        integerStack.push(12);
        integerStack.push(42);
        integerStack.push(4);
        integerStack.push(97);
        integerStack.push(2);
        this.sortStack(integerStack);
        System.out.println("Sorted Stack: ");
        while (!integerStack.isEmpty()) {
            System.out.println(integerStack.pop());
        }
        integerStack = new Stack<>(10);
        integerStack.push(23);
        integerStack.push(60);
        integerStack.push(12);
        integerStack.push(42);
        integerStack.push(4);
        integerStack.push(97);
        integerStack.push(2);
        this.sortStackRecursion(integerStack);
        System.out.println("Sorted Stack Recursion: ");
        while (!integerStack.isEmpty()) {
            System.out.println(integerStack.pop());
        }
    }

    public void sortStack(Stack<Integer> stack) {
        if (stack.isFull()) return;
        Stack<Integer> holdingStack = new Stack<>(stack.getCapacity());
        holdingStack.push(stack.pop());
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            while (!holdingStack.isEmpty() && holdingStack.top().compareTo(curr) > 0) {
                stack.push(holdingStack.pop());
            }
            holdingStack.push(curr);
        }
        while (!holdingStack.isEmpty()) {
            stack.push(holdingStack.pop());
        }
    }

    public void sortStackRecursion(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int value = stack.pop();
            sortStackRecursion(stack);
            this.insert(stack, value);
        }
        return;
    }

    private void insert(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || value < stack.top()) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            this.insert(stack, value);
            stack.push(temp);
        }
    }
}
