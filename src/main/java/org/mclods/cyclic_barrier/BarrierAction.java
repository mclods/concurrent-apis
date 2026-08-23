package org.mclods.cyclic_barrier;

public class BarrierAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Barrier Completed!");
    }
}
