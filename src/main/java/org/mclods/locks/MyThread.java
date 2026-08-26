package org.mclods.locks;

import java.util.concurrent.locks.Lock;

public class MyThread implements Runnable {
    private final Lock lock;

    public MyThread(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i=0; i<2; ++i) {
            System.out.printf("%s is locking count.%n", Thread.currentThread().getName());
            lock.lock();
            System.out.printf("%s has locked count.%n", Thread.currentThread().getName());

            Shared.count++;
            System.out.printf("%s has updated count to %d%n", Thread.currentThread().getName(), Shared.count);

            System.out.printf("%s is sleeping.%n", Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception Thrown: " + e);
            } finally {
                System.out.printf("%s is unlocking count.%n", Thread.currentThread().getName());
                lock.unlock();
            }
        }
    }
}
