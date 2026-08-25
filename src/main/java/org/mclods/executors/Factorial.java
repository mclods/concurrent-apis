package org.mclods.executors;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Integer> {
    private final Integer n;

    public Factorial(Integer n) {
        this.n = n;
    }

    @Override
    public Integer call() {
        int factorial = 1;
        for(int i=1; i<=n; ++i) {
            factorial *= i;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception Thrown: " + e);
        }

        return factorial;
    }
}
