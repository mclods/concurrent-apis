package org.mclods.producer_consumer;

public class PCDemo {
    public static void run() {
        Q q = new Q();

        var producerThread = new Thread(new Producer(q), "Producer Thread");
        var consumerThread = new Thread(new Consumer(q), "Consumer Thread");

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Thrown: " + e);
        }

        try {
            consumerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Thrown: " + e);
        }
    }
}
