package Algorithms.Queues;

public class Queue<V> {
    private V[] arr;
    private int maxSize;
    private int front;
    private int back;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = (V[]) new Object[maxSize];
        front = 0;
        back = -1;
        currentSize = 0;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public boolean isFull() {
        return this.currentSize == maxSize;
    }

    public V top() {
        return arr[front];
    }

    public void enqueue(V value) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        back = (back + 1) % maxSize; // to keep index in range
        arr[back] = value;
        currentSize++;
    }

    public V dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }
        V value = arr[front];
        front = (front + 1) % maxSize; // to keep index in range
        currentSize--;
        return value;
    }
}
