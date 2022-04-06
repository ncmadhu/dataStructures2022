package Algorithms.Stacks;

public class MinStack {
    private int maxSize;
    private Stack<Integer> valueStack;
    private Stack<Integer> minStack;

    public MinStack(int maxSize) {
        this.maxSize = maxSize;
        this.valueStack = new Stack<>(maxSize);
        this.minStack = new Stack<>(maxSize);
    }

    public Integer pop() {
        // Remove corresponding min stack value also
        minStack.pop();
        return valueStack.pop();
    }

    public void push(Integer value) {
        valueStack.push(value);
        if (minStack.isEmpty() || value < minStack.top()) {
            minStack.push(value);
        } else {
            minStack.push(minStack.top());
        }
    }

    public int min() {
        return minStack.top();
    }

}
