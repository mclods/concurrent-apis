package org.mclods.executors;

import java.util.concurrent.Callable;

public class Hypotenuse implements Callable<Double> {
    private final Double base, height;

    public Hypotenuse(Double base, Double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public Double call() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Thrown: " + e);
        }

        return Math.sqrt(base * base + height * height);
    }
}
