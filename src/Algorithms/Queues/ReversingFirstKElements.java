package Algorithms.Queues;

import Algorithms.Algorithms;
import Algorithms.Stacks.Stack;

public class ReversingFirstKElements extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Reversing First K Elements in Queue");
        Queue<Integer> intQueue = new Queue<>(10);
        int k = 5;
        for(int i = 1; i <= 10; i++) {
            intQueue.enqueue(i);
        }
        this.reverseK(intQueue, k);
        System.out.println("Output: ");
        for (int i = 0; i < intQueue.getMaxSize(); i++) {
            System.out.print(intQueue.dequeue() +  ",");
        }
        System.out.println("NULL");
        intQueue = new Queue<>(3);
        k = 3;
        for(int i = 1; i <=3 ; i++) {
            intQueue.enqueue(i);
        }
        this.reverseK(intQueue, k);
        System.out.println("Output: ");
        for (int i = 0; i < intQueue.getMaxSize(); i++) {
            System.out.print(intQueue.dequeue() +  ",");
        }
        System.out.println("NULL");
    }

    public <V> void reverseK(Queue<V> que, int k) {
        Stack<V> kStack  = new Stack<>(k);
        for (int i = 0; i < k; i++) {
            kStack.push(que.dequeue());
        }
        for (int i = 0; i < k; i++) {
            que.enqueue(kStack.pop());
        }
        for (int i = 0; i < que.getMaxSize() - k; i++) {
            que.enqueue(que.dequeue());
        }
    }
}
