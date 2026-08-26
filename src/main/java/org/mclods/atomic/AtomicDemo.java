package org.mclods.atomic;

public class AtomicDemo {
    public static void run() {
        var threadA = new Thread(new MyThread(), "A");
        var threadB = new Thread(new MyThread(), "B");

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
