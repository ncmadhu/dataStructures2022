package ReAttempt.Stack;


public class MinStack {
    private int maxSize;
    private Stack<Integer> valueStack;
    private Stack<Integer> minStack;

    public MinStack(int maxSize) {
        maxSize = maxSize;
        valueStack = new Stack<>(maxSize);
        minStack = new Stack<>(maxSize);
    }

    public int top() {
        return valueStack.top();
    }

    public int min() {
        return minStack.top();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return valueStack.getCurrentSize();
    }

    public boolean isEmpty() {
        return valueStack.isEmpty();
    }

    public boolean isFull() {
        return valueStack.isFull();
    }

    public void push(int value) {
        valueStack.push(value);
        if (minStack.isEmpty() || value < minStack.top()) {
            minStack.push(value);
        } else {
            // This maintains current min so far at this position corresponding to value stack
            minStack.push(minStack.top());
        }
    }

    public int pop() {
        minStack.pop(); // pop the corresponding min position also
        return valueStack.pop();
    }
}
