package org.mclods.producer_consumer_semaphore;

import java.util.concurrent.Semaphore;

public class Q {
    private int n;
    private final Semaphore producerSem, consumerSem;
    private boolean consumerSemAcquired, producerSemAcquired;

    public Q() {
        producerSem = new Semaphore(1);
        consumerSem = new Semaphore(0);
        producerSemAcquired = consumerSemAcquired = false;
    }

    public int get() {
        try {
            consumerSem.acquire();
            consumerSemAcquired = true;
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught" + e);
        }

        if (consumerSemAcquired) {
            System.out.println("Got " + n);
            producerSem.release();
            producerSemAcquired = false;
        }
        return n;
    }

    public void put(int n) {
        try {
            producerSem.acquire();
            producerSemAcquired = true;
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught" + e);
        }

        if (producerSemAcquired) {
            this.n = n;
            System.out.println("Put " + n);
            consumerSem.release();
            consumerSemAcquired = false;
        }
    }
}
