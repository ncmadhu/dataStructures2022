package Algorithms.Queues;

import Algorithms.Algorithms;
import Algorithms.Stacks.Stack;

public class QueueImplementationUsingStack<V> {
    private Stack<V> stack1;
    private Stack<V> stack2;
    private int maxSize;

    public QueueImplementationUsingStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack1 = new Stack<>(maxSize);
        this.stack2 = new Stack<>(maxSize);
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Method 1
    // Enqueue takes O(2n) ---> O(n)
    public void enqueue1(V value) {
        if (stack1.isEmpty()) {
            stack1.push(value);
        } else {
            //Keep the first inserted element always at the top
            //Move everything to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            //push new element
            stack1.push(value);
            //Move everything back to stack1
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }

    // Dequeue takes O(1) time
    public V dequeue1() {
        return stack1.pop();
    }

    // Method 2
    // Enqueue takes O(1)
    public void enqueue2(V value) {
        // Add elements to the stack1
        stack1.push(value);
    }

    // Dequeue takes O(n)
    public V dequeue2() {
        if (!stack2.isEmpty()) {
            // If stack2 is not empty, then it has the first inserted element
            return stack2.pop();
        } else if (!stack1.isEmpty()) {
            // If stack1 is not empty, then it has latest inserted element at the top
            // move everything to stack2 to get the first inserted element
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return null;
        }
    }
}
