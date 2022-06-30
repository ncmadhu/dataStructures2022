package ReAttempt.Queue;

import Common.Problem;
import ReAttempt.Queue.Queue;

public class TestingQueueImplementation extends Problem {
    @Override
    public void run() {
        System.out.println("Running Testing Queue Implementation");
        Queue<Integer> intQueue = new Queue<>(10);
        System.out.println("Queue Max Size: " + intQueue.getMaxSize());
        System.out.println("Queue Empty: " + intQueue.isEmpty());
        System.out.println("Queue Full: " + intQueue.isFull());
        System.out.println("Queue Current Size: " + intQueue.getCurrentSize());
        System.out.print("Queue: ");
        for (int i = 1; i <= 4; i++) {
            System.out.print(i +  ",");
            intQueue.enqueue(i);
        }
        System.out.println("NULL");
        System.out.println("Queue Current Size: " + intQueue.getCurrentSize());
        System.out.println("Queue Top: " + intQueue.top());
        for (int i = 5; i <= 10; i++) {
            System.out.print(i +  ",");
            intQueue.enqueue(i);
        }
        System.out.println("NULL");
        System.out.println("Queue Current Size: " + intQueue.getCurrentSize());
        System.out.println("Queue Full: " + intQueue.isFull());
        System.out.println("Queue Empty: " + intQueue.isEmpty());
        System.out.println("Queue Top: " + intQueue.top());
        for (int i = 1; i <= 4; i++) {
            System.out.print(intQueue.dequeue() +  ",");
        }
        System.out.println("NULL");
        System.out.println("Queue Current Size: " + intQueue.getCurrentSize());
        System.out.println("Queue Top: " + intQueue.top());
        for (int i = 5; i <= 10; i++) {
            System.out.print(intQueue.dequeue() +  ",");
        }
        System.out.println("NULL");
        System.out.println("Queue Current Size: " + intQueue.getCurrentSize());
        System.out.println("Queue Top: " + intQueue.top());
    }
}
