package ReAttempt.Queue;

import Common.Problem;
import Problems.Queues.Queue;
import Problems.Stacks.Stack;

public class ReversingFirstKElements extends Problem {
    @Override
    public void run() {
        System.out.println("Running Reversing First K Elements in Queue");
        Problems.Queues.Queue<Integer> intQueue = new Problems.Queues.Queue<>(10);
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
        intQueue = new Problems.Queues.Queue<>(3);
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
        Stack<V> holdingStack = new Stack<>(k);
        for (int i = 0; i < k; i++) {
            holdingStack.push(que.dequeue());
        }
        while (!holdingStack.isEmpty()) {
            que.enqueue(holdingStack.pop());
        }
        for (int i = 0; i < que.getCurrentSize() - k; i++) {
            que.enqueue(que.dequeue());
        }
    }
}
