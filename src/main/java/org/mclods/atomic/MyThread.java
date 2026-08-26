package org.mclods.atomic;

public class MyThread implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<2; ++i) {
            System.out.printf("%s is updating count.%n", Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception Thrown: " + e);
            }

            int updatedCount = Shared.count.incrementAndGet();
            System.out.printf("%s has updated count to %d.%n", Thread.currentThread().getName(), updatedCount);
        }
    }
}
