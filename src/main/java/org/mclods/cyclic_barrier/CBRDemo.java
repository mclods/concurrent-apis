package org.mclods.cyclic_barrier;

import java.util.concurrent.CyclicBarrier;

public class CBRDemo {
    public static void run() {
        CyclicBarrier barrier = new CyclicBarrier(3, new BarrierAction());

        var thread1 = new Thread(new MyThread(barrier), "MyThread1");
        var thread2 = new Thread(new MyThread(barrier), "MyThread2");
        var thread3 = new Thread(new MyThread(barrier),  "MyThread3");

        thread1.start();
        thread2.start();
        thread3.start();

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
