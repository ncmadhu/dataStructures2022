package Algorithms.Queues;

import Algorithms.Algorithms;

public class TestingQueueImplUsingStack extends Algorithms {
    @Override
    public void run() {
        System.out.println("Running Testing Queue Implementation Using stack");
        QueueImplementationUsingStack<Integer> intQueue = new QueueImplementationUsingStack<>(10);
        for (int i = 1; i <= 10; i++) {
            intQueue.enqueue1(i);
        }
        System.out.println("Queue: ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(intQueue.dequeue1() +  ",");
        }
        System.out.println("NULL");
        for (int i = 1; i <= 10; i++) {
            intQueue.enqueue2(i);
        }
        System.out.println("Queue: ");
        System.out.println(intQueue.dequeue2());
        for (int i = 1; i <= 9; i++) {
            System.out.print(intQueue.dequeue2() +  ",");
        }
        System.out.println("NULL");
    }
}
