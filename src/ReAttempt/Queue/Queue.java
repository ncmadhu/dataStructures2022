package ReAttempt.Queue;

public class Queue <T>{
    public int maxSize;
    public int size;
    public T[] arr;
    public int front;
    public int back;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = (T[]) new Object[this.maxSize];
        this.front = 0;
        this.back = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.maxSize;
    }

    public T top() {
        if (this.isEmpty()) return null;
        return this.arr[front];
    }

    public void enqueue(T value) {
        if (this.isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        back = (back + 1) % this.maxSize;
        arr[back] = value;
        size++;
    }

    public T dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }
        T value = arr[front];
        front = (front + 1) % maxSize;
        this.size--;
        return value;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return this.size;
    }
}
