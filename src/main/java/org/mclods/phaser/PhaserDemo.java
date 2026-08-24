package org.mclods.phaser;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void run() {
        Phaser phaser = new Phaser(1);

        var thread1 = new Thread(new MyThread(phaser), "Thread 1");
        var thread2 = new Thread(new MyThread(phaser), "Thread 2");
        var thread3 = new Thread(new MyThread(phaser), "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();

        for(int i=0; i<3; ++i) {
            System.out.printf("%s beginning phase %d%n", Thread.currentThread().getName(), phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
        }

        System.out.printf("%s has completed all phases.%n", Thread.currentThread().getName());
        phaser.arriveAndDeregister();
        System.out.printf("Phaser is terminated: %s%n", phaser.isTerminated());

        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Thrown: " + e);
        }

        try {
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Thrown: " + e);
        }

        try {
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Thrown: " + e);
        }
    }
}
