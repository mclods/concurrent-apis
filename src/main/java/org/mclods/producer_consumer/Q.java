package org.mclods.producer_consumer;

public class Q {
    private int n;
    private boolean valueSet =  false;

    public synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException caught" + ex);
            }
        }

        valueSet = false;
        System.out.printf("Got %d\n", n);
        notify();
        return n;
    }

    public synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException caught" + ex);
            }
        }

        valueSet = true;
        this.n = n;
        System.out.printf("Put %d\n", n);
        notify();
    }
}
