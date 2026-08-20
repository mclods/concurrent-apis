package org.mclods.producer_consumer_semaphore;

import java.util.concurrent.Semaphore;

public class Q {
    private int n;
    private static final Semaphore producerSem = new Semaphore(1);
    private static final Semaphore consumerSem = new Semaphore(0);

    public int get() {
        try {
            consumerSem.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught" + e);
        }

        System.out.println("Got " + n);
        producerSem.release();
        return n;
    }

    public void put(int n) {
        try {
            producerSem.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught" + e);
        }

        this.n = n;
        System.out.println("Put " + n);
        consumerSem.release();
    }
}
