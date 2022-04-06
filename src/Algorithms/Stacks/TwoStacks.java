package Algorithms.Stacks;

public class TwoStacks<V> {
    private int maxSize;
    private int maxSize1;
    private int maxSize2;
    private int top1;
    private int top2;
    private V[] arr;

    @SuppressWarnings("unchecked")
    public TwoStacks(int maxSize) {
        this.arr = (V[]) new Object[maxSize];
        this.maxSize = maxSize;
        this.maxSize2 = maxSize / 2;
        this.maxSize1 = maxSize - maxSize2;
        this.top1 = -1;
        this.top2 = maxSize1 - 1;
    }

    public boolean isStack1Empty() {
        return top1 == -1;
    }

    public boolean isStack2Empty() {
        return top2 == maxSize1 - 1;
    }

    public boolean isStack1Full() {
        return top1 == maxSize1 - 1;
    }

    public boolean isStack2Full() {
        return top2 == maxSize - 1;
    }

    public void push1(V value) {
        if (isStack1Full()) return;
        arr[++top1] = value;
    }

    public void push2(V value) {
        if (isStack2Full()) return;
        arr[++top2] = value;
    }

    public V pop1() {
        if (isStack1Empty()) return null;
        return arr[top1--];
    }

    public V pop2() {
        if (isStack2Empty()) return null;
        return arr[top2--];
    }
}
