package org.mclods.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable {
    private final CyclicBarrier barrier;

    public MyThread(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.printf("%s waiting at barrier%n",  Thread.currentThread().getName());
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("Barrier interrupted: " + e);
        }
        System.out.printf("%s went past barrier%n",  Thread.currentThread().getName());
    }
}
