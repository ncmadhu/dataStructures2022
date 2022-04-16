package Problems.Stacks;

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
    }

    public void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        Stack<Integer> holdingStack = new Stack<>(stack.getCapacity());
        // Move first element to the holding stack
        holdingStack.push(stack.pop());
        // Check each element of stack
        while (!stack.isEmpty()) {
            Integer curr = stack.pop();
            // move curr element to bottom in the holding stack in descending order
            // by putting back larger elements than curr in the original stack
            while (!holdingStack.isEmpty() && holdingStack.top().compareTo(curr) > 0) {
                stack.push(holdingStack.pop());
            }
            holdingStack.push(curr);
        }
        while (!holdingStack.isEmpty()) {
            stack.push(holdingStack.pop());
        }
    }
}
