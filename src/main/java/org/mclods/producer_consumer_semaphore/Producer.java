package org.mclods.producer_consumer_semaphore;

public class Producer implements Runnable {
    private final Q q;

    public Producer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            q.put(i);
        }
    }
}
