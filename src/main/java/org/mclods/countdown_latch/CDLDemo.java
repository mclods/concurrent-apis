package org.mclods.countdown_latch;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {
    public static void run() {
        CountDownLatch latch = new CountDownLatch(5);

        new MyThread(latch);
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Thrown: " + e);
        }

        System.out.println("Latch Opened");
    }
}
