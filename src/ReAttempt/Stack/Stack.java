package ReAttempt.Stack;

public class Stack <T>{
    public int top;
    public int maxSize;
    public int size;
    public T[] arr;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        arr = (T[]) new Object[this.maxSize];
        this.size = 0;
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == maxSize;
    }

    public void push(T value) {
        if (this.isFull()) {
            System.out.println("Stack is Full");
            return;
        }
        arr[++top] = value;
        this.size++;
    }

    public T pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        this.size--;
        return this.arr[top--];
    }

    public T top() {
        if (this.isEmpty()) return null;
        return this.arr[this.top];
    }

    public int getCapacity() {
        return this.maxSize;
    }

    public int getCurrentSize() {
        return this.size;
    }

}
