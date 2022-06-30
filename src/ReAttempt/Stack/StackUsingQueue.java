package ReAttempt.Stack;

import ReAttempt.Queue.Queue;

public class StackUsingQueue<T> {
    public int maxSize;
    public Queue<T> queue1;
    public Queue<T> queue2;

    public StackUsingQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue1 = new Queue<>(maxSize);
        this.queue2 = new Queue<>(maxSize);
    }

    // Push Operation O(1)
    public void push1(T value) {
        if (isFull()) return;
        queue1.enqueue(value);
    }

    // Pop operation O(n)
    public T pop1() {
        while (queue1.size > 1) queue2.enqueue(queue1.dequeue());
        T value = queue1.dequeue();
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return value;
    }

    public T top1() {
        while (queue1.size > 1) queue2.enqueue(queue1.dequeue());
        T value = queue1.dequeue();
        queue2.enqueue(value);
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return value;
    }

    // Push Operation O(n)
    public void push2(T value) {
        if (isFull()) return;
        if (queue1.isEmpty()) {
            queue1.enqueue(value);
            return;
        }
        queue2.enqueue(value);
        while (!queue1.isEmpty()) {
            queue2.enqueue(queue1.dequeue());
        }
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop Operation O(1)
    public T pop2() {
        return queue1.dequeue();
    }

    public T top2() {
        return queue1.top();
    }

    public int getCapacity() {
        return this.maxSize;
    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public boolean isFull() {
        return queue1.size + queue2.size == maxSize;
    }

}
