package org.mclods.countdown_latch;

import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable {
    private final CountDownLatch latch;

    public MyThread(CountDownLatch latch) {
        this.latch = latch;
        new Thread(this, "MyThread").start();
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.printf("%s counting i=%d%n", Thread.currentThread().getName(), i);
            latch.countDown();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception Thrown: " + e);
            }
        }
    }
}
