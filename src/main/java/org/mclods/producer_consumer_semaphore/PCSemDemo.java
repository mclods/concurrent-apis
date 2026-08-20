package org.mclods.producer_consumer_semaphore;

public class PCSemDemo {
    public static void run() {
        Q q = new Q();

        new Thread(new Producer(q)).start();
        new Thread(new Consumer(q)).start();
    }
}
