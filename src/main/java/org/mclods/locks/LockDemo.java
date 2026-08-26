package org.mclods.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void run() {
        Lock lock = new ReentrantLock();

        var threadA = new Thread(new MyThread(lock), "A");
        var threadB = new Thread(new MyThread(lock), "B");

        threadA.start();
        threadB.start();

        try {
            threadA.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Thrown: " + e);
        }

        try {
            threadB.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Thrown: " + e);
        }
    }
}
