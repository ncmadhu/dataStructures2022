package ReAttempt.Stack;

public class TwoStacks<T> {
    public int size;
    private int top1, top2;
    private T[] arr;

    public TwoStacks(int size) {
        this.size = size;
        this.top1 = -1;
        this.top2 = size;
        this.arr = (T[]) new Object[size];
    }

    public boolean isStack1Empty() {
        return top1 == -1;
    }

    public boolean isStack2Empty() {
        return top2 == size;
    }

    public boolean isFull() {
        return top1 == top2 - 1;
    }

    public void push1(T value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top1] = value;
    }

    public void push2(T value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[--top2] = value;
    }

    public T pop1() {
        if (isStack1Empty()) {
            System.out.println("Stack Underflow");
            return null;
        }
        return arr[top1--];
    }

    public T pop2() {
        if (isStack2Empty()) {
            System.out.println("Stack Underflow");
            return null;
        }
        return arr[top2++];
    }

    public T top1() {
        if (isStack1Empty()) {
            System.out.println("Stack Underflow");
            return null;
        }
        return arr[top1];
    }

    public T top2() {
        if (isStack2Empty()) {
            System.out.println("Stack Underflow");
            return null;
        }
        return arr[top2];
    }
}
