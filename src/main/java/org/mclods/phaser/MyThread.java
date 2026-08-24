package org.mclods.phaser;

import java.util.concurrent.Phaser;

public class MyThread implements Runnable {
    private final Phaser phaser;

    public MyThread(Phaser phaser) {
        this.phaser = phaser;
        phaser.register();
    }

    @Override
    public void run() {
        for(int i=0; i<2; ++i) {
            System.out.printf("%s beginning phase %d%n",  Thread.currentThread().getName(), i);
            phaser.arriveAndAwaitAdvance();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception Thrown: " + e);
            }
        }

        System.out.printf("%s has completed all phases.%n", Thread.currentThread().getName());
        phaser.arriveAndDeregister();

        System.out.printf("%s is completing execution.%n", Thread.currentThread().getName());
    }
}
