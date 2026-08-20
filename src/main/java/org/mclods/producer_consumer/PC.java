package org.mclods.producer_consumer;

public class PC {
    public static void run() {
        Q q = new Q();

        new Thread(new Producer(q)).start();
        new Thread(new Consumer(q)).start();
    }
}
