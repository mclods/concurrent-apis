package org.mclods.producer_consumer;

public class Consumer implements Runnable {
    private final Q q;

    public Consumer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            q.get();
        }
    }
}
