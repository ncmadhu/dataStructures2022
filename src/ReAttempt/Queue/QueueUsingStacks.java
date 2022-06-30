package ReAttempt.Queue;

import ReAttempt.Stack.Stack;

public class QueueUsingStacks<T> {
    public int maxSize;
    public Stack<T> stack1;
    public Stack<T> stack2;

    public QueueUsingStacks(int maxSize) {
        this.maxSize = maxSize;
        this.stack1 = new Stack<>(maxSize);
        this.stack2 = new Stack<>(maxSize);
    }

    public boolean isEmpty() {
        return this.stack1.isEmpty() && this.stack2.isEmpty();
    }

    public boolean isFull() {
        return this.stack1.size + this.stack2.size == this.maxSize;
    }

    public void enqueue(T value) {
        if (this.isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        this.stack1.push(value);
    }

    public T dequeue() {
        if (!this.stack2.isEmpty()) return this.stack2.pop();
        else if (! this.stack1.isEmpty()) {
            while (!this.stack1.isEmpty()) {
                this.stack2.push(this.stack1.pop());
            }
            return this.stack2.pop();
        } else {
            System.out.println("Queue is Empty");
            return null;
        }
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getCurrentSize() {
        return this.stack1.size + this.stack2.size;
    }

    public T top() {
        if (!this.stack2.isEmpty()) return this.stack2.top();
        else if (! this.stack1.isEmpty()) {
            while (!this.stack1.isEmpty()) {
                this.stack2.push(this.stack1.pop());
            }
            return this.stack2.top();
        } else {
            System.out.println("Queue is Empty");
            return null;
        }
    }
}
