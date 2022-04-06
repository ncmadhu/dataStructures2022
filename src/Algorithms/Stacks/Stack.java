package Algorithms.Stacks;

public class Stack <V> {
    private int maxSize;
    private int top;
    private V arr[];
    private int currentSize;

    @SuppressWarnings("unchecked")
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        arr = (V[]) new Object[maxSize];
        this.currentSize = 0;
    }

    public int getCapacity() {
        return maxSize;
    }

    public int getCurrentSize() {return currentSize;}

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public V top() {
        if (isEmpty()) return null;
        return arr[top];
    }

    public void push(V value) {
        if (isFull()) {
            System.out.println("Stack is Full");
            return;
        }
        arr[++top] = value;
        currentSize++;
    }

    public V pop() {
        if (isEmpty()) {
            return null;
        }
        currentSize--;
        return arr[top--];
    }
}
